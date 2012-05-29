/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki;

import Kayttoliittyma.GraafinenKayttoliittyma;

/**
 * Shakki-luokka luo uuden pelilaudan ja käyttöliittymän, sekä käynnistää pelin.
 *
 * @author paavolyy
 */
public class Shakki {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pelilauta lauta = new Pelilauta();
        GraafinenKayttoliittyma g = new GraafinenKayttoliittyma(lauta);
        g.run();


    }
}
