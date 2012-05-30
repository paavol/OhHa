/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import Kayttoliittyma.GraafinenKayttoliittyma;
import Kayttoliittyma.Tekstikayttoliittyma;

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
//        Tekstikayttoliittyma t = new Tekstikayttoliittyma(lauta);
//        t.run();

    }
}
