/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki;


/**
 *
 * @author Paavo Lyytikäinen
 */
public class NappuloidenLuominen {

    private Nappula[] nappulat;
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
    private Sotilas s1Musta;
    private Sotilas s2Musta;
    private Sotilas s3Musta;
    private Sotilas s4Musta;
    private Sotilas s5Musta;
    private Sotilas s6Musta;
    private Sotilas s7Musta;
    private Sotilas s8Musta;
    private Sotilas s1Valkoinen;
    private Sotilas s2Valkoinen;
    private Sotilas s3Valkoinen;
    private Sotilas s4Valkoinen;
    private Sotilas s5Valkoinen;
    private Sotilas s6Valkoinen;
    private Sotilas s7Valkoinen;
    private Sotilas s8Valkoinen;

    /**
     * Konstruktori antaa pelilaudan upseereille koordinaatit ja lisää kaikki
     * nappulat listaan. Sotilaiden luomista ei ole vielä toteutettu.
     */
    public NappuloidenLuominen() {
        this.torniMustaOikea = new Torni(0, 7, false);
        this.hevonenMustaOikea = new Hevonen(0, 6, false);
        this.lahettiMustaOikea = new Lahetti(0, 5, false);
        this.kuningasMusta = new Kuningas(0, 4, false);
        this.kuningatarMusta = new Kuningatar(0, 3, false);
        this.lahettiMustaVasen = new Lahetti(0, 2, false);
        this.hevonenMustaVasen = new Hevonen(0, 1, false);
        this.torniMustaVasen = new Torni(0, 0, false);
        this.s1Musta = new Sotilas(1, 0, false);
        this.s2Musta = new Sotilas(1, 1, false);
        this.s3Musta = new Sotilas(1, 2, false);
        this.s4Musta = new Sotilas(1, 3, false);
        this.s5Musta = new Sotilas(1, 4, false);
        this.s6Musta = new Sotilas(1, 5, false);
        this.s7Musta = new Sotilas(1, 6, false);
        this.s8Musta = new Sotilas(1, 7, false);

        this.torniValkoinenOikea = new Torni(7, 7, true);
        this.hevonenValkoinenOikea = new Hevonen(7, 6, true);
        this.lahettiValkoinenOikea = new Lahetti(7, 5, true);
        this.kuningasValkoinen = new Kuningas(7, 4, true);
        this.kuningatarValkoinen = new Kuningatar(7, 3, true);
        this.lahettiValkoinenVasen = new Lahetti(7, 2, true);
        this.hevonenValkoinenVasen = new Hevonen(7, 1, true);
        this.torniValkoinenVasen = new Torni(7, 0, true);

        this.s1Valkoinen = new Sotilas(6, 0, true);
        this.s2Valkoinen = new Sotilas(6, 1, true);
        this.s3Valkoinen = new Sotilas(6, 2, true);
        this.s4Valkoinen = new Sotilas(6, 3, true);
        this.s5Valkoinen = new Sotilas(6, 4, true);
        this.s6Valkoinen = new Sotilas(6, 5, true);
        this.s7Valkoinen = new Sotilas(6, 6, true);
        this.s8Valkoinen = new Sotilas(6, 7, true);

        this.nappulat = new Nappula[32];
        lisaaNappulat();
    }

    private void lisaaNappulat() {
        nappulat[0] = torniMustaVasen;
        nappulat[1] = hevonenMustaVasen;
        nappulat[2] = lahettiMustaVasen;
        nappulat[3] = kuningatarMusta;
        nappulat[4] = kuningasMusta;
        nappulat[5] = lahettiMustaOikea;
        nappulat[6] = hevonenMustaOikea;
        nappulat[7] = torniMustaOikea;
        nappulat[8] = s1Musta;
        nappulat[9] = s2Musta;
        nappulat[10] = s3Musta;
        nappulat[11] = s4Musta;
        nappulat[12] = s5Musta;
        nappulat[13] = s6Musta;
        nappulat[14] = s7Musta;
        nappulat[15] = s8Musta;

        nappulat[16] = torniValkoinenVasen;
        nappulat[17] = hevonenValkoinenVasen;
        nappulat[18] = lahettiValkoinenVasen;
        nappulat[19] = kuningatarValkoinen;
        nappulat[20] = kuningasValkoinen;
        nappulat[21] = lahettiValkoinenOikea;
        nappulat[22] = hevonenValkoinenOikea;
        nappulat[23] = torniValkoinenOikea;
        nappulat[24] = s1Valkoinen;
        nappulat[25] = s2Valkoinen;
        nappulat[26] = s3Valkoinen;
        nappulat[27] = s4Valkoinen;
        nappulat[28] = s5Valkoinen;
        nappulat[29] = s6Valkoinen;
        nappulat[30] = s7Valkoinen;
        nappulat[31] = s8Valkoinen;
//
//        nappulat.add(torniMustaOikea);
//        nappulat.add(torniMustaVasen);
//        nappulat.add(torniValkoinenVasen);
//        nappulat.add(torniValkoinenOikea);
//
//        nappulat.add(lahettiValkoinenOikea);
//        nappulat.add(lahettiValkoinenVasen);
//        nappulat.add(lahettiMustaOikea);
//        nappulat.add(lahettiMustaVasen);
//
//        nappulat.add(hevonenMustaOikea);
//        nappulat.add(hevonenMustaVasen);
//        nappulat.add(hevonenValkoinenOikea);
//        nappulat.add(hevonenValkoinenVasen);
//
//        nappulat.add(kuningasMusta);
//        nappulat.add(kuningasValkoinen);
//        nappulat.add(kuningatarValkoinen);
//        nappulat.add(kuningatarMusta);

    }

    /**
     * Palauttaa shakkinappuloita sisältävän taulukon.
     *
     */
    public Nappula[] getNappulat() {
        return nappulat;
    }

    public Nappula getNappula(int x) {
        return nappulat[x];
    }
}
