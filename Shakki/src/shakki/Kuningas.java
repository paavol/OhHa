/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki;

/**
 *
 * @author paavolyy
 */
public class Kuningas extends Nappula {

    public Kuningas(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean voikoNappulaLiikkua(int uusiX, int uusiY) {
        if (mahdollinenRuutuLiikkua(uusiX, uusiY) && onkoSijaintiLaudalla(uusiX, uusiY)) {
            setKoordinaatit(uusiX, uusiY);
            return true;
        }
        return false;
    }

    @Override
    public boolean mahdollinenRuutuLiikkua(int uusiX, int uusiY) {
     
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

    @Override
    public String toString() {
        return "K ";
    }
}
