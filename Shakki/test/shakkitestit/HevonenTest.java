/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkitestit;

import org.junit.*;
import static org.junit.Assert.*;
import shakki.Hevonen;

/**
 * Testiluokka testaa Hevonen-luokan toimintaa.
 *
 * @author paavolyy
 */
public class HevonenTest {

    Hevonen vasenMus;
    Hevonen oikeaMus;
    Hevonen vasenVal;
    Hevonen oikeaVal;
    Hevonen hevoshuijari;

    public HevonenTest() {
    }

    /**
     * Alkutilanteessa luodaan hevoset niiden alkutilanteen mukaisiin
     * koordinaatteihin.
     */
    @Before
    public void setUp() {
        vasenMus = new Hevonen(0, 1, false);
        oikeaMus = new Hevonen(0, 6, false);
        vasenVal = new Hevonen(7, 1, true);
        oikeaVal = new Hevonen(7, 6, true);

    }

    /**
     * Testataan, että hevoset liikkuvat hevosen shakkisääntöjen mukaan.
     */
    @Test
    public void liikkuuKutenHevonen() {
        assertTrue(vasenMus.voikoLiikkua(2, 2));
        assertTrue(oikeaMus.voikoLiikkua(2, 5));
        assertTrue(vasenVal.voikoLiikkua(6, 3));
        assertTrue(oikeaVal.voikoLiikkua(6, 4));
    }

    /**
     * Yritetään liikuttaa hevosia mahdottomiin ruutuihin.
     */
    @Test
    public void yrittaaLiikkuaVaarin() {
        assertFalse(vasenMus.voikoLiikkua(3, 0));
        assertFalse(oikeaMus.voikoLiikkua(2, 4));
        assertFalse(vasenVal.voikoLiikkua(6, 4));
        assertFalse(oikeaVal.voikoLiikkua(6, 3));
    }

    /**
     * Testataan, että hevoset ovat niille annetuissa koordinaateissa.
     */
    @Test
    public void hevosetOikeissaPaikoissa() {
        assertTrue(vasenMus.getX() == 0 && vasenMus.getY() == 1);
        assertTrue(oikeaMus.getX() == 0 && oikeaMus.getY() == 6);
        assertTrue(vasenVal.getX() == 7 && vasenVal.getY() == 1);
        assertTrue(oikeaVal.getX() == 7 && oikeaVal.getY() == 6);
    }

    /**
     * Testataan, että musta hevonen on oikeasti väriltään musta eli sen
     * parametri valkoinenko on arvoltaan false.
     */
    @Test
    public void mustaOnMusta() {
        assertFalse(vasenMus.valkoinenko());
    }

    /**
     * Testataan, että valkoinen hevonen on oikeasti väriltään valkoinen eli sen
     * parametri valkoinenko on arvoltaan true.
     */
    @Test
    public void valkoinenOnValkoinen() {
        assertTrue(vasenVal.valkoinenko());
    }

    /**
     * Tarkistetaan toStringin toimivuus.
     */
    @Test
    public void toStringToimiiOikein() {
        assertEquals(vasenVal.toString(), "H ");
    }
    
}
