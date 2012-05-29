/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki;

import java.util.List;

/**
 * Pelilauta on logiikkaosion tärkein luokka, jossa tapahtuu kaikki nappuloiden
 * hallinnointi ja laudalla liikkuminen.
 *
 * @author Maijanen
 */
public class Pelilauta {

    private Ruutu[][] lauta;
    private Nappula valkoinenKuningas;
    private Nappula mustaKuningas;

    public Pelilauta() {
        this.lauta = new Ruutu[8][8];

    }

    /**
     * Metodi luo shakin alkutilanteen mukaisen laudan nappuloineen.
     */
    public void alustaLauta() {
        luoRuudutPelilautaan();
        luoNappulatRuutuihin();
    }

    public Ruutu[][] getLauta() {
        return lauta;
    }

    /**
     *
     * Liikutetaan haluttua nappulaa uusiin koordinaatteihin, jos kaikki annetut
     * ehdot täyttyvät.Käsitellään myös erikoistilanteita, kuten sotilaan
     * ylenemistä.
     *
     * @param uusiX
     * @param uusiY
     * @param nappula
     */
    public boolean liikutaNappulaa(int vanhaX, int vanhaY, int uusiX, int uusiY, boolean valkoisenVuoro) {
        try {
            if (lauta[vanhaX][vanhaY].getNappula() != null) {
                Nappula apunappula = lauta[vanhaX][vanhaY].getNappula();
                if (apunappula.valkoinenko() != valkoisenVuoro) {
                    return false;
                }
                if (apunappula.voikoLiikkua(uusiX, uusiY)
                        && kulkureitillaEiNappulaa(apunappula, uusiX, uusiY)
                        && voikoRuutuunSiirtya(vanhaX, vanhaY, uusiX, uusiY)) {

                    apunappula.setKoordinaatit(uusiX, uusiY);
                    Nappula apunappula2 = lauta[uusiX][uusiY].getNappula();
                    lauta[uusiX][uusiY].setNappula(apunappula);
                    lauta[vanhaX][vanhaY].setTyhjaksi();

                    if (tuleekoShakki(valkoisenVuoro)) {
                        lauta[uusiX][uusiY].setNappula(apunappula2);
                        lauta[vanhaX][vanhaY].setNappula(apunappula);
                        apunappula.setKoordinaatit(vanhaX, vanhaY);
                    }
                }
            } else {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean peliKaynnissa() {
        return true;
    }

    /**
     * Metodi palauttaa parametreillä annetussa ruudussa olevan nappulan tai sen
     * sisältämän null-viitteen.
     *
     * @param x
     * @param y
     * @return
     */
    public Nappula getNappulaRuudusta(int x, int y) {
        if (lauta[x][y] == null) {
            return null;
        }
        return lauta[x][y].getNappula();
    }

    /**
     * Asettaa laudalle paikkaan x,y ruudun koordinaateilla x,y.
     *
     *
     * @param ruutu
     */
    public void asetaRuutuLaudalle(Ruutu ruutu) {
        lauta[ruutu.getX()][ruutu.getY()] = ruutu;
    }

    private void luoRuudutPelilautaan() {

        for (int i = 0; i < lauta.length; i++) {
            for (int j = 0; j < lauta.length; j++) {
                lauta[i][j] = new Ruutu(i, j);
            }
        }
    }

    private void luoNappulatRuutuihin() {
        try {
            NappulatAlkutilanteessa nappulat = new NappulatAlkutilanteessa();
            for (Nappula nappula : nappulat.getNappulat()) {
                lauta[nappula.getX()][nappula.getY()].setNappula(nappula);
            }
            valkoinenKuningas = lauta[7][4].getNappula();
            mustaKuningas = lauta[0][4].getNappula();
        } catch (Exception e) {
        }

    }

    private boolean muuttuukoSotilasKuningattareksi(int uusiX, int uusiY) {
        Nappula apunappula = lauta[uusiX][uusiY].getNappula();
        if (apunappula.getClass().equals(Sotilas.class)) {
            if (apunappula.valkoinenko) {
                if (apunappula.getX() == 0) {
                    return true;
                }
            } else if (apunappula.getX() == 7) {
                return true;
            }
        }
        return false;
    }

    private void sotilasMuuttuuKuningattareksi(int uusiX, int uusiY) {
        if (lauta[uusiX][uusiY].getNappula().valkoinenko()) {
            lauta[uusiX][uusiY].setNappula(new Kuningatar(uusiX, uusiY, true));
        } else {
            lauta[uusiX][uusiY].setNappula(new Kuningatar(uusiX, uusiY, false));
        }
    }

    private boolean kulkureitillaEiNappulaa(Nappula nappula, int x, int y) {
        List<int[]> reitti = nappula.tallennaReittiTaulukkoon(x, y);
        for (int[] koordinaatit : reitti) {
            if (lauta[ (koordinaatit[ 0])][ (koordinaatit[ 1])].getNappula() != null) {

                return false;
            }
        }
        return true;
    }

    private boolean voikoTornittaa() {
        return true;
    }

    private boolean voikoRuutuunSiirtya(int vanhaX, int vanhaY, int uusiX, int uusiY) {

        if ((onkoRuutuVapaa(uusiX, uusiY)
                && (!(lauta[vanhaX][vanhaY].getNappula().getClass().getName().equals(Sotilas.class.getName()))
                || vanhaY == uusiY))
                || voikoSyoda(vanhaX, vanhaY, uusiX, uusiY)) {

            return true;
        }
        return false;
    }

    /**
     * Metodi tarkistaa onko kyseisessä ruudussa kuningasta.
     *
     * @param uusiX
     * @param uusiY
     * @return
     */
    public boolean ruudussaEiKuningasta(int uusiX, int uusiY) {
        if (lauta[uusiX][uusiY].getNappula().getClass().getName().equals(Kuningas.class.getName())) {
            return false;
        }
        return true;
    }

    private boolean onkoRuutuVapaa(int uusiX, int uusiY) {
        if (lauta[uusiX][uusiY].getNappula() == null) {
            return true;
        }
        return false;
    }

    private boolean voikoSyoda(int vanhaX, int vanhaY, int uusiX, int uusiY) {

        if (lauta[vanhaX][vanhaY].getNappula().valkoinenko()
                != lauta[uusiX][uusiY].getNappula().valkoinenko()
                && ruudussaEiKuningasta(uusiX, uusiY)) {
            return true;
        }
        return false;
    }

    /**
     * Tämän metodin on tarkoitus tarkastaa onko pelitilanne shakki.Toistaiseksi
     * metodi ei tunnista tilanteita.
     *
     * @param valkoinenko
     * @return
     */
    public boolean tuleekoShakki(boolean valkoinenko) {
        int kunkkuX;
        int kunkkuY;
        if (valkoinenko) {
            kunkkuX = valkoinenKuningas.getX();
            kunkkuY = valkoinenKuningas.getY();
        } else {
            kunkkuX = mustaKuningas.getX();
            kunkkuY = mustaKuningas.getY();
        }
//Tutkitaan kaikki kuningakseen pääsevät suunnat. Metodi on ylipitkä mutta silti mielestäni looginen kokonaisuus. Jahka se ensin toimisi...

        for (int x = kunkkuX + 1; x < 8; x++) {
            if (lauta[ x][ kunkkuY] != null) {
                if (lauta[ x][ kunkkuY].getNappula().valkoinenko() != valkoinenko
                        && lauta[ x][ kunkkuY].getNappula().voikoLiikkua(kunkkuX, kunkkuY)) {
                    return true;
                }
                break;
            }
        }

        for (int x = kunkkuX - 1; x >= 0; x--) {
            if (lauta[ x][ kunkkuY] != null) {
                if (lauta[ x][ kunkkuY].getNappula().valkoinenko() != valkoinenko
                        && lauta[ x][ kunkkuY].getNappula().voikoLiikkua(kunkkuX, kunkkuY)) {
                    return true;
                }
                break;
            }
        }

        for (int y = kunkkuY + 1; y < 8; y++) {
            if (lauta[ kunkkuX][ y] != null) {
                if (lauta[ kunkkuX][ y].getNappula().valkoinenko() != valkoinenko
                        && lauta[ kunkkuX][ y].getNappula().voikoLiikkua(kunkkuX, kunkkuY)) {
                    return true;
                }
                break;
            }
        }

        for (int y = kunkkuY - 1; y >= 0; y--) {
            if (lauta[ kunkkuX][ y] != null) {
                if (lauta[ kunkkuX][ y].getNappula().valkoinenko() != valkoinenko
                        && lauta[  kunkkuX][ y].getNappula().voikoLiikkua(kunkkuX, kunkkuY)) {
                    return true;
                }
                break;
            }
        }
        int x = kunkkuX + 1;
        int y = kunkkuY + 1;
        while (x >= 0 && x <= 7 && y >= 0 && y <= 7) {

            if (lauta[ x][ y] != null) {
                if (lauta[ x][ y].getNappula().valkoinenko() != valkoinenko
                        && lauta[  x][ y].getNappula().voikoLiikkua(kunkkuX, kunkkuY)) {
                    return true;
                }
                break;
            }
            x++;
            y++;
        }
        x = kunkkuX + 1;
        y = kunkkuY - 1;
        while (x >= 0 && x <= 7 && y >= 0 && y <= 7) {

            if (lauta[ x][ y] != null) {
                if (lauta[ x][ y].getNappula().valkoinenko() != valkoinenko
                        && lauta[  x][ y].getNappula().voikoLiikkua(kunkkuX, kunkkuY)) {
                    return true;
                }
                break;
            }
            x++;
            y--;
        }
        x = kunkkuX - 1;
        y = kunkkuY + 1;
        while (x >= 0 && x <= 7 && y >= 0 && y <= 7) {

            if (lauta[ x][ y] != null) {
                if (lauta[ x][ y].getNappula().valkoinenko() != valkoinenko
                        && lauta[  x][ y].getNappula().voikoLiikkua(kunkkuX, kunkkuY)) {
                    return true;
                }
                break;
            }
            x--;
            y++;
        }
        x = kunkkuX - 1;
        y = kunkkuY - 1;
        while (x >= 0 && x <= 7 && y >= 0 && y <= 7) {
            if (lauta[ x][ y] != null) {
                if (lauta[ x][ y].getNappula().valkoinenko() != valkoinenko
                        && lauta[  x][ y].getNappula().voikoLiikkua(kunkkuX, kunkkuY)) {
                    return true;
                }
                break;
            }
            x--;
            y--;
        }
        return false;
    }
}
