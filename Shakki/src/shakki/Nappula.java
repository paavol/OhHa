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

    public void liiku(int uusiX, int uusiY) {

        this.x = uusiX;
        this.y = uusiY;
    }

    public boolean onkoMahdollinen(int uusiX, int uusiY) {
        return true;
    }

    public boolean laudalla() {
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
