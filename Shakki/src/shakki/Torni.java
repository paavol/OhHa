/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki;

/**
 *
 * @author Maijanen
 */
public class Torni extends Nappula {

    public Torni(int x, int y) {
        super(x, y);
    }

    @Override
    public String toString() {
        return "T ";
    }

    @Override
    public boolean voikoNappulaLiikkua(int uusiX, int uusiY) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
