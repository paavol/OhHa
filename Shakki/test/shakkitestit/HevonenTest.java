/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkitestit;

import org.junit.*;
import static org.junit.Assert.*;
import shakki.Hevonen;

/**
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

    @Before
    public void setUp() {
        vasenMus = new Hevonen(0, 1, false);
        oikeaMus = new Hevonen(0, 6, false);
        vasenVal = new Hevonen(7, 1, true);
        oikeaVal = new Hevonen(7, 6, true);

    }

    /**
     * Testataan, että hevoset liikkuvat hevosen sääntöjen mukaan.
     */
    @Test
    public void liikkuuKutenHevonen() {
        assertTrue(vasenMus.liiku(2, 2));
        assertTrue(oikeaMus.liiku(2, 5));
        assertTrue(vasenVal.liiku(6, 3));
        assertTrue(oikeaVal.liiku(6, 4));
    }

    /**
     * Yritetään liikuttaa hevosta oikeaMus mahdottomaan ruutuun.
     */
    @Test
    public void yrittaaLiikkuaVaarin() {
        assertFalse(vasenMus.liiku(3, 0));
        assertFalse(oikeaMus.liiku(2, 4));
        assertFalse(vasenVal.liiku(6, 4));
        assertFalse(oikeaVal.liiku(6, 3));
    }

    @Test
    public void hevosetOikeissaPaikoissa() {
        assertTrue(vasenMus.getX() == 0 && vasenMus.getY() == 1);
        assertTrue(oikeaMus.getX() == 0 && oikeaMus.getY() == 6);
        assertTrue(vasenVal.getX() == 7 && vasenVal.getY() == 1);
        assertTrue(oikeaVal.getX() == 7 && oikeaVal.getY() == 6);
    }

    @Test
    public void mustaOnMusta() {
        assertEquals(vasenMus.valkoinenko(), false);
    }

    @Test
    public void valkoinenOnValkoinen() {
        assertEquals(vasenVal.valkoinenko(), true);
    }

    /**
     * Tarkistetaan toStringin toimivuus.
     */
    @Test
    public void toStringToimiiOikein() {
        assertEquals(vasenVal.toString(), "H ");
    }
}
