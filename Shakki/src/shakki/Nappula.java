/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki;

/**
 * Nappula on abstrakti luokka, jonka kaikki shakkinappulaluokat perivät.
 * Nappulalla on olemassa myös abstrakteja metodeja.
 *
 * @author paavolyy
 */
public abstract class Nappula {

    private int x;
    private int y;
    final boolean valkoinenko;

    public Nappula(int x, int y, boolean valkoinenko) {

        this.x = x;
        this.y = y;
        this.valkoinenko = valkoinenko;

    }

    /**
     * Asettaa palauttaa x:n arvon.
     *
     */
    public int getX() {
        return x;
    }

    final boolean valkoinen() {
        return valkoinenko;
    }

    /**
     * Palautta y:n arvon.
     *
     */
    public int getY() {
        return y;
    }

    /**
     * Asettaa oliomuuttujalle x arvoksi parametrin x.
     *
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Asettaa oliomuuttujalle y arvoksi parametrin y.
     *
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Palauttaa nappulan koordinaatit.
     *
     */
    public String getKoordinaatit() {
        return this.x + ", " + this.y;
    }

    /**
     * Metodi kutsuu luokan settereitä ja asettaa parametrina saadut x ja y,
     * oliomuuttujien x ja y arvoksi.
     *
     * @param x
     * @param y
     */
    public void setKoordinaatit(int x, int y) {
        setX(x);
        setY(y);
    }

    /**
     * Tarkistaa onko parametreina annettu sijainti pelilaudalla.
     *
     * @param uusiX
     * @param uusiY
     *
     */
    public boolean onkoSijaintiLaudalla(int uusiX, int uusiY) {
        if (uusiX >= 0 && uusiX <= 7 && uusiY >= 0 && uusiY <= 7) {
            return true;
        }
        return false;
    }

    public abstract boolean liiku(int uusiX, int uusiY);
}
