/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

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

    /**
     * Metodi palauttaa kaksiulotteisen taulukon "laudan".
     *
     * @return
     */
    public Nappula[][] getLauta() {
        return lauta;
    }

    /**
     * Metodilla pystyy lisäämään nappuloita laudalle esimerkiksi, jos haluaa
     * pelata kulmashakkia tai linnoitusshakkia.Tämä metodi siis mahdollistaa
     * pelin muokkaamisen helposti.
     *
     * @param nappula
     */
    public void lisaaNappulaLaudalle(Nappula nappula) {
        lauta[nappula.getX()][nappula.getY()] = nappula;
    }

    /**
     *
     * Liikutetaan haluttua nappulaa uusiin koordinaatteihin, jos kaikki annetut
     * ehdot täyttyvät.Käsitellään myös erikoistilanteita, kuten sotilaan
     * ylenemistä ja shakkia.Shakkitarkastus tapahtuu jokaisen vuoron lopussa,
     * jolloin pelaaja ei ikinä pysty siirtämään kuningasta
     * shakkitilanteeseen.Jos taas vastapelaaja on shakittanut, niin vuoron
     * loputtua on saatava shakkitilanne pois tai liikutaNappulaa ei hyväksy
     * toimintaa.
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
                    if (muuttuukoSotilasKuningattareksi(apunappula)) {
                    }
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
        if (lauta[uusiX][uusiY] != null) {
            if (lauta[uusiX][uusiY].getClass().getName().equals(Kuningas.class.getName())) {
                return false;
            }
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
    private boolean tuleekoShakki(boolean valkoinenko) {
        int kunkkuX;
        int kunkkuY;
        if (valkoinenko) {
            kunkkuX = valkoinenKuningas.getX();
            kunkkuY = valkoinenKuningas.getY();
        } else {
            kunkkuX = mustaKuningas.getX();
            kunkkuY = mustaKuningas.getY();
        }
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                if (lauta[i][j].valkoinenko() != valkoinenko
//                        && lauta[i][j].voikoLiikkua(kunkkuX, kunkkuY)) {
//                    return true;
//                }
//
//            }
//        }
        //     Tutkitaan kaikki kuninkaaseen pääsevät suunnat.Metodi on ylipitkä mutta silti mielestäni looginen kokonaisuus. Jahka se ensin toimisi        

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

//        for (Nappula nappula : nappulat.getNappulat()) {
//            if (nappula.getClass().getName().equals(Hevonen.class.getName())) {
//                if (nappula.valkoinenko() != valkoinenko
//                        && nappula.voikoLiikkua(kunkkuX, kunkkuY)) {
//                    return true;
//                }
//            }
//        }

        return false;
    }
    
    private boolean voikoTornittaa() {
        return true;
    }
    
    private boolean muuttuukoSotilasKuningattareksi(Nappula nappula) {
        nappula = lauta[nappula.getX()][nappula.getY()];
        if (nappula.getClass().equals(Sotilas.class)) {
            if (nappula.getX() == 0 || nappula.getX() == 7) {
                if (nappula.valkoinenko) {
                    sotilasMuuttuuKuningattareksi(nappula);
                    return true;
                } else {
                    sotilasMuuttuuKuningattareksi(nappula);
                }
            }
        }
        return false;
    }
    
    private void sotilasMuuttuuKuningattareksi(Nappula nappula) {
        
        nappula = lauta[nappula.getX()][nappula.getY()];
        if (nappula.valkoinenko()) {
            lisaaNappulaLaudalle(new Kuningatar(nappula.getX(), nappula.getY(), true));
        } else {
            lisaaNappulaLaudalle(new Kuningatar(nappula.getX(), nappula.getY(), false));
        }
        
    }
}
