/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki;

import java.util.List;

/**
 * Abstraktin Nappula-luokan perivä luokka, joka pitää sisällään kyseisen
 * shakkinappulan erikoistoiminnot.
 *
 * @author Maijanen
 */
public class Torni extends Nappula {

    /**
     * Torni perii konstruktorissaan parametrit Nappula-luokasta.
     *
     * @param x
     * @param y
     * @param valkoinenko
     */
    public Torni(int x, int y, boolean valkoinenko) {
        super(x, y, valkoinenko);
    }

    /**
     * Tornin toString.
     *
     * @return
     */
    @Override
    public String toString() {
        return "T ";
    }

    /**
     * Metodi kertoo tornin shakkisääntöjen mukaiset liikkumismahdollisuudet ja
     * palauttaa true, mikäli siirto on mahdollinen.
     *
     * @param uusiX
     * @param uusiY
     *
     */
    @Override
    public boolean voikoLiikkua(int uusiX, int uusiY) {
        if ((uusiX == getX() && uusiY >= 0 && uusiY != getY())
                || ((uusiX >= 0 && uusiX != getX() && uusiY == getY()))) {
            return true;
        }
        return false;
    }

    @Override
    public List<int[]> reitillaEiNappuloita(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
