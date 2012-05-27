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
    private NappulatAlkutilanteessa nappulat;

    public Pelilauta() {
        this.lauta = new Ruutu[8][8];
        this.nappulat = new NappulatAlkutilanteessa();
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
                        && voikoRuutuunSiirtya(vanhaX, vanhaY, uusiX, uusiY)
                        && eiTulisiShakkia(vanhaX, vanhaY, uusiX, uusiY)) {
                    System.out.println("meni shakituksen ohi");
                    apunappula.setKoordinaatit(uusiX, uusiY);
                    lauta[uusiX][uusiY].setNappula(apunappula);
                    lauta[vanhaX][vanhaY].setTyhjaksi();
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

    public boolean eiTulisiShakkia(int vanhaX, int vanhaY, int uusiX, int uusiY) {
        if (lauta[vanhaX][vanhaY].getNappula().valkoinenko()) {
            for (Nappula nappula : nappulat.getNappulat()) {
                if (nappula.valkoinenko() == false) {
                    if (pystyykoNappulaShakittamaan(nappula)) {
                        return false;
                    }
                }
            }
            System.out.println("ohitti ekan pisteen");
        } else {
            for (Nappula nappula : nappulat.getNappulat()) {
                if (nappula.valkoinenko()) {
                    if (pystyykoNappulaShakittamaan(nappula)) {
                        return false;
                    }
                }
            }
        }
        System.out.println("ohitti tokan pisteen");
        return true;
    }

    public boolean pystyykoNappulaShakittamaan(Nappula nappula) {

        if (nappula.valkoinenko()) {
            int mustanKunkunX = nappulat.mustanKunkunSijainti().getX();
            int mustanKunkunY = nappulat.mustanKunkunSijainti().getY();
            System.out.println("jonkun nappulan shakitus");
            if (nappula.voikoLiikkua(mustanKunkunX, mustanKunkunY)
                    && kulkureitillaEiNappulaa(nappula, mustanKunkunX, mustanKunkunY)
                    && voikoRuutuunSiirtya(nappula.getX(), nappula.getY(), mustanKunkunX, mustanKunkunY)) {
            }
            System.out.println("ohitti shakituksen ekan");
            return true;
        } else if (nappula.valkoinenko() == false) {
            int valkoisenKunkunX = nappulat.valkoisenKunkunSijainti().getX();
            int valkoisenKunkunY = nappulat.valkoisenKunkunSijainti().getY();
            System.out.println("jonkun napin shakki");
            if (nappula.voikoLiikkua(valkoisenKunkunX, valkoisenKunkunY)
                    && kulkureitillaEiNappulaa(nappula, valkoisenKunkunX, valkoisenKunkunY)) {
            }
            System.out.println("ohitti shakituksen tokan");
            return true;
        } else {
            System.out.println("falset shakitukseen pystymisestä");
            return false;
        }
    }

    public boolean peliKaynnissa() {
//        while (onMatti() == true || onPatti() == true) {
//            return false;
//        }
        return true;
    }

    public boolean onMatti(int vanhaX, int vanhaY) {
        if (shakkitilanne(vanhaX, vanhaY) && eiVoiLiikkuaMihinkaan(vanhaX, vanhaY)) {
            return true;
        }
        return false;
    }

    public boolean eiVoiLiikkuaMihinkaan(int vanhaX, int vanhaY) {
        return false;
    }

    private boolean shakkitilanne(int uusiX, int uusiY) {
        return true;
    }

    public boolean onPatti(int vanhaX, int vanhaY) {
        if (!shakkitilanne(vanhaX, vanhaY) && eiVoiLiikkuaMihinkaan(vanhaX, vanhaY)) {
            return true;
        }
        return false;
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
        luoNappulatRuutuihin();
    }

    private void luoNappulatRuutuihin() {
        try {
            for (Nappula nappula : nappulat.getNappulat()) {
                lauta[nappula.getX()][nappula.getY()].setNappula(nappula);
            }
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

    private boolean voikoOhittaa() {
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
        System.out.println("voikosyoda");
        if (lauta[vanhaX][vanhaY].getNappula().valkoinenko()
                != lauta[uusiX][uusiY].getNappula().valkoinenko()
                && ruudussaEiKuningasta(uusiX, uusiY)) {
            return true;
        }
        return false;
    }
    /**
     * Peli on käynnissä metodin ollessa true.Saa arvokseen false, kun peli
     * loppuu.
     *
     * @return
     */
}
