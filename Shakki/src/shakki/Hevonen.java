/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki;

/**
 *
 * @author Maijanen
 */
public class Hevonen extends Nappula {

    public Hevonen(int x, int y) {
        super(x, y);
    }

    @Override
    public String toString() {
        return "H ";
    }

      @Override
    public boolean voikoNappulaLiikkua(int uusiX, int uusiY) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
