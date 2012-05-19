/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Maijanen
 */
public class Pelilauta {

    private Nappula[][] lauta;
    private Nappulat nappulat;

    public Pelilauta() {
        this.lauta = new Nappula[8][8];
        this.nappulat = new Nappulat();
        luoNappulat();
        luoPelilauta();
    }

    private void luoNappulat() {
//        for (int i = 0; i < lauta.length; i++) {
//            for (int j = 0; j < lauta.length; j++) {
//            for (int k = 0; k < nappulat.getNappulataulukko().length; k++) {
//                
//            }
//            }
//
//        }


        for (int i = 0; i < lauta.length; i++) {
            for (int j = 0; j < lauta.length; j++) {
                for (int k = 0; k < nappulat.getNappulat().size(); k++) {
                    if (nappulat.getNappulat().get(k).getX() == i
                            && nappulat.getNappulat().get(k).getY() == j) {
                        lauta[i][j] = nappulat.getNappulat().get(k);
                    }
                }
            }
        }
    }

    public void liikutaNappulaa(int uusiX, int uusiY, Nappula nappula) {
        if (nappula != null) {
            if (nappula.voikoNappulaLiikkua(uusiX, uusiY)) {
                lauta[nappula.getX()][nappula.getY()] = null;
                poistaVanhaNappulaListalta(nappula);
                lauta[uusiX][uusiY] = nappula;
            }
        }
    }

    public boolean onkoToinenNappulaRuudussa(int uusiX, int uusiY) {
        if (lauta[uusiX][uusiY] != null) {
            return true;
        }
        return false;
    }

    public void poistaVanhaNappulaListalta(Nappula nappula) {
        Iterator<Nappula> iteraattori = nappulat.getNappulat().iterator();
        while (iteraattori.hasNext()) {
            if (iteraattori.next().equals(nappula)) {
                iteraattori.remove();
            }
        }
    }
//
//    public boolean voikoSyoda(int uusiX, int uusiY) {
//        return true;
//    }

    public List<Nappula> palautaNappulatListana() {
        return nappulat.getNappulat();
    }

    public Nappula getNappulaRuudusta(int x, int y) {
        return lauta[x][y];
    }

    private void luoPelilauta() {
        System.out.println("");

        for (Nappula[] rivi : lauta) {
            for (Nappula ruutu : rivi) {
                if (ruutu != null) {
                    System.out.print(ruutu);
                }
                if (ruutu == null) {
                    System.out.print("_ ");
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public void paivitaLauta() {
        luoPelilauta();
    }
}
