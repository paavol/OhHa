/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki;

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

    private boolean liikkuminenAlas(int uusiX, int uusiY, Nappula nappula) {
        if (uusiX <= nappula.getX()) {
            return false;
        }
        if (uusiY != nappula.getY()) {
            return false;
        }

        for (int i = nappula.getX(); i < uusiX; i++) {
            if (lauta[nappula.getX() + i][uusiY] != null) {
                return false;
            }
        }
        return true;
    }

    private boolean liikkuminenYlos(int uusiX, int uusiY, Nappula nappula) {
        if (uusiX >= nappula.getX()) {
            return false;
        }
        if (uusiY != nappula.getY()) {
            return false;
        }
        for (int i = nappula.getX(); i > uusiX; i--) {
            if (lauta[nappula.getX() - i][uusiY] != null) {
                return false;
            }
        }
        return true;
    }

    private boolean liikkuminenOikealle(int uusiX, int uusiY, Nappula nappula) {
        if (uusiX != nappula.getX()) {
            return false;
        }
        if (uusiY <= nappula.getY()) {
            return false;
        }
        for (int i = nappula.getY(); i < uusiY; i++) {
            if (lauta[nappula.getX()][nappula.getY() + i] != null) {
                return false;
            }
        }
        return true;
    }

    private boolean liikkuminenVasemmalle(int uusiX, int uusiY, Nappula nappula) {
        if (uusiX != nappula.getX()) {
            return false;
        }
        if (uusiY >= nappula.getY()) {
            return false;
        }
        for (int i = nappula.getY(); i > uusiY; i--) {
            if (lauta[nappula.getX()][nappula.getY() - i] != null) {
                return false;
            }
        }
        return true;
    }

    private boolean liikkuminenYlaoikealle(int uusiX, int uusiY, Nappula nappula) {
        if (uusiX >= nappula.getX()) {
            return false;
        }
        if (uusiY <= nappula.getY()) {
            return false;
        }
        if (vinostiLiikkuminen(uusiX, uusiY, nappula) == false) {
            return false;
        }
        for (int i = 1; i < Math.abs(uusiX - nappula.getX()); i++) {
            if (lauta[nappula.getX() - i][nappula.getY() + i] != null) {
                return false;
            }
        }
        return true;
    }

    private boolean liikkuminenYlavasemmalle(int uusiX, int uusiY, Nappula nappula) {
        if (uusiX >= nappula.getX()) {
            return false;
        }
        if (uusiY >= nappula.getY()) {
            return false;
        }
        if (vinostiLiikkuminen(uusiX, uusiY, nappula) == false) {
            return false;
        }
        for (int i = 1; i < Math.abs(uusiX - nappula.getX()); i++) {
            if (lauta[nappula.getX() - i][nappula.getY() - i] != null) {
                return false;
            }
        }
        return true;
    }

    private boolean liikkuminenAlaoikealle(int uusiX, int uusiY, Nappula nappula) {
        if (uusiX <= nappula.getX()) {
            return false;
        }
        if (uusiY <= nappula.getY()) {
            return false;
        }
        if (vinostiLiikkuminen(uusiX, uusiY, nappula) == false) {
            return false;
        }
        for (int i = 1; i < Math.abs(uusiX - nappula.getX()); i++) {
            if (lauta[nappula.getX() + i][nappula.getY() + i] != null) {
                return false;
            }
        }
        return true;
    }

    private boolean liikkuminenAlavasemmalle(int uusiX, int uusiY, Nappula nappula) {
        if (uusiX <= nappula.getX()) {
            return false;
        }
        if (uusiY >= nappula.getY()) {
            return false;
        }
        if (vinostiLiikkuminen(uusiX, uusiY, nappula) == false) {
            return false;
        }
        for (int i = 1; i < Math.abs(uusiX - nappula.getX()); i++) {
            if (lauta[nappula.getX() + i][nappula.getY() - i] != null) {
                return false;
            }
        }
        return true;
    }

    private boolean vinostiLiikkuminen(int uusiX, int uusiY, Nappula nappula) {
        int muutosX = Math.abs(uusiX - nappula.getX());
        int muutosY = Math.abs(uusiY - nappula.getY());
        if (muutosX != muutosY) {
            return false;
        }
        return true;
    }

    private boolean hevosenLiikkuminen(int uusiX, int uusiY, Nappula nappula) {
        if (nappula.getClass() == Hevonen.class) {
            return true;
        }
        return false;
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

    /**
     *
     * Liikutetaan haluttua nappulaa uusiin koordinaatteihin, jos kaikki annetut
     * ehdot täyttyvät.
     *
     * @param uusiX
     * @param uusiY
     * @param nappula
     */
    public void liikutaNappulaa(int uusiX, int uusiY, Nappula nappula) {
        if (nappula != null) {
            if (nappula.voikoNappulaLiikkua(uusiX, uusiY)
                    && onkoToinenNappulaRuudussa(uusiX, uusiY) == false
                    && kulkureitillaEiNappulaa(uusiX, uusiY, nappula)) {
                lauta[nappula.getX()][nappula.getY()] = null;
                poistaVanhaNappulaListalta(nappula);
                lauta[uusiX][uusiY] = nappula;
            }
        }
    }

    private boolean onkoToinenNappulaRuudussa(int uusiX, int uusiY) {
        if (lauta[uusiX][uusiY] != null) {
            return true;
        }
        return false;
    }

    private boolean kulkureitillaEiNappulaa(int uusiX, int uusiY, Nappula nappula) {
        if (jokinReittiAvoinna(uusiX, uusiY, nappula)) {
            return true;
        }
        return false;
    }

    private void poistaVanhaNappulaListalta(Nappula nappula) {
        Iterator<Nappula> iteraattori = nappulat.getNappulat().iterator();
        while (iteraattori.hasNext()) {
            if (iteraattori.next().equals(nappula)) {
                iteraattori.remove();
            }
        }
    }

    /**
     * Palauttaa nappuloita sisältävän listan listamuodossa.
     *
     */
    public List<Nappula> palautaNappulatListana() {
        return nappulat.getNappulat();
    }

    /**
     * Metodi palauttaa parametreillä annetussa ruudussa olevan nappulan tai sen
     * sisältämän null-viitteen.
     *
     * @param x
     * @param y
     * @return
     */
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

    /**
     * Luo uuden kuvan pelilaudan tilanteesta.
     */
    public void paivitaLauta() {
        luoPelilauta();
    }

    private boolean jokinReittiAvoinna(int uusiX, int uusiY, Nappula nappula) {

        return liikkuminenOikealle(uusiX, uusiY, nappula)
                || liikkuminenVasemmalle(uusiX, uusiY, nappula)
                || liikkuminenAlas(uusiX, uusiY, nappula)
                || liikkuminenYlos(uusiX, uusiY, nappula)
                || liikkuminenAlaoikealle(uusiX, uusiY, nappula)
                || liikkuminenAlavasemmalle(uusiX, uusiY, nappula)
                || liikkuminenYlavasemmalle(uusiX, uusiY, nappula)
                || liikkuminenYlaoikealle(uusiX, uusiY, nappula)
                || hevosenLiikkuminen(uusiX, uusiY, nappula);
    }
}
