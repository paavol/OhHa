/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki;

/**
 *
 * @author Maijanen
 */
public class Kayttoliittyma {

    private Pelilauta lauta;
    private Nappula nappula;

    public Kayttoliittyma(Pelilauta lauta) {
        this.lauta = lauta;
        lauta.luoPelilauta();
    }

    public void liikkuminen() {
    }

    public void liikkuminen(int uusiX, int uusiY, Nappula nappula) {
        if (nappula != null) {
            nappula.liiku(uusiX, uusiY);
        }
    }
}
