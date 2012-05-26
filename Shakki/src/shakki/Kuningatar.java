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
        if (uusiY != getY() && uusiX != getX() && muutoksetSamat(uusiX, uusiY)) {
            return true;
        }
        if ((uusiX == getX() && uusiY != getY())
                || (uusiX != getX() && uusiY == getY())) {
            return true;
        }
        return false;
    }

    private boolean muutoksetSamat(int uusiX, int uusiY) {
        int muutosX = Math.abs(uusiX - getX());
        int muutosY = Math.abs(uusiY - getY());
        return muutosX == muutosY;
    }

    @Override
    public List<int[]> tallennaReittiTaulukkoon(int uusiX, int uusiY) {
        int vanhaX = getX();
        int vanhaY = getY();
        int reitinPituus = Math.abs(uusiX - vanhaX) - 1;
        List<int[]> reitti = new ArrayList<int[]>();

        for (int i = 0; i < reitinPituus; i++) {
            if (vanhaX < uusiX) {
                ++vanhaX;
            } else {
                --vanhaX;
            }
            if (vanhaY < uusiY) {
                ++vanhaY;
            } else {
                --vanhaY;
            }
            reitti.add(new int[]{vanhaX, vanhaY});
        }
        return reitti;
    }
}
