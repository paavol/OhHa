/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki;

/**
 *
 * @author Maijanen
 */
public class Sotilas extends Nappula {

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
}
