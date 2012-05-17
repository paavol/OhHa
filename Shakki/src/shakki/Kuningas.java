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

//    @Override
//    public void liiku(int uusiX, int uusiY) {
//        if (mahdollinenRuutuLiikkua(uusiX, uusiY)) {
//            super.liiku(uusiX, uusiY);
//        }
//    }

    @Override
    public boolean mahdollinenRuutuLiikkua(int uusiX, int uusiY) {
        if (uusiX == super.getX() + 1 || uusiX == super.getX() - 1 || uusiX == super.getX()
                && uusiY == super.getY() + 1 || uusiY == super.getY() - 1 || uusiY == super.getY()
                || uusiX == super.getX() + 1 && uusiY == super.getY() + 1
                || uusiX == super.getX() + 1 && uusiY == super.getY() - 1
                || uusiX == super.getX() - 1 && uusiY == super.getY() + 1
                || uusiX == super.getX() - 1 && uusiY == super.getY() - 1) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "K ";
    }
}
