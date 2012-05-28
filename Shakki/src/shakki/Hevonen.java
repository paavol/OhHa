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
public class Hevonen extends Nappula {

    /**
     * Hevonen perii konstruktorissaan parametrit Nappula-luokalta.Lisäksi
     * hevosella on värin mukaan määritelty imageIcon.
     *
     * @param x
     * @param y
     * @param valkoinenko
     */
    public Hevonen(int x, int y, boolean valkoinenko) {
        super(x, y, valkoinenko);
        if (valkoinenko) {
            icon = new ImageIcon("/cs/fs/home/paavolyy/OhHa/nappulakuvakkeet/1.gif");
        } else {
            icon = new ImageIcon("/cs/fs/home/paavolyy/OhHa/nappulakuvakkeet/7.gif");
        }
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
    }

    private boolean hevosenMahdollisetLiikkumiset(int uusiX, int uusiY) {
        int muutosX = Math.abs(uusiX - getX());
        int muutosY = Math.abs(uusiY - getY());
        return ((muutosX == 2 && muutosY == 1) || (muutosX == 1 && muutosY == 2));
    }

    /**
     * Nappula-luokalta peritty metodi, jota ei tarvitse hevoselle toteuttaa,
     * koska hevosella ei ole reittiä, vaan ainoastaan lähtöpiste ja päätepiste.
     *
     * @param x
     * @param y
     * @return
     */
    @Override
    public List<int[]> tallennaReittiTaulukkoon(int x, int y) {
        return new ArrayList<int[]>();
    }
}
