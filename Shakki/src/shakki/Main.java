/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki;

import Kayttoliittyma.Tekstikayttoliittyma;

/**
 * Main-luokka luo uuden pelilaudan ja käyttöliittymän, sekä käynnistää pelin.
 *
 * @author paavolyy
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pelilauta lauta = new Pelilauta();
        Tekstikayttoliittyma teksti = new Tekstikayttoliittyma(lauta);
        teksti.kaynnista();
        lauta.liikutaNappulaa(1, 4, lauta.palautaNappulatListana().get(12));
        lauta.paivitaLauta();

    }
}
