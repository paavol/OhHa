/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki;

/**
 * Abstraktin Nappula-luokan perivä luokka, joka pitää sisällään kyseisen shakkinappulan erikoistoiminnot.
 * @author Maijanen
 */
public class Hevonen extends Nappula {

    public Hevonen(int x, int y) {
        super(x, y);
    }

    /**
     * Hevosen toString.
     *
     */
    @Override
    public String toString() {
        return "H ";
    }

    /**
     * Metodi tarkistaa pystyykö nappula liikkumaan annettuihin
     * parametreihin.Metodi tarkistaa samalla onko haluttu liike Hevosen
     * oikeaoppisen liikkumisen mukainen ja onko parametreina annettu
     * koordinaatti shakkilaudalla.
     *
     * @param uusiX
     * @param uusiY
     * 
     */
    @Override
    public boolean voikoNappulaLiikkua(int uusiX, int uusiY) {
        if (mahdollinenRuutuLiikkua(uusiX, uusiY) && onkoSijaintiLaudalla(uusiX, uusiY)) {
            setKoordinaatit(uusiX, uusiY);
            return true;
        }
        return false;
    }
/**
 * Metodi kertoo hevosen oikeaoppiset liikkeet.
 * @param uusiX
 * @param uusiY
 * 
 */
    @Override
    public boolean mahdollinenRuutuLiikkua(int uusiX, int uusiY) {
        if (uusiX == getX() - 1 && uusiY == getY() - 2
                || uusiX == getX() - 2 && uusiY == getY() - 1
                || uusiX == getX() - 2 && uusiY == getY() + 1
                || uusiX == getX() - 1 && uusiY == getY() + 2
                || uusiX == getX() + 1 && uusiY == getY() - 2
                || uusiX == getX() + 2 && uusiY == getY() - 1
                || uusiX == getX() + 2 && uusiY == getY() + 1
                || uusiX == getX() + 1 && uusiY == getY() + 2) {
            return true;
        }
        return false;
    }
}
