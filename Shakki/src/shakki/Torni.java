/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki;

/**
 * Abstraktin Nappula-luokan perivä luokka, joka pitää sisällään kyseisen shakkinappulan erikoistoiminnot.
 * @author Maijanen
 */
public class Torni extends Nappula {

    public Torni(int x, int y) {
        super(x, y);
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
    @Override
    public boolean voikoNappulaLiikkua(int uusiX, int uusiY) {
        if (mahdollinenRuutuLiikkua(uusiX, uusiY) && onkoSijaintiLaudalla(uusiX, uusiY)) {
            setKoordinaatit(uusiX, uusiY);
            return true;
        }
        return false;
    }

    /**
     * Toistaiseksi keskeneräinen metodi kertoo tornin sääntöjen mukaiset
     * liikkumismahdollisuudet.
     *
     * @param uusiX
     * @param uusiY
     *
     */
    @Override
    public boolean mahdollinenRuutuLiikkua(int uusiX, int uusiY) {

        if (uusiX <= getX() + 7 && uusiY == getY() + 7
                || uusiX <= getX() + 7 && uusiY <= getY() - 7
                || uusiX <= getX() - 7 && uusiY <= getY() + 7
                || uusiX <= getX() - 7 && uusiY <= getY() - 7) {
            if (uusiX > getX()) {
            }
            if (uusiX < getX()) {
            }
            if (uusiY > getY()) {
            }
            if (uusiY < getY()) {
            }
            return true;
        }
        return false;
    }
}
