/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import java.util.List;

/**
 * Nappula on abstrakti luokka, jonka kaikki shakkinappulaluokat perivät.
 * Nappulalla on olemassa myös abstrakteja metodeja, oliomuuttujat x, y ja
 * final-muuttuja valkoinenko, mikä kertoo nappulan värin.
 *
 * @author paavolyy
 */
public abstract class Nappula {

    private int x;
    private int y;
    final boolean valkoinenko;

    /**
     * Konstruktori saa parametrina koordinaatit x ja y sekä boolean
     * valkoinenko. Valkoinenko-muuttuja kertoo nappulan värin, eikä sitä pysty
     * muuttamaan.
     *
     * @param x
     * @param y
     * @param valkoinenko
     */
    public Nappula(int x, int y, boolean valkoinenko) {

        this.x = x;
        this.y = y;
        this.valkoinenko = valkoinenko;

    }

    /**
     * Palauttaa x:n arvon.
     *
     * @return int
     */
    public int getX() {
        return x;
    }

    /**
     * Metodi kertoo totuusarvona Nappulan värin (musta/valkoinen).
     * Valkoinenko() ollessa true, nappula on valkoinen.
     *
     * @return final boolean valkoinenko
     */
    public final boolean valkoinenko() {
        return valkoinenko;
    }

    /**
     * Palauttaa y:n arvon.
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
     * Abstrakti metodi nappulan liikkumismahdollisuuksista. Määritellään
     * jokaisessa nappulassa erikseen.
     *
     * @param uusiX
     * @param uusiY
     * @return boolean
     */
    public abstract boolean voikoLiikkua(int uusiX, int uusiY);

    /**
     * Abstrakti metodi nappulan kulkemasta reitistä. Määritellään jokaisessa
     * nappulassa erikseen.
     *
     * @param uusiX
     * @param uusiY
     * @return List<int[]>
     */
    public abstract List<int[]> tallennaReittiTaulukkoon(int uusiX, int uusiY);
}
