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
public class Sotilas extends Nappula {

    /**
     * Sotilas perii abstraktin luokan nappula.
     */
    public Sotilas(int x, int y, boolean valkoinenko) {
        super(x, y, valkoinenko);
    }

    @Override
    public String toString() {
        return "s ";
    }

    @Override
    public boolean liiku(int uusiX, int uusiY) {
        return true;
    }
}
