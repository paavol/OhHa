/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import java.util.Scanner;
import shakki.Pelilauta;
import shakki.Ruutu;

/**
 * Tekstikäyttöliittymä luodaan Main-luokan main-osiossa.Käyttöliittymän kautta
 * hallitaan shakkipelin tapahtumia.
 *
 * @author paavolyy
 */
public class Tekstikayttoliittyma implements Kayttoliittyma {

    private Pelilauta lauta;
    private Scanner lukija;

    /**
     * Tekstikäyttöliittymä saa parametrina Pelilaudan.
     *
     * @param lauta
     */
    public Tekstikayttoliittyma() {
        this.lukija = new Scanner(System.in);

    }

  
    @Override
    public void piirraLauta(Ruutu[][] lauta, boolean valkoisenVuoro) {
        if (valkoisenVuoro) {
            System.out.println("VALKOISEN VUORO");
        } else {
            System.out.println("MUSTAN VUORO");
        }
        System.out.println("");
        for (Ruutu[] rivi : lauta) {
            for (Ruutu ruutu : rivi) {
                if (ruutu.getNappula() != null) {
                    System.out.print(ruutu.getNappula());
                }
                if (ruutu.getNappula() == null) {
                    System.out.print("_ ");
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }


    @Override
    public int[] siirto() {
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

        return new int[]{vanhaX, vanhaY, uusiX, uusiY};
    }
}
