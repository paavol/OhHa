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
public class Torni extends Nappula {

    /**
     * Torni perii konstruktorissaan parametrit Nappula-luokasta.
     *
     * @param x
     * @param y
     * @param valkoinenko
     */
    public Torni(int x, int y, boolean valkoinenko) {
        super(x, y, valkoinenko);
    }

    /**
     * Tornin toString.
     *
     * @return
     */
    @Override
    public String toString() {
        return "T ";
    }

    /**
     * Metodi kertoo tornin shakkisääntöjen mukaiset liikkumismahdollisuudet ja
     * palauttaa true, mikäli siirto on mahdollinen.TOISTOA!!
     *
     * @param x
     * @param y
     *
     */
    @Override
    public boolean voikoLiikkua(int x, int y) {
        if ((x == getX() && y != getY())
                || ((x != getX() && y == getY()))) {
            return true;
        }
        return false;
    }

    @Override
    public List<int[]> tallennaReittiTaulukkoon(int x, int y) {
        int xx = getX();
        int yy = getY();
        List<int[]> reitti = new ArrayList<int[]>();
        while ((xx != x && yy == y) || (yy != y && xx == x)) {
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
        if (reitti.size() >= 1) {
            reitti.remove(reitti.get(reitti.size()));
        }
        return reitti;
    }
}
