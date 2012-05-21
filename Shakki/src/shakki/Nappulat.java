/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maijanen
 */
public class Nappulat {

    private List<Nappula> nappulat;
    private Nappula[] nappulataulukko;
    private Kuningas kuningasMusta;
    private Kuningatar kuningatarMusta;
    private Torni torniMustaVasen;
    private Torni torniMustaOikea;
    private Lahetti lahettiMustaVasen;
    private Lahetti lahettiMustaOikea;
    private Hevonen hevonenMustaVasen;
    private Hevonen hevonenMustaOikea;
    private Kuningas kuningasValkoinen;
    private Kuningatar kuningatarValkoinen;
    private Torni torniValkoinenOikea;
    private Torni torniValkoinenVasen;
    private Lahetti lahettiValkoinenOikea;
    private Lahetti lahettiValkoinenVasen;
    private Hevonen hevonenValkoinenVasen;
    private Hevonen hevonenValkoinenOikea;

    public Nappulat() {
        this.torniMustaOikea = new Torni(0,7);
        this.hevonenMustaOikea = new Hevonen(0,6);
        this.lahettiMustaOikea = new Lahetti(0,5);
        this.kuningasMusta = new Kuningas(0,4);
        this.kuningatarMusta = new Kuningatar(0,3);
        this.lahettiMustaVasen = new Lahetti(0,2);
        this.hevonenMustaVasen = new Hevonen(0,1);
        this.torniMustaVasen = new Torni(0, 0);

        this.torniValkoinenOikea = new Torni(7, 7);
        this.hevonenValkoinenOikea = new Hevonen(7,6);
        this.lahettiValkoinenOikea = new Lahetti(7,5);
        this.kuningasValkoinen = new Kuningas(7,4);
        this.kuningatarValkoinen = new Kuningatar(7,3);
        this.lahettiValkoinenVasen = new Lahetti(7,2);
        this.hevonenValkoinenVasen = new Hevonen(7,1);
        this.torniValkoinenVasen = new Torni(7,0);

        this.nappulat = new ArrayList<Nappula>();
        lisaaNappulat();
    }

    private void lisaaNappulat() {
//        nappulataulukko[0] = torniMustaVasen;
//        nappulataulukko[1] = torniMustaVasen;
//        nappulataulukko[2] = torniMustaVasen;
//        nappulataulukko[3] = kuningatarMusta;
//        nappulataulukko[4] = kuningasMusta;
//        nappulataulukko[5] = lahettiMustaOikea;
//        nappulataulukko[6] = hevonenMustaOikea;
//        nappulataulukko[7] = torniMustaOikea;
//
//        nappulataulukko[16] = torniValkoinenVasen;
//        nappulataulukko[17] = hevonenValkoinenVasen;
//        nappulataulukko[18] = lahettiValkoinenVasen;
//        nappulataulukko[19] = kuningatarValkoinen;
//        nappulataulukko[20] = kuningasValkoinen;
//        nappulataulukko[21] = lahettiValkoinenOikea;
//        nappulataulukko[22] = hevonenValkoinenOikea;
//        nappulataulukko[23] = torniValkoinenOikea;
        
        nappulat.add(torniMustaOikea);
        nappulat.add(torniMustaVasen);
        nappulat.add(torniValkoinenVasen);
        nappulat.add(torniValkoinenOikea);

        nappulat.add(lahettiValkoinenOikea);
        nappulat.add(lahettiValkoinenVasen);
        nappulat.add(lahettiMustaOikea);
        nappulat.add(lahettiMustaVasen);

        nappulat.add(hevonenMustaOikea);
        nappulat.add(hevonenMustaVasen);
        nappulat.add(hevonenValkoinenOikea);
        nappulat.add(hevonenValkoinenVasen);

        nappulat.add(kuningasMusta);
        nappulat.add(kuningasValkoinen);
        nappulat.add(kuningatarValkoinen);
        nappulat.add(kuningatarMusta);

    }

    public List<Nappula> getNappulat() {
        return nappulat;
    }

    public Nappula[] getNappulataulukko() {
        return nappulataulukko;
    }
}
