/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki;

/**
 * Abstraktin Nappula-luokan perivä luokka, joka pitää sisällään kyseisen shakkinappulan erikoistoiminnot.
 * @author Maijanen
 */
public class Sotilas extends Nappula {

    /**
     * Sotilas perii abstraktin luokan nappula.
     */
    public Sotilas(int x, int y) {
        super(x, y);
    }

    @Override
    public String toString() {
        return "S ";
    }

    @Override
    public boolean voikoNappulaLiikkua(int uusiX, int uusiY) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean mahdollinenRuutuLiikkua(int uusiX, int uusiY) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
