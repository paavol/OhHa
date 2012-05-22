/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki;

/**
 * Abstraktin Nappula-luokan perivä luokka, joka pitää sisällään kyseisen
 * shakkinappulan erikoistoiminnot.
 *
 * @author Maijanen
 */
public class Lahetti extends Nappula {

    /**
     * Lahetti perii abstraktin luokan Nappula.
     *
     * @param x
     * @param y
     */
    public Lahetti(int x, int y, boolean valkoinenko) {
        super(x, y, valkoinenko);
    }

    @Override
    public String toString() {
        return "L ";
    }

    @Override
    public boolean liiku(int uusiX, int uusiY) {
        int muutosX = Math.abs(uusiX - getX());
        int muutosY = Math.abs(uusiY - getY());

        if (uusiY != getY() && uusiX != getX() && muutosX == muutosY) {
            return true;
        }
        return false;
    }
}
