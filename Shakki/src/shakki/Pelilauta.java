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

    private Nappula[][] lauta;
    private NappulatAlkutilanteessa nappulat;
    private Nappula valkoinenKuningas;
    private Nappula mustaKuningas;

    public Pelilauta() {
        this.lauta = new Nappula[8][8];
        nappulat = new NappulatAlkutilanteessa();

    }

    /**
     * Metodi luo shakin alkutilanteen mukaisen laudan nappuloineen.
     */
    public void alustaLauta() {
        luoNappulatPelilautaan();
    }

    public Nappula[][] getLauta() {
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
            if (lauta[vanhaX][vanhaY] != null) {
                Nappula apunappula = lauta[vanhaX][vanhaY];
                if (apunappula.valkoinenko() != valkoisenVuoro) {
                    return false;
                }
                if (apunappula.voikoLiikkua(uusiX, uusiY)
                        && kulkureitillaEiNappulaa(apunappula, uusiX, uusiY)
                        && voikoRuutuunSiirtya(vanhaX, vanhaY, uusiX, uusiY)) {

                    apunappula.setKoordinaatit(uusiX, uusiY);
                    Nappula apunappula2 = lauta[uusiX][uusiY];
                    lauta[uusiX][uusiY] = apunappula;
                    lauta[vanhaX][vanhaY] = null;

                    if (tuleekoShakki(valkoisenVuoro)) {
                        lauta[uusiX][uusiY] = apunappula2;
                        lauta[vanhaX][vanhaY] = apunappula;
                        apunappula.setKoordinaatit(vanhaX, vanhaY);
                        return false;
                    }
                } else {
                    return false;
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
    public Nappula getNappulaLaudalta(int x, int y) {
        if (lauta[x][y] == null) {
            return null;
        }
        return lauta[x][y];
    }

    private void luoNappulatPelilautaan() {
        try {
            for (Nappula nappula : nappulat.getNappulat()) {
                lauta[nappula.getX()][nappula.getY()] = nappula;
            }
            valkoinenKuningas = lauta[7][4];
            mustaKuningas = lauta[0][4];
        } catch (Exception e) {
        }

    }

    private boolean kulkureitillaEiNappulaa(Nappula nappula, int x, int y) {
        List<int[]> reitti = nappula.tallennaReittiTaulukkoon(x, y);
        for (int[] koordinaatit : reitti) {
            if (lauta[ (koordinaatit[ 0])][ (koordinaatit[ 1])] != null) {
                return false;
            }
        }
        return true;
    }

    private boolean voikoRuutuunSiirtya(int vanhaX, int vanhaY, int uusiX, int uusiY) {

        if ((onkoRuutuVapaa(uusiX, uusiY)
                && (!(lauta[vanhaX][vanhaY].getClass().getName().equals(Sotilas.class.getName()))
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
        if (lauta[uusiX][uusiY].getClass().getName().equals(Kuningas.class.getName())) {
            return false;
        }
        return true;
    }

    private boolean onkoRuutuVapaa(int uusiX, int uusiY) {
        if (lauta[uusiX][uusiY] == null) {
            return true;
        }
        return false;
    }

    private boolean voikoSyoda(int vanhaX, int vanhaY, int uusiX, int uusiY) {

        if (lauta[vanhaX][vanhaY].valkoinenko()
                != lauta[uusiX][uusiY].valkoinenko()
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
       
        {


            for (int x = kunkkuX + 1; x < 8; x++) {
                if (lauta[ x][ kunkkuY] != null) {
                    if (lauta[ x][ kunkkuY].valkoinenko() != valkoinenko
                            && lauta[ x][ kunkkuY].voikoLiikkua(kunkkuX, kunkkuY)) {
                        return true;
                    }
                    break;
                }
            }
        }

        for (int x = kunkkuX - 1; x >= 0; x--) {
            if (lauta[ x][ kunkkuY] != null) {
                if (lauta[ x][ kunkkuY].valkoinenko() != valkoinenko
                        && lauta[ x][ kunkkuY].voikoLiikkua(kunkkuX, kunkkuY)) {
                    return true;
                }
                break;
            }
        }

        for (int y = kunkkuY + 1; y < 8; y++) {
            if (lauta[ kunkkuX][ y] != null) {
                if (lauta[ kunkkuX][ y].valkoinenko() != valkoinenko
                        && lauta[ kunkkuX][ y].voikoLiikkua(kunkkuX, kunkkuY)) {
                    return true;
                }
                break;
            }
        }

        for (int y = kunkkuY - 1; y >= 0; y--) {
            if (lauta[ kunkkuX][ y] != null) {
                if (lauta[ kunkkuX][ y].valkoinenko() != valkoinenko
                        && lauta[  kunkkuX][ y].voikoLiikkua(kunkkuX, kunkkuY)) {
                    return true;
                }
                break;
            }
        }
        int x = kunkkuX + 1;
        int y = kunkkuY + 1;
        while (x >= 0 && x <= 7 && y >= 0 && y <= 7) {

            if (lauta[ x][ y] != null) {
                if (lauta[ x][ y].valkoinenko() != valkoinenko
                        && lauta[  x][ y].voikoLiikkua(kunkkuX, kunkkuY)) {
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
                if (lauta[ x][ y].valkoinenko() != valkoinenko
                        && lauta[  x][ y].voikoLiikkua(kunkkuX, kunkkuY)) {
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
                if (lauta[ x][ y].valkoinenko() != valkoinenko
                        && lauta[  x][ y].voikoLiikkua(kunkkuX, kunkkuY)) {
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
                if (lauta[ x][ y].valkoinenko() != valkoinenko
                        && lauta[  x][ y].voikoLiikkua(kunkkuX, kunkkuY)) {
                    return true;
                }
                break;
            }
            x--;
            y--;
        }
        return false;
    }

    private boolean voikoTornittaa() {
        return true;
    }

    private boolean muuttuukoSotilasKuningattareksi(int uusiX, int uusiY) {
        Nappula apunappula = lauta[uusiX][uusiY];
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
        if (lauta[uusiX][uusiY].valkoinenko()) {
            lauta[uusiX][uusiY] = new Kuningatar(uusiX, uusiY, true);
        } else {
            lauta[uusiX][uusiY] = new Kuningatar(uusiX, uusiY, false);
        }
    }
}
