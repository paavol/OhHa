/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki;

/**
 * Luokka pitää sisällään taulukon shakkipelin nappuloista.
 *
 * @author Paavo Lyytikäinen
 */
public class NappulatAlkutilanteessa {

    private Nappula[] nappulat;

    /**
     * Konstruktori luo 32-paikkaisen taulukon ja kutsuu lisaaNappulat-metodia,
     * joka luo nappulat antaa niille koordinaatit ja lisää kaikki nappulat
     * taulukkoon.
     */
    public NappulatAlkutilanteessa() {
        nappulat = new Nappula[32];
        lisaaNappulat();
    }

    private void lisaaNappulat() {
        nappulat[0] = new Torni(0, 7, false);
        nappulat[1] = new Hevonen(0, 6, false);
        nappulat[2] = new Lahetti(0, 5, false);
        nappulat[3] = new Kuningas(0, 4, false);
        nappulat[4] = new Kuningatar(0, 3, false);
        nappulat[5] = new Lahetti(0, 2, false);
        nappulat[6] = new Hevonen(0, 1, false);
        nappulat[7] = new Torni(0, 0, false);
        nappulat[8] = new Sotilas(1, 0, false);
        nappulat[9] = new Sotilas(1, 1, false);
        nappulat[10] = new Sotilas(1, 2, false);
        nappulat[11] = new Sotilas(1, 3, false);
        nappulat[12] = new Sotilas(1, 4, false);
        nappulat[13] = new Sotilas(1, 5, false);
        nappulat[14] = new Sotilas(1, 6, false);
        nappulat[15] = new Sotilas(1, 7, false);

        nappulat[16] = new Torni(7, 0, true);
        nappulat[17] = new Hevonen(7, 1, true);
        nappulat[18] = new Lahetti(7, 2, true);
        nappulat[19] = new Kuningatar(7, 3, true);
        nappulat[20] = new Kuningas(7, 4, true);
        nappulat[21] = new Lahetti(7, 5, true);
        nappulat[22] = new Hevonen(7, 6, true);
        nappulat[23] = new Torni(7, 7, true);
        nappulat[24] = new Sotilas(6, 0, true);
        nappulat[25] = new Sotilas(6, 1, true);
        nappulat[26] = new Sotilas(6, 2, true);
        nappulat[27] = new Sotilas(6, 3, true);
        nappulat[28] = new Sotilas(6, 4, true);
        nappulat[29] = new Sotilas(6, 5, true);
        nappulat[30] = new Sotilas(6, 6, true);
        nappulat[31] = new Sotilas(6, 7, true);

    }

    /**
     * Palauttaa shakkinappuloita sisältävän taulukon.
     *
     */
    public Nappula[] getNappulat() {
        return nappulat;
    }

    /**
     * Palauttaa taulukon kohdassa x olevan Nappulan.
     *
     * @param x
     * @return
     */
    public Nappula getNappula(int x) {
        return nappulat[x];
    }
}
