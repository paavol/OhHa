/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import java.util.Scanner;
import sovelluslogiikka.Nappula;
import sovelluslogiikka.Pelilauta;

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

    public void run() {
        Boolean valkoisenVuoro = true;
        lauta.alustaLauta();
        piirraLauta(valkoisenVuoro);
        while (true) {

            int[] siirronKoordinaatit;
            do {
                siirronKoordinaatit = siirto();
            } while (!(lauta.liikutaNappulaa(siirronKoordinaatit[ 0], siirronKoordinaatit[ 1],
                    siirronKoordinaatit[ 2], siirronKoordinaatit[ 3], valkoisenVuoro)));
            valkoisenVuoro = !valkoisenVuoro;
            piirraLauta(valkoisenVuoro);
        }
    }

    /**
     * Metodi piirtää pelilaudan ja kertoo kummanko pelaajan vuoro on menossa.
     *
     * @param lauta
     * @param valkoisenVuoro
     */
    public void piirraLauta(boolean valkoisenVuoro) {
        if (valkoisenVuoro) {
            System.out.println("VALKOISEN VUORO");
        } else {
            System.out.println("MUSTAN VUORO");
        }
        System.out.println("");
        for (Nappula[] rivi : lauta.getLauta()) {
            for (Nappula nappula : rivi) {
                if (nappula != null) {
                    System.out.print(nappula);
                }
                if (nappula == null) {
                    System.out.print("_ ");
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }

    /**
     * Metodi kyselee käyttäjältä x:n ja y:n arvoja ja tallentaa ne taulukkoon,
     * jonka se palauttaa.
     *
     * @return
     */
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
