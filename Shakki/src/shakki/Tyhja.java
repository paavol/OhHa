/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maijanen
 */
public class Tyhja extends Nappula {

    public Tyhja(int x, int y, boolean valkoinenko) {
        super(x, y, false);
    }

    @Override
    public boolean voikoLiikkua(int uusiX, int uusiY) {
        return false;
    }

    @Override
    public List<int[]> tallennaReittiTaulukkoon(int uusiX, int uusiY) {
        return new ArrayList<int[]>();
    }
}
