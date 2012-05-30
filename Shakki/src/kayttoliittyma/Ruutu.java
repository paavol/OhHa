/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import javax.swing.JLabel;

/**
 * Ruutu-luokka perii JLabelin, jonka lisäksi se sisältää omat koordinaatit i ja
 * j sekä getterit niille.
 *
 * @author Maijanen
 */
public class Ruutu extends JLabel {

    private int i;
    private int j;

    /**
     * Luo uuden Ruutu-olion, joka saa parametrina koordinaatit.
     *
     * @param i
     * @param j
     */
    public Ruutu(int i, int j) {
        this.i = i;
        this.j = j;
    }

    /**
     * Getteri i:lle.
     *
     * @return
     */
    public int getI() {
        return this.i;
    }

    /**
     * Getteri j:lle
     *
     * @return
     */
    public int getJ() {
        return this.j;
    }
}
