/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki;

import Kayttoliittyma.Kayttoliittyma;
import Kayttoliittyma.Tekstikayttoliittyma;

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
            int[] xyxy;
            do {
                xyxy = kayttoliittyma.siirto();
            } while (!(lauta.liikutaNappulaa(xyxy[ 0], xyxy[ 1], xyxy[ 2], xyxy[ 3], valkoisenVuoro)));
            valkoisenVuoro = !valkoisenVuoro;
            kayttoliittyma.piirraLauta(lauta.getLauta(), valkoisenVuoro);


        }
    }
}
