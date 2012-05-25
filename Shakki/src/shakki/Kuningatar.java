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
public class Kuningatar extends Nappula {

    /**
     * Kuningatar perii konstruktorissaan parametrit Nappula-luokalta.
     *
     * @param x
     * @param y
     * @param valkoinenko
     */
    public Kuningatar(int x, int y, boolean valkoinenko) {
        super(x, y, valkoinenko);
    }

    /**
     * Kuningattaren toString.
     *
     */
    @Override
    public String toString() {
        return "Q ";
    }

    /**
     * Metodi tarkistaa pystyykö nappula liikkumaan annettuihin parametreihin
     * Kuningattaran shakkisääntöjen mukaisin liikkein.
     *
     * @param uusiX
     * @param uusiY
     *
     */
    @Override
    public boolean voikoLiikkua(int uusiX, int uusiY) {
        int muutosX = Math.abs(uusiX - getX());
        int muutosY = Math.abs(uusiY - getY());
        if (uusiY != getY() && uusiX != getX() && muutosX == muutosY) {
            return true;
        }
        if ((uusiX == getX() && uusiY != getY())
                || (uusiX != getX() && uusiY == getY())) {
            return true;
        }
        return false;
    }

    @Override
    public List<int[]> tallennaReittiTaulukkoon(int x, int y) {
        int xx = getX();
        int yy = getY();
        List<int[]> reitti = new ArrayList<int[]>();
        while (voikoLiikkua(x, y)) {
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
