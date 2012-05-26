/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki;

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
        Peli peli = new Peli();
//        peli.kaynnista();
        peli.kaynnistaGraafinen();
        
    }
}
