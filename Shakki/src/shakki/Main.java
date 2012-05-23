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
        lauta.liikutaNappulaa(0, 1, 2, 2);
        lauta.liikutaNappulaa(0, 6, 2, 7);
        lauta.liikutaNappulaa(7, 6, 5, 7);
        lauta.liikutaNappulaa(7, 1, 5, 0);
        
        lauta.liikutaNappulaa(6, 4, 4, 4);
        lauta.liikutaNappulaa(1, 1, 2, 1);
        lauta.liikutaNappulaa(1, 4, 2, 4);
        
        lauta.paivitaLauta();
        lauta.liikutaNappulaa(2, 2, 4, 3);
        lauta.paivitaLauta();

    }
}
