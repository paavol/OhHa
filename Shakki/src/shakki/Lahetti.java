/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki;

/**
 *
 * @author Maijanen
 */
public class Lahetti extends Nappula {

    public Lahetti(int x, int y) {
        super(x, y);
    }

    @Override
    public String toString() {
        return "L ";
    }

    @Override
    public boolean voikoNappulaLiikkua(int uusiX, int uusiY) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean mahdollinenRuutuLiikkua(int uusiX, int uusiY) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean kulkureitillaEiToistaNappulaa(int uusiX, int uusiY) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   
}
