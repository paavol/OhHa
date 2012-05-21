/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import shakki.Pelilauta;

/**
 * Tekstikäyttöliittymä luodaan Main-luokan main-osiossa. Tekstikäyttöliittymä
 * saa parametrinaan Pelilaudan.
 *
 * @author paavolyy
 */
public class Tekstikayttoliittyma {

    private Pelilauta lauta;

    public Tekstikayttoliittyma(Pelilauta lauta) {
        this.lauta = lauta;
    }

    /**
     * Toistaiseksi metodi ei vielä käynnistä yhtään mitään, vaan tulostaa
     * ainoastaan tekstin.Kaynnistan alle tulee kuitenkin myöhäisemmässä
     * vaiheessa pelin pelaaminen ja pelilaudan luominen.
     *
     */
    public void kaynnista() {
        System.out.println("Tervetuloa pelaamaan shakkia!");

    }
}
