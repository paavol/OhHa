/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import javax.swing.JLabel;

/**
 *
 * @author Maijanen
 */
public class Ruutu extends JLabel {

    private int i;
    private int j;

    public Ruutu(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return this.i;
    }

    public int getJ() {
        return this.j;
    }
}
