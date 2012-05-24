/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki;

/**
 * Abstraktin Nappula-luokan perivä luokka, joka pitää sisällään kyseisen
 * shakkinappulan erikoistoiminnot.
 *
 * @author paavolyy
 */
public class Kuningas extends Nappula {

    /**
     * Konstruktori luo Kuningas luokan ilmentymän, joka saa parametreina x- ja
     * y-koordinaatit ja perii abstraktin Nappula-luokan.
     *
     * @param x
     * @param y
     * @param valkoinenko 
     */
    public Kuningas(int x, int y, boolean valkoinenko) {
        super(x, y, valkoinenko);
    }

    /**
     * Metodi tarkistaa kuninkaan shakkisääntöjen mukaisen liikkumisen.Kuninkaan
     * liikkeillä on kaikkiaan kahdeksan eri mahdollisuutta, joista vähintään
     * yhden toteutuessa metodi palauttaa true.
     *
     * @param uusiX
     * @param uusiY
     *
     */
    @Override
    public boolean voikoLiikkua(int uusiX, int uusiY) {

        if (uusiX == getX() + 1 && uusiY == getY()
                || uusiX == getX() + 1 && uusiY == getY() - 1
                || uusiX == getX() + 1 && uusiY == getY() + 1
                || uusiX == getX() - 1 && uusiY == getY()
                || uusiX == getX() - 1 && uusiY == getY() - 1
                || uusiX == getX() - 1 && uusiY == getY() + 1
                || uusiX == getX() && uusiY == getY()
                || uusiX == getX() && uusiY == getY() - 1
                || uusiX == getX() && uusiY == getY() + 1) {
            return true;
        }
        return false;
    }

    /**
     * Kuningas-luokan toString.
     *
     *
     */
    @Override
    public String toString() {
        return "K ";
    }
}
