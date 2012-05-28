/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import shakki.Ruutu;

/**
 * Käyttöliittymä-rajapintaa hyödyntävä kaikki eri käyttöliittymät.Se tarjoaa kaksi metodia: piirra
 * @author Maijanen
 */
public interface Kayttoliittyma {

    void piirraLauta(Ruutu[][] lauta, boolean valkoisenVuoro);
    int[] siirto();
}
