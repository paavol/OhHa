/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki;

/**
 *
 * @author paavolyy
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pelilauta lauta = new Pelilauta();
        lauta.liikutaNappulaa(1, 3, lauta.palautaNappulatListana().get(12));
        lauta.paivitaLauta();

    }
}
