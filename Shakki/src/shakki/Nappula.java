/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki;

/**
 *
 * @author paavolyy
 */
public class Nappula {

    private int x;
    private int y;
 
    public Nappula(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

//    public void liiku(int uusiX, int uusiY) {
//        if (mahdollinenRuutuLiikkua(uusiX, uusiY) && onkoRuutuLaudalla()
//                && onkoToinenNappulaRuudussa() == false) {
//            this.x = uusiX;
//            this.y = uusiY;
//        }
//    }

    public boolean mahdollinenRuutuLiikkua(int uusiX, int uusiY) {
        return true;
    }

    public boolean onkoRuutuLaudalla() {
        return true;
    }

    public boolean onkoToinenNappulaRuudussa() {
        return true;
    }

    public boolean syoko() {
        return true;
    }

    @Override
    public String toString() {
        return "N ";
    }
}
