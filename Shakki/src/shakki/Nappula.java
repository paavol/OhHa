/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki;

/**
 *
 * @author paavolyy
 */
public abstract class Nappula {

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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getKoordinaatit() {
        return this.x + ", " + this.y;
    }

    public void setKoordinaatit(int x, int y) {
        setX(x);
        setY(y);
    }

    public boolean onkoRuutuLaudalla(int uusiX, int uusiY) {
        if (uusiX >= 0 && uusiX <= 7 && uusiY >= 0 && uusiX <= 7) {
            return true;
        }
        return false;
    }

    public abstract boolean voikoNappulaLiikkua(int uusiX, int uusiY);
//    public boolean mahdollinenRuutuLiikkua(int uusiX, int uusiY) {
//        return true;
//    }
//
//    public boolean onkoRuutuLaudalla() {
//        return true;
//    }
//
//    public boolean onkoToinenNappulaRuudussa() {
//        return true;
//    }
//    public boolean syoko() {
//        return true;
//    }
//    @Override
//    public String toString() {
//        return "N ";
//    }
}
