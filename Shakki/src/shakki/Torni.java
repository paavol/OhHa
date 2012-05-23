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
public class Torni extends Nappula {

    public Torni(int x, int y,boolean valkoinenko) {
        super(x, y,valkoinenko);
    }

    @Override
    public String toString() {
        return "T ";
    }

    /**
     *
     * @param uusiX
     * @param uusiY
     *
     */
    /**
     * Metodi kertoo tornin shakkisääntöjen mukaiset liikkumismahdollisuudet.
     *
     * @param uusiX
     * @param uusiY
     *
     */
    @Override
    public boolean liiku(int uusiX, int uusiY) {
        if ((uusiX == getX() && uusiY >= 0 && uusiY != getY())
                || ((uusiX >= 0 && uusiX != getX() && uusiY == getY()))) {
            return true;
        }
        return false;
    }
 
}
