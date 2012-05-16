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

    private Kuningas kuningas;
    private Nappula[][] lauta;

    public Pelilauta() {
        this.lauta = new Nappula[8][8];
//        this.kuningas = new Kuningas(0, 0);
//        luoPelilauta();

    }

    public void lisaaNappula(int x, int y, Nappula nappula) {
        lauta[x][y] = nappula;
    }
    public void liikkuminen(int uusiX, int uusiY, Nappula nappula) {
        if(nappula != null) {
            
            lauta[uusiX][uusiY] = nappula;
        }
    }

    public void luoPelilauta() {
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
