/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki;

/**
 *
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

    @Override
    public boolean voikoNappulaLiikkua(int uusiX, int uusiY) {
        if (mahdollinenRuutuLiikkua(uusiX, uusiY) && onkoSijaintiLaudalla(uusiX, uusiY)) {
            setKoordinaatit(uusiX, uusiY);
            return true;
        }
        return false;
    }

    @Override
    public boolean kulkureitillaEiToistaNappulaa(int uusiX, int uusiY) {
//        if (uusiX > getX() + 1 || uusiY > getY() + 1 || uusiX < getX() - 1 || uusiY < getY() - 1) {
//            if (uusiX == getX() + 1 && uusiY == getY()) {
//            }
//            if (uusiX == getX() + 1 && uusiY == getY() - 1) {
//            }
//            if (uusiX == getX() + 1 && uusiY == getY() + 1) {
//            }
//            if (uusiX == getX() - 1 && uusiY == getY()) {
//            }
//        }
//        for (int i = 0; i < 7; i++) {
//            for (int j = 0; j < 7; j++) {
//            }
//        }
        return true;
    }

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
