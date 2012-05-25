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
    private boolean valkoisenLiikkuminen(int uusiX, int uusiY) {
        if (this.valkoinenko) {
            if (getX() == 6) {
                return (liikkuuKaksiYlos(uusiX, uusiY) || liikkuuYhdenYlos(uusiX, uusiY)
                        || valkoinenSyoKulmittain(uusiX, uusiY));
            } else if (liikkuuYhdenYlos(uusiX, uusiY) || valkoinenSyoKulmittain(uusiX, uusiY)) {
                return true;
            }
        }
        return false;
    }

    private boolean mustanLiikkuminen(int uusiX, int uusiY) {
        if (this.valkoinenko == false) {
            if (getX() == 1) {
                return (liikkuuKaksiAlas(uusiX, uusiY) || liikkuuYhdenAlas(uusiX, uusiY));
            } else if (liikkuuYhdenAlas(uusiX, uusiY)) {
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

    private boolean valkoinenSyoKulmittain(int uusiX, int uusiY) {
        return ((uusiX == getX() - 1) && (uusiY == getY() + 1
                || uusiY == getY() - 1));
    }

    private boolean liikkuuYhdenYlos(int uusiX, int uusiY) {
        return ((uusiX == getX() - 1) && uusiY == getY());
    }

    private boolean liikkuuKaksiYlos(int uusiX, int uusiY) {
        return ((uusiX == getX() - 2) && uusiY == getY());
    }

    private boolean liikkuuYhdenAlas(int uusiX, int uusiY) {
        return ((uusiX == getX() + 1) && uusiY == getY());
    }

    private boolean liikkuuKaksiAlas(int uusiX, int uusiY) {
        return ((uusiX == getX() + 2) && uusiY == getY());
    }

    @Override
    public List<int[]> tallennaReittiTaulukkoon(int uusiX, int uusiY) {

        int vanhaX = getX();
        int vanhaY = getY();
        if (Math.abs(uusiX - vanhaX) < 2) {
            return new ArrayList<int[]>();
        }
        List<int[]> reitti = new ArrayList<int[]>();

        if (uusiX < vanhaX) {
            reitti.add(new int[]{vanhaX - 1, vanhaY});

        } else if (uusiX > vanhaX) {
            reitti.add(new int[]{vanhaX + 1, vanhaY});
        }
        return reitti;
    }
}
