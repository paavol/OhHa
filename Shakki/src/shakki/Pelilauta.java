/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki;

/**
 *
 * @author Maijanen
 */
public class Pelilauta {

    private Nappula[][] lauta;

    public Pelilauta() {
        this.lauta = new Nappula[8][8];
        luoNappulat();
        luoPelilauta();
    }

    private void luoNappulat() {
        Kuningas kuningasMusta = new Kuningas(0, 4);
        Kuningas kuningasValkoinen = new Kuningas(7, 4);
        lauta[0][4] = kuningasMusta;
        lauta[7][4] = kuningasValkoinen;
    }

    public Nappula[][] getNappulat() {
        return lauta;
    }

    public void liikkuminen(int uusiX, int uusiY, Nappula nappula) {
        if (nappula != null) {
            lauta[nappula.getX()][nappula.getY()] = null;
            lauta[uusiX][uusiY] = nappula;
        }
    }

    private void luoPelilauta() {
        System.out.println("");

//        for (int i = 0; i < lauta.length; i++) {
//            for (int j = 0; j < 2; j++) {
//                lauta[j][i] = kuningas;
//            }
//        }
//        for (int i = 0; i < lauta.length; i++) {
//            for (int j = 6; j < 8; j++) {
//                lauta[j][i] = kuningas;
//            }
//        }


        for (Nappula[] rivi : lauta) {
            for (Nappula ruutu : rivi) {
                if (ruutu != null) {
                    System.out.print(ruutu);
                }
                if (ruutu == null) {
                    System.out.print("_ ");
                }
            }

            System.out.print("\n");
        }

    }

    public void paivitaLauta() {
        luoPelilauta();
    }
}
