/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki;

/**
 * Nappula on abstrakti luokka, jonka kaikki shakkinappulaluokat perivät.
 * Nappulalla on olemassa myös abstrakteja metodeja.
 *
 * @author paavolyy
 */
public abstract class Nappula {

    private int x;
    private int y;
    final boolean valkoinenko;

    public Nappula(int x, int y, boolean valkoinenko) {

        this.x = x;
        this.y = y;
        this.valkoinenko = valkoinenko;

    }

    /**
     * Asettaa palauttaa x:n arvon.
     *
     */
    public int getX() {
        return x;
    }

    final boolean valkoinen() {
        return valkoinenko;
    }

    /**
     * Palautta y:n arvon.
     *
     */
    public int getY() {
        return y;
    }

    /**
     * Asettaa oliomuuttujalle x arvoksi parametrin x.
     *
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Asettaa oliomuuttujalle y arvoksi parametrin y.
     *
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Palauttaa nappulan koordinaatit.
     *
     */
    public String getKoordinaatit() {
        return this.x + ", " + this.y;
    }

    /**
     * Metodi kutsuu luokan settereitä ja asettaa parametrina saadut x ja y,
     * oliomuuttujien x ja y arvoksi.
     *
     * @param x
     * @param y
     */
    public void setKoordinaatit(int x, int y) {
        setX(x);
        setY(y);
    }

    /**
     * Tarkistaa onko parametreina annettu sijainti pelilaudalla.
     *
     * @param uusiX
     * @param uusiY
     *
     */
    public boolean onkoSijaintiLaudalla(int uusiX, int uusiY) {
        if (uusiX >= 0 && uusiX <= 7 && uusiY >= 0 && uusiY <= 7) {
            return true;
        }
        return false;
    }

    public abstract boolean liiku(int uusiX, int uusiY);
//    /**
//     * Metodi kertoo pystyykö nappulaa liikuttamaan haluttuun ruutuun.
//     *
//     * @param uusiX
//     * @param uusiY
//     *
//     */
//    public abstract boolean voikoNappulaLiikkua(int uusiX, int uusiY);
//    /**
//     * Metodi kertoo onko kyseistä nappulaa mahdollista siirtää parametrina
//     * annettuun ruutuun.
//     *
//     * @param uusiX
//     * @param uusiY
//     *
//     */
//    public boolean onkoToinenNappulaRuudussa() {
//        return true;
//    }
//    public boolean syoko() {
//        return true;
//    }
//    @Override
//    public String toString() {
//        return "N ";
//    }
//    public boolean liikkuminenAlas(int uusiX, int uusiY) {
//        if (uusiX <= getX()) {
//            return false;
//        }
//        if (uusiY != getY()) {
//            return false;
//        }
////
////        for (int i = getX(); i < uusiX; i++) {
////            if (lauta[getX() + i][uusiY] != null) {
////                return false;
////            }
////        }
//        return true;
//    }
//
//    public boolean liikkuminenYlos(int uusiX, int uusiY) {
//        if (uusiX >= getX()) {
//            return false;
//        }
//        if (uusiY != getY()) {
//            return false;
//        }
////        for (int i = getX(); i > uusiX; i--) {
////            if (lauta[getX() - i][uusiY] != null) {
////                return false;
////            }
////        }
//        return true;
//    }
//
//    public boolean liikkuminenOikealle(int uusiX, int uusiY) {
//        if (uusiX != getX()) {
//            return false;
//        }
//        if (uusiY <= getY()) {
//            return false;
//        }
////        for (int i = getY(); i < uusiY; i++) {
////            if (lauta[getX()][getY() + i] != null) {
////                return false;
////            }
////        }
//        return true;
//    }
//
//    public boolean liikkuminenVasemmalle(int uusiX, int uusiY) {
//        if (uusiX != getX()) {
//            return false;
//        }
//        if (uusiY >= getY()) {
//            return false;
//        }
////        for (int i = getY(); i > uusiY; i--) {
////            if (lauta[getX()][getY() - i] != null) {
////                return false;
////            }
////        }
//        return true;
//    }
//
//    private boolean vinostiLiikkuminen(int uusiX, int uusiY) {
//        int muutosX = Math.abs(uusiX - getX());
//        int muutosY = Math.abs(uusiY - getY());
//        if (muutosX != muutosY) {
//            return false;
//        }
//        return true;
//    }
//    public boolean liikkuminenYlaoikealle(int uusiX, int uusiY) {
//        if (uusiX >= getX()) {
//            return false;
//        }
//        if (uusiY <= getY()) {
//            return false;
//        }
//        if (vinostiLiikkuminen(uusiX, uusiY) == false) {
//            return false;
//        }
////        for (int i = 1; i < Math.abs(uusiX - getX()); i++) {
////            if (lauta[getX() - i][getY() + i] != null) {
////                return false;
////            }
////        }
//        return true;
//    }
//
//    public boolean liikkuminenYlavasemmalle(int uusiX, int uusiY) {
//        if (uusiX >= getX()) {
//            return false;
//        }
//        if (uusiY >= getY()) {
//            return false;
//        }
//        if (vinostiLiikkuminen(uusiX, uusiY) == false) {
//            return false;
//        }
////        for (int i = 1; i < Math.abs(uusiX - getX()); i++) {
////            if (lauta[getX() - i][getY() - i] != null) {
////                return false;
////            }
////        }
//        return true;
//    }
//
//    public boolean liikkuminenAlaoikealle(int uusiX, int uusiY) {
//        if (uusiX <= getX()) {
//            return false;
//        }
//        if (uusiY <= getY()) {
//            return false;
//        }
//        if (vinostiLiikkuminen(uusiX, uusiY) == false) {
//            return false;
//        }
////        for (int i = 1; i < Math.abs(uusiX - getX()); i++) {
////            if (lauta[getX() + i][getY() + i] != null) {
////                return false;
////            }
////        }
//        return true;
//    }
//
//    public boolean liikkuminenAlavasemmalle(int uusiX, int uusiY) {
//        if (uusiX <= getX()) {
//            return false;
//        }
//        if (uusiY >= getY()) {
//            return false;
//        }
//        if (vinostiLiikkuminen(uusiX, uusiY) == false) {
//            return false;
//        }
////        for (int i = 1; i < Math.abs(uusiX - getX()); i++) {
////            if (lauta[getX() + i][getY() - i] != null) {
////                return false;
////            }
////        }
//        return true;
//    }
//
//    private boolean hevosenLiikkuminen() {
//        if (getClass() == Hevonen.class) {
//            return true;
//        }
//        return false;
//    }
//
//    private boolean jokinReittiAvoinna(int uusiX, int uusiY) {
//
//        return liikkuminenOikealle(uusiX, uusiY)
//                || liikkuminenVasemmalle(uusiX, uusiY)
//                || liikkuminenAlas(uusiX, uusiY)
//                || liikkuminenYlos(uusiX, uusiY)
//                || liikkuminenAlaoikealle(uusiX, uusiY)
//                || liikkuminenAlavasemmalle(uusiX, uusiY)
//                || liikkuminenYlavasemmalle(uusiX, uusiY)
//                || liikkuminenYlaoikealle(uusiX, uusiY)
//                || hevosenLiikkuminen();
//    }
//
//    private boolean kulkureitillaEiNappulaa(int uusiX, int uusiY) {
//        if (jokinReittiAvoinna(uusiX, uusiY)) {
//            return true;
//        }
//        return false;
//    }
}
