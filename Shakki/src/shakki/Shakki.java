/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki;

/**
 *
 * @author paavolyy
 */
public class Shakki {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pelilauta lauta = new Pelilauta();
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(lauta);
        
        Kuningas kuningas = new Kuningas(0, 0);
        Kuningas kuningas1 = new Kuningas(5, 0);
        lauta.lisaaNappula(0, 4, kuningas);
        lauta.lisaaNappula(7, 4, kuningas1);

        kuningas.liiku(7, 5);
        lauta.luoPelilauta();

    }
}
