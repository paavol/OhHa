/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import shakki.Pelilauta;

/**
 *
 * @author paavolyy
 */
public class Tekstikayttoliittyma {

    private Pelilauta lauta;

    public Tekstikayttoliittyma(Pelilauta lauta) {
        this.lauta = lauta;
    }

    public void kaynnista() {
        System.out.println("Tervetuloa pelaamaan shakkia!");
      
    }
}
