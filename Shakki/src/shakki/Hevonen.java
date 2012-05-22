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
public class Hevonen extends Nappula {

    public Hevonen(int x, int y, boolean valkoinenko) {
        super(x, y, valkoinenko);
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
     * Metodi kertoo hevosen oikeaoppiset liikkeet.
     *
     * @param uusiX
     * @param uusiY
     *
     */
    @Override
    public boolean liiku(int uusiX, int uusiY) {
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
