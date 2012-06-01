/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import kayttoliittyma.GraafinenKayttoliittyma;
import kayttoliittyma.Tekstikayttoliittyma;
import sovelluslogiikka.Pelilauta;

/**
 * Shakki-luokassa (Main) voidaan luoda uusi pelilauta ja valita haluamamme
 * käyttöliittymä, sekä käynnistää pelin. Oletuksena avautuu graafinen
 * käyttöliittymä.
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
