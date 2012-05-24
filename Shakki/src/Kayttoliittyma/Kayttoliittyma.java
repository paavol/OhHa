/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import shakki.Ruutu;

/**
 *
 * @author Maijanen
 */
public interface Kayttoliittyma {

    void piirraLauta(Ruutu[][] lauta, boolean valkoisenVuoro);
    int[] siirto();
}
