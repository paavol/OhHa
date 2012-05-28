/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki;

import Kayttoliittyma.GraafinenKayttoliittyma;
import Kayttoliittyma.Kayttoliittyma;
import Kayttoliittyma.Tekstikayttoliittyma;
import java.awt.Point;
import javax.swing.JFrame;

/**
 *
 * @author Maijanen
 */
public class Peli {

    public Peli() {
    }

    public void kaynnista() {
        Pelilauta lauta = new Pelilauta();
        Kayttoliittyma kayttoliittyma = new Tekstikayttoliittyma();
        Boolean valkoisenVuoro = true;
        lauta.alustaLauta();
        kayttoliittyma.piirraLauta(lauta.getLauta(), valkoisenVuoro);

        while (lauta.peliKaynnissa()) {
            int[] siirronKoordinaatit;
            do {
                siirronKoordinaatit = kayttoliittyma.siirto();
            } while (!(lauta.liikutaNappulaa(siirronKoordinaatit[ 0], siirronKoordinaatit[ 1],
                    siirronKoordinaatit[ 2], siirronKoordinaatit[ 3], valkoisenVuoro)));
            valkoisenVuoro = !valkoisenVuoro;
            kayttoliittyma.piirraLauta(lauta.getLauta(), valkoisenVuoro);
        }
    }

    public void kaynnistaGraafinen() {
        Pelilauta lauta = new Pelilauta();

        Kayttoliittyma kayttoliittyma = new GraafinenKayttoliittyma();
        Boolean valkoisenVuoro = true;
        lauta.alustaLauta();
        kayttoliittyma.piirraLauta(lauta.getLauta(),valkoisenVuoro);
        
        while (lauta.peliKaynnissa()) {
            
            int[] siirronKoordinaatit;
            do {
                siirronKoordinaatit = kayttoliittyma.siirto();
            } while (!(lauta.liikutaNappulaa(siirronKoordinaatit[ 0], siirronKoordinaatit[ 1],
                    siirronKoordinaatit[ 2], siirronKoordinaatit[ 3], valkoisenVuoro)));
            valkoisenVuoro = !valkoisenVuoro;
            kayttoliittyma.piirraLauta(lauta.getLauta(),valkoisenVuoro);
        }

    }
}
