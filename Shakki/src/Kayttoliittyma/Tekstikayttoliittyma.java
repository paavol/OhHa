/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import java.util.Scanner;
import shakki.Pelilauta;

/**
 * Tekstikäyttöliittymä luodaan Main-luokan main-osiossa.Käyttöliittymän kautta
 * hallitaan shakkipelin tapahtumia.
 *
 * @author paavolyy
 */
public class Tekstikayttoliittyma {

    private Pelilauta lauta;
    private Scanner lukija;

    /**
     * Tekstikäyttöliittymä saa parametrina Pelilaudan.
     *
     * @param lauta
     */
    public Tekstikayttoliittyma(Pelilauta lauta) {
        this.lauta = lauta;
        this.lukija = new Scanner(System.in);
    }

    /**
     * Metodi käynnistää shakin ja alustaa uuden pelilaudan.Tämän jälkeen
     * käyttäjältä kysytään siirtoja.Toistaiseksi käyttöliittymässä ei vielä
     * säädetä kummanko pelaajan vuoro on meneillään.Peli on käynnissä niin
     * pitkään kuin pelilaudan peliKaynnissa()-metodi on totta.
     *
     */
    public void kaynnista() {
        System.out.println("Tervetuloa pelaamaan shakkia!");
        lauta.alustaLauta();
        while (lauta.peliKaynnissa()) {

            System.out.println("Anna siirrettävän nappulan koordinaatit.");

            System.out.print("x: ");
            int vanhaX = Integer.parseInt(lukija.next());
            System.out.print("y: ");
            int vanhaY = Integer.parseInt(lukija.next());
            System.out.println("Anna loppupisteen koordinaatit.");
            System.out.print("x: ");
            int uusiX = Integer.parseInt(lukija.next());
            System.out.print("y: ");
            int uusiY = Integer.parseInt(lukija.next());
            
            lauta.liikutaNappulaa(vanhaX, vanhaY, uusiX, uusiY);

            lauta.paivitaLauta();


        }
    }
}
