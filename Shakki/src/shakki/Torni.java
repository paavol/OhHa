/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 * Abstraktin Nappula-luokan perivä luokka, joka pitää sisällään kyseisen
 * shakkinappulan erikoistoiminnot.
 *
 * @author Maijanen
 */
public class Torni extends Nappula {

    /**
     * Torni perii konstruktorissaan parametrit Nappula-luokasta.Lisäksi
     * tornilla on värin mukaan määritelty imageIcon.
     *
     * @param x
     * @param y
     * @param valkoinenko
     */
    public Torni(int x, int y, boolean valkoinenko) {
        super(x, y, valkoinenko);
        if (valkoinenko) {
            icon = new ImageIcon("nappulakuvakkeet/3.gif");
        } else {
            icon = new ImageIcon("nappulakuvakkeet/9.gif");
        }
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

    /**
     * Nappula-luokalta peritty metodi joka palauttaa taulukon, jossa on
     * tallennettuna tornin uusiin koordinaatteihin kulkema reitti.
     *
     * @param uusiX
     * @param uusiY
     * @return
     */
    @Override
    public List<int[]> tallennaReittiTaulukkoon(int uusiX, int uusiY) {
        int vanhaX = getX();
        int vanhaY = getY();
        int muutettavaX = vanhaX;
        int muutettavaY = vanhaY;

        int reitinPituus = Math.abs(uusiX - vanhaX) - 1;
        List<int[]> reitti = new ArrayList<int[]>();

        for (int i = 0; i < reitinPituus; i++) {
            if (vanhaY == uusiY) {
                if (muutettavaX < uusiX) {
                    ++muutettavaX;
                } else {
                    --muutettavaX;
                }
            } else if (vanhaX == uusiX) {
                if (muutettavaY < uusiY) {
                    ++muutettavaY;
                } else {
                    --muutettavaY;
                }
            }

            System.out.println("hintero");
            System.out.println(muutettavaX);
            System.out.println(muutettavaY);
            reitti.add(new int[]{muutettavaX, muutettavaY});
        }
        return reitti;
    }
}
