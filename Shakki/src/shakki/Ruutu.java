/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki;

/**
 *
 * @author paavolyy
 */
public class Ruutu {

    private int x;
    private int y;
    private Nappula nappi;

    public Ruutu(int x, int y) {
        this.x = x;
        this.y = y;
        this.nappi = null;
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

    public void setNappula(Nappula nappi) {
        this.nappi = nappi;
    }

    public Nappula getNappula() {
        return nappi;
    }

    public boolean onkoRuutuTyhja() {
        return nappi == null;
    }

}
