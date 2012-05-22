/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki;

/**
 * Abstraktin Nappula-luokan perivä luokka, joka pitää sisällään kyseisen
 * shakkinappulan erikoistoiminnot.
 *
 * @author Maijanen
 */
public class Kuningatar extends Nappula {

    /**
     * Kuningatar perii konstruktorissaan Nappula-luokan.
     *
     * @param x
     * @param y
     */
    public Kuningatar(int x, int y, boolean valkoinenko) {
        super(x, y, valkoinenko);
    }

    /**
     * Kuningattaren toString.
     *
     */
    @Override
    public String toString() {
        return "Q ";
    }

//    /**
//     * Metodi tarkistaa pystyykö nappula liikkumaan annettuihin
//     * parametreihin.Metodi tarkistaa samalla onko haluttu liike Kuningattaren
//     * oikeaoppisen liikkumisen mukainen ja onko parametreina annettu
//     * koordinaatti shakkilaudalla.
//     *
//     * @param uusiX
//     * @param uusiY
//     *
//     */
//    @Override
//    public boolean voikoNappulaLiikkua(int uusiX, int uusiY) {
//        if (mahdollinenRuutuLiikkua(uusiX, uusiY) && onkoSijaintiLaudalla(uusiX, uusiY)) {
//            setKoordinaatit(uusiX, uusiY);
//            return true;
//        }
//        return false;
//    }
    /**
     * Kertoo kuningattaren sääntöjen mukaiset liikemahdollisuudet.Metodi
     * palauttaa aina arvon true, koska Kuningatar pystyy liikkumaan kaikkien
     * Pelilaudalla määriteltyjen tapojen mukaisesti.
     *
     * @param uusiX
     * @param uusiY
     *
     */
    @Override
    public boolean liiku(int uusiX, int uusiY) {
        int muutosX = Math.abs(uusiX - getX());
        int muutosY = Math.abs(uusiY - getY());
        if (uusiY != getY() && uusiX != getX() && muutosX == muutosY) {
            return true;
        }
        if (uusiX == getX() && uusiY != getY()) {
            return true;
        }
        return false;
    }
}
