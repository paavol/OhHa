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
        System.out.println("pöö");
    }

    public Ruutu[][] getLauta() {
        return lauta;
    }

    /**
     * Peli on käynnissä metodin ollessa true.Saa arvokseen false, kun peli
     * loppuu.
     *
     * @return
     */
    public boolean peliKaynnissa() {
        while (onMatti() == true || onPatti() == true) {
            return false;
        }
        return true;
    }

    public boolean onMatti() {
        return false;
    }

    public boolean onShakki() {
        return false;
    }

    public boolean onPatti() {
        return false;
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
                    if (muuttuukoSotilasKuningattareksi(uusiX, uusiY)) {
                        sotilasMuuttuuKuningattareksi(uusiX, uusiY);
                    } else {
                        lauta[uusiX][uusiY].setNappula(apunappula);
                    }
                    apunappula.setKoordinaatit(uusiX, uusiY);
                    lauta[vanhaX][vanhaY].setTyhjaksi();
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
    public Nappula getNappulaRuudusta(int x, int y) {
        if (lauta[x][y] == null) {
            return null;
        }
        return lauta[x][y].getNappula();
    }

    /**
     * Luo uuden kuvan pelilaudan tilanteesta.
     */
//    public void paivitaLauta() {
//        luoPelilauta();
//    }
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
//
//    private void luoPelilauta() {
//        System.out.println("");
//
//        for (Ruutu[] rivi : lauta) {
//            for (Ruutu ruutu : rivi) {
//                if (ruutu.getNappula() != null) {
//                    System.out.print(ruutu.getNappula());
//                }
//                if (ruutu.getNappula() == null) {
//                    System.out.print("_ ");
//                }
//            }
//            System.out.println("");
//        }
//        System.out.println("");
//    }

    private boolean voikoRuutuunSiirtya(int vanhaX, int vanhaY, int uusiX, int uusiY) {
        if (onkoRuutuVapaa(uusiX, uusiY) || voikoSyoda(vanhaX, vanhaY, uusiX, uusiY)) {
            return true;
        }
        return false;
    }

    private boolean onkoRuutuVapaa(int uusiX, int uusiY) {
        if (lauta[uusiX][uusiY].getNappula() == null) {
            return true;
        }
        return false;
    }

    private boolean voikoSyoda(int vanhaX, int vanhaY, int uusiX, int uusiY) {
        if (lauta[vanhaX][vanhaY].getNappula().valkoinenko()
                != lauta[uusiX][uusiY].getNappula().valkoinenko()) {
            return true;
        }
        return false;
    }
//
//    private boolean onkoRuutuLaudalla(Ruutu ruutu) {
//
//        if (ruutu == null) {
//            return false;
//        }
//        if (ruutu.getX() > 7 || ruutu.getX() < 0 || ruutu.getY() > 7 || ruutu.getY() < 0) {
//            return false;
//        }
//        return true;
//    }

    private boolean muuttuukoSotilasKuningattareksi(int uusiX, int uusiY) {
        try {
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
        } catch (Exception e) {
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
        List<int[]> reitti = nappula.reitillaEiNappuloita(x, y);
        for (int[] koordinaatit : reitti) {

            if (lauta[ (koordinaatit[ 0])][ (koordinaatit[ 1])].getNappula() != null) {
                return false;
            }
        }
        return true;
    }

    private boolean liikkuminenAlas(int uusiX, int uusiY, Ruutu ruutu) {
        if (uusiX <= ruutu.getX()) {
            return false;
        }
        if (uusiY != ruutu.getY()) {
            return false;
        }

        for (int i = ruutu.getNappula().getX(); i < uusiX; i++) {
            if (lauta[ruutu.getNappula().getX() + i][uusiY] != null) {
                return false;
            }
        }
        return true;
    }

    private boolean liikkuminenYlos(int uusiX, int uusiY, Ruutu ruutu) {
        if (uusiX >= ruutu.getX()) {
            return false;
        }
        if (uusiY != ruutu.getY()) {
            return false;
        }
        for (int i = ruutu.getNappula().getX(); i > uusiX; i--) {
            if (lauta[ruutu.getNappula().getX() - i][uusiY] != null) {
                return false;
            }
        }
        return true;
    }

    private boolean liikkuminenOikealle(int uusiX, int uusiY, Ruutu ruutu) {
        if (uusiX != ruutu.getX()) {
            return false;
        }
        if (uusiY <= ruutu.getY()) {
            return false;
        }
        for (int i = ruutu.getNappula().getY(); i < uusiY; i++) {
            if (lauta[ruutu.getNappula().getX()][ruutu.getNappula().getY() + i] != null) {
                return false;
            }
        }
        return true;
    }

    private boolean liikkuminenVasemmalle(int uusiX, int uusiY, Ruutu ruutu) {
        if (uusiX != ruutu.getX()) {
            return false;
        }
        if (uusiY >= ruutu.getY()) {
            return false;
        }
        for (int i = ruutu.getNappula().getY(); i > uusiY; i--) {
            if (lauta[ruutu.getNappula().getX()][ruutu.getNappula().getY() - i] != null) {
                return false;
            }
        }
        return true;
    }

    private boolean liikkuminenYlaoikealle(int uusiX, int uusiY, Ruutu ruutu) {
        if (uusiX >= ruutu.getX()) {
            return false;
        }
        if (uusiY <= ruutu.getY()) {
            return false;
        }
        if (vinostiLiikkuminen(uusiX, uusiY, ruutu.getNappula()) == false) {
            return false;
        }
        for (int i = 1; i < Math.abs(uusiX - ruutu.getNappula().getX()); i++) {
            if (lauta[ruutu.getNappula().getX() - i][ruutu.getNappula().getY() + i] != null) {
                return false;
            }
        }
        return true;
    }

    private boolean liikkuminenYlavasemmalle(int uusiX, int uusiY, Ruutu ruutu) {
        if (uusiX >= ruutu.getX()) {
            return false;
        }
        if (uusiY >= ruutu.getY()) {
            return false;
        }
        if (vinostiLiikkuminen(uusiX, uusiY, ruutu.getNappula()) == false) {
            return false;
        }
        for (int i = 1; i < Math.abs(uusiX - ruutu.getNappula().getX()); i++) {
            if (lauta[ruutu.getNappula().getX() - i][ruutu.getNappula().getY() - i] != null) {
                return false;
            }
        }
        return true;
    }

    private boolean liikkuminenAlaoikealle(int uusiX, int uusiY, Ruutu ruutu) {
        if (uusiX <= ruutu.getX()) {
            return false;
        }
        if (uusiY <= ruutu.getY()) {
            return false;
        }
        if (vinostiLiikkuminen(uusiX, uusiY, ruutu.getNappula()) == false) {
            return false;
        }
        for (int i = 1; i < Math.abs(uusiX - ruutu.getNappula().getX()); i++) {
            if (lauta[ruutu.getNappula().getX() + i][ruutu.getNappula().getY() + i] != null) {
                return false;
            }
        }
        return true;
    }

    private boolean liikkuminenAlavasemmalle(int uusiX, int uusiY, Ruutu ruutu) {
        if (uusiX <= ruutu.getX()) {
            return false;
        }
        if (uusiY >= ruutu.getY()) {
            return false;
        }
        if (vinostiLiikkuminen(uusiX, uusiY, ruutu.getNappula()) == false) {
            return false;
        }
        for (int i = 1; i < Math.abs(uusiX - ruutu.getNappula().getX()); i++) {
            if (lauta[ruutu.getNappula().getX() + i][ruutu.getNappula().getY() - i] != null) {
                return false;
            }
        }
        return true;
    }

    private boolean vinostiLiikkuminen(int uusiX, int uusiY, Nappula nappula) {
        int muutosX = Math.abs(uusiX - nappula.getX());
        int muutosY = Math.abs(uusiY - nappula.getY());
        if (muutosX != muutosY) {
            return false;
        }
        return true;
    }

    private boolean hevosenLiikkuminen(Ruutu ruutu) {
        if (ruutu.getNappula().getClass() == Hevonen.class) {
            return true;
        }
        return false;
    }
}
