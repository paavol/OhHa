/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

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
     * Lahetti perii konstruktorissaan parametrit Nappula-luokalta.Lisäksi
     * lähetillä on värin mukaan määritelty imageIcon.
     *
     * @param x
     * @param y
     * @param valkoinenko
     */
    public Lahetti(int x, int y, boolean valkoinenko) {
        super(x, y, valkoinenko);
    }

    /**
     * Lähetin toString.
     *
     * @return
     */
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
        if (uusiY != getY() && uusiX != getX() && muutoksetSamat(uusiX, uusiY)) {
            return true;
        }
        return false;
    }

    private boolean muutoksetSamat(int uusiX, int uusiY) {
        int muutosX = Math.abs(uusiX - getX());
        int muutosY = Math.abs(uusiY - getY());
        return muutosX == muutosY;
    }

    /**
     * Nappula-luokalta peritty metodi, joka palauttaa taulukon, jossa on
     * tallennettuna lähetin uusiin koordinaatteihin kulkema reitti.
     *
     * @param uusiX
     * @param uusiY
     * @return
     */
    @Override
    public List<int[]> tallennaReittiTaulukkoon(int uusiX, int uusiY) {
        int vanhaX = getX();
        int vanhaY = getY();
        int reitinPituus = Math.abs(uusiX - vanhaX) - 1;
        List<int[]> reitti = new ArrayList<int[]>();
        if (!muutoksetSamat(uusiX, uusiY)) {
            return reitti;
        }
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
