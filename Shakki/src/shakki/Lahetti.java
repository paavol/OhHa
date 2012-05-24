/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstraktin Nappula-luokan perivä luokka, joka pitää sisällään kyseisen
 * shakkinappulan erikoistoiminnot.
 *
 * @author Maijanen
 */
public class Lahetti extends Nappula {

    /**
     * Lahetti perii konstruktorissaan parametrit Nappula-luokalta.
     *
     * @param x
     * @param y
     * @param valkoinenko
     */
    public Lahetti(int x, int y, boolean valkoinenko) {
        super(x, y, valkoinenko);
    }

    @Override
    public String toString() {
        return "L ";
    }

    /**
     * Metodi tarkistaa lähetin shakkisääntöjen mukaiset liikkeet ja palauttaa
     * true, jos liike on mahdollinen.
     *
     * @param uusiX
     * @param uusiY
     * @return
     */
    @Override
    public boolean voikoLiikkua(int uusiX, int uusiY) {
        int muutosX = Math.abs(uusiX - getX());
        int muutosY = Math.abs(uusiY - getY());

        if (uusiY != getY() && uusiX != getX() && muutosX == muutosY) {
            return true;
        }
        return false;
    }

    @Override
    public List<int[]> reitillaEiNappuloita(int x, int y) {
        int xx = getX();
        int yy = getY();
        List<int[]> reitti = new ArrayList<int[]>();
        while (xx != x && yy != y) {
            if (xx < x) {
                ++xx;
            } else {
                --xx;
            }
            if (yy < y) {
                ++yy;
            } else {
                --yy;
            }

            reitti.add(new int[]{xx, yy});
        }
        reitti.remove(reitti.size());
        return reitti;
    }

}
