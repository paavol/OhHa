/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki;

/**
 *
 * @author Maijanen
 */
public class Hevonen extends Nappula {

    public Hevonen(int x, int y) {
        super(x, y);
    }

    @Override
    public String toString() {
        return "H ";
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
