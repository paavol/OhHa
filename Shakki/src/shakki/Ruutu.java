/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki;

import javax.swing.JPanel;

/**
 *
 * @author paavolyy
 */
public class Ruutu extends JPanel {

    private int x;
    private int y;
    private Nappula nappi;

    /**
     * Ruutu saa parametrina koordinaatit x ja y sekä asettaa oletuksena
     * ruudussa olevan/olemattoman Nappulan arvoksi null.
     *
     * @param x
     * @param y
     */
    public Ruutu(int x, int y) {
        this.x = x;
        this.y = y;
        this.nappi = null;
    }

    /**
     * Palauttaa x-koordinaatin.
     *
     * @return
     */
    @Override
    public int getX() {
        return x;
    }

    /**
     * Palauttaa y-koordinaatin.
     *
     * @return
     */
    @Override
    public int getY() {
        return y;
    }

    /**
     * Asettaa x:lle uuden arvon.
     *
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Asettaa y:lle uuden arvon.
     *
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Asettaa ruudussa olevan Nappulan arvoksi parametrina saadun Nappulan.
     *
     * @param nappi
     */
    public void setNappula(Nappula nappi) {
        this.nappi = nappi;
    }

    /**
     * Palauttaa Nappulan.
     *
     * @return
     */
    public Nappula getNappula() {
        return nappi;
    }

    /**
     * Asettaa Nappulan arvoksi null.
     */
    public void setTyhjaksi() {
        this.nappi = null;
    }
}
