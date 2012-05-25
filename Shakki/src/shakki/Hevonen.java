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
public class Hevonen extends Nappula {

    /**
     * Hevonen perii konstruktorissaan parametrit Nappula-luokalta.
     *
     * @param x
     * @param y
     * @param valkoinenko
     */
    public Hevonen(int x, int y, boolean valkoinenko) {
        super(x, y, valkoinenko);
    }

    /**
     * Hevosen toString.
     *
     */
    @Override
    public String toString() {
        return "H ";
    }

    /**
     * Metodi kertoo hevosen shakkisääntöjen mukaiset liikkeet.
     *
     * @param uusiX
     * @param uusiY
     *
     */
    @Override
    public boolean voikoLiikkua(int uusiX, int uusiY) {
        return hevosenMahdollisetLiikkumiset(uusiX, uusiY);
//        if (uusiX == getX() - 1 && uusiY == getY() - 2
//                || uusiX == getX() - 2 && uusiY == getY() - 1
//                || uusiX == getX() - 2 && uusiY == getY() + 1
//                || uusiX == getX() - 1 && uusiY == getY() + 2
//                || uusiX == getX() + 1 && uusiY == getY() - 2
//                || uusiX == getX() + 2 && uusiY == getY() - 1
//                || uusiX == getX() + 2 && uusiY == getY() + 1
//                || uusiX == getX() + 1 && uusiY == getY() + 2) {
//            return true;
//        }
//        return false;
    }

    private boolean hevosenMahdollisetLiikkumiset(int uusiX, int uusiY) {
        int muutosX = Math.abs(uusiX - getX());
        int muutosY = Math.abs(uusiY - getY());
        return (muutosX == 2 && muutosY == 1 || muutosX == 1 && muutosY == 2);
    }

    @Override
    public List<int[]> tallennaReittiTaulukkoon(int x, int y) {
        return new ArrayList<int[]>();
    }
}
