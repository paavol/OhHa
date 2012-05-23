/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki;

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

        luoPelilauta();
    }

    /**
     *
     * Liikutetaan haluttua nappulaa uusiin koordinaatteihin, jos kaikki annetut
     * ehdot täyttyvät.
     *
     * @param uusiX
     * @param uusiY
     * @param nappula
     */
    public void liikutaNappulaa(int vanhaX, int vanhaY, int uusiX, int uusiY) {
        if (lauta[vanhaX][vanhaY].getNappula() != null) {
            if (lauta[vanhaX][vanhaY].getNappula().liiku(uusiX, uusiY) 
                    && onkoRuutuLaudalla(lauta[uusiX][uusiY])
                    && kulkureitillaEiNappulaa(uusiX, uusiY, lauta[vanhaX][vanhaY])
                    && onkoRuutuVapaa(uusiX, uusiY)
                    ) {
                lauta[vanhaX][vanhaY].setNappula(lauta[vanhaX][vanhaY].getNappula());
            }
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
        return lauta[x][y].getNappula();
    }

    /**
     * Luo uuden kuvan pelilaudan tilanteesta.
     */
    public void paivitaLauta() {
        luoPelilauta();
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

    private void luoPelilauta() {
        System.out.println("");
        luoRuudutPelilautaan();
        for (Ruutu[] rivi : lauta) {
            for (Ruutu ruutu : rivi) {

                if (ruutu.getNappula() != null) {
                    System.out.print(ruutu.getNappula());
                }
                if (ruutu.getNappula() == null) {
                    System.out.print("_ ");
                }

            }
            System.out.println("");
        }
        System.out.println("");
    }

    private boolean onkoRuutuVapaa(int uusiX, int uusiY) {
        if (lauta[uusiX][uusiY].getNappula() == null) {
            return true;
        }
        return false;
    }

    private boolean onkoRuutuLaudalla(Ruutu ruutu) {
        if (ruutu.getX() > 7 || ruutu.getX() < 0 || ruutu.getY() > 7 || ruutu.getY() < 0) {
            return false;
        }
        return true;
    }

    private boolean kulkureitillaEiNappulaa(int uusiX, int uusiY, Ruutu ruutu) {

        return liikkuminenOikealle(uusiX, uusiY, ruutu)
                || liikkuminenVasemmalle(uusiX, uusiY, ruutu)
                || liikkuminenAlas(uusiX, uusiY, ruutu)
                || liikkuminenYlos(uusiX, uusiY, ruutu)
                || liikkuminenAlaoikealle(uusiX, uusiY, ruutu)
                || liikkuminenAlavasemmalle(uusiX, uusiY, ruutu)
                || liikkuminenYlavasemmalle(uusiX, uusiY, ruutu)
                || liikkuminenYlaoikealle(uusiX, uusiY, ruutu)
                || hevosenLiikkuminen(ruutu);
    }

    private boolean liikkuminenAlas(int uusiX, int uusiY, Ruutu ruutu) {
        if (uusiX <= ruutu.getNappula().getX()) {
            return false;
        }
        if (uusiY != ruutu.getNappula().getY()) {
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
        if (uusiX >= ruutu.getNappula().getX()) {
            return false;
        }
        if (uusiY != ruutu.getNappula().getY()) {
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
        if (uusiX != ruutu.getNappula().getX()) {
            return false;
        }
        if (uusiY <= ruutu.getNappula().getY()) {
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
        if (uusiX != ruutu.getNappula().getX()) {
            return false;
        }
        if (uusiY >= ruutu.getNappula().getY()) {
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
        if (uusiX >= ruutu.getNappula().getX()) {
            return false;
        }
        if (uusiY <= ruutu.getNappula().getY()) {
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
        if (uusiX >= ruutu.getNappula().getX()) {
            return false;
        }
        if (uusiY >= ruutu.getNappula().getY()) {
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
        if (uusiX <= ruutu.getNappula().getX()) {
            return false;
        }
        if (uusiY <= ruutu.getNappula().getY()) {
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
        if (uusiX <= ruutu.getNappula().getX()) {
            return false;
        }
        if (uusiY >= ruutu.getNappula().getY()) {
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
