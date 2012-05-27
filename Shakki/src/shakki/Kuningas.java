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
 * @author paavolyy
 */
public class Kuningas extends Nappula {

    /**
     * Konstruktori luo Kuningas luokan ilmentymän, joka saa parametreina x- ja
     * y-koordinaatit ja perii abstraktin Nappula-luokan.
     *
     * @param x
     * @param y
     * @param valkoinenko
     */
    public Kuningas(int x, int y, boolean valkoinenko) {
        super(x, y, valkoinenko);
    }

    /**
     * Metodi tarkistaa kuninkaan shakkisääntöjen mukaisen liikkumisen.Kuninkaan
     * liikkeillä on kaikkiaan kahdeksan eri mahdollisuutta, joista vähintään
     * yhden toteutuessa metodi palauttaa true.
     *
     * @param uusiX
     * @param uusiY
     *
     */
    @Override
    public boolean voikoLiikkua(int uusiX, int uusiY) {
        return kuninkaanMahdollisetLiikkumiset(uusiX, uusiY);
    }

    private boolean kuninkaanMahdollisetLiikkumiset(int uusiX, int uusiY) {
        int muutosX = Math.abs(uusiX - getX());
        int muutosY = Math.abs(uusiY - getY());
        if (muutosX == 0 && muutosY == 0) {
            return false;
        }
        return (muutosX >= -1 && muutosX <= 1 && muutosY >= -1 && muutosY <= 1);
    }

    /**
     * Kuningas-luokan toString.
     *
     *
     */
    @Override
    public String toString() {
        return "K ";
    }

    @Override
    public List<int[]> tallennaReittiTaulukkoon(int x, int y) {
        return new ArrayList<int[]>();
    }
}
