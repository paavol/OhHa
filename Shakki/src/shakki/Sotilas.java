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
public class Sotilas extends Nappula {

    /**
     * Sotilas perii konstruktorissaan parametrit Nappula-luokasta.
     *
     * @param x
     * @param y
     * @param valkoinenko
     */
    public Sotilas(int x, int y, boolean valkoinenko) {
        super(x, y, valkoinenko);
    }

    /**
     * Sotilaan toString.
     *
     * @return
     */
    @Override
    public String toString() {
        return "s ";
    }

    /**
     * Metodi tarkistaa sotilaan shakkisääntöjen mukaiset siirrot ja palauttaa
     * true, mikäli siirto parametreina saatuihin koordinaatteihin on
     * mahdollinen.
     *
     * @param uusiX
     * @param uusiY
     * @return
     */
    public boolean valkoisenLiikkuminen(int uusiX, int uusiY) {
        if (this.valkoinenko) {
            if (getX() == 6) {
                if ((uusiX < getX() && uusiX >= getX() - 2 && uusiY == getY())) {
                    return true;
                }
            } else if ((uusiX == getX() - 1) && uusiY == getY()) {
                return true;
            }

        }
        return false;
    }

    public boolean mustanLiikkuminen(int uusiX, int uusiY) {
        if (this.valkoinenko == false) {
            if (getX() == 1) {
                if ((uusiX > getX() && uusiX <= getX() + 2 && uusiY == getY())) {
                    return true;
                }
            } else if ((uusiX == getX() + 1) && uusiY == getY()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean voikoLiikkua(int uusiX, int uusiY) {
        if (valkoisenLiikkuminen(uusiX, uusiY) || mustanLiikkuminen(uusiX, uusiY)) {
            return true;
        }
        return false;
    }

    @Override
    public List<int[]> reitillaEiNappuloita(int x, int y) {
        int xx = getX();
        int yy = getY();
        List<int[]> reitti = new ArrayList<int[]>();

        if (valkoisenLiikkuminen(x, y)) {
            while (xx > x && yy == y) {
                --xx;
                reitti.add(new int[]{xx, yy});
            }
        } else {
            while (xx < x && yy == y) {
                ++xx;
                reitti.add(new int[]{xx, yy});
            }
        }
        reitti.remove(reitti.size());
        return reitti;
    }
}
