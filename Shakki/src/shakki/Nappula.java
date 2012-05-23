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

    /**
     * Metodi kertoo totuusarvona Nappulan värin (musta/valkoinen).Valkoinenko()
     * ollessa true, nappula on valkoinen.
     *
     * @return
     */
    public final boolean valkoinenko() {
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
     * Abstrakti metodi nappulan liikkumismahdollisuuksista.Määritellään
     * jokaisessa nappulassa erikseen.
     *
     * @param uusiX
     * @param uusiY
     * @return
     */
    public abstract boolean liiku(int uusiX, int uusiY);
}
