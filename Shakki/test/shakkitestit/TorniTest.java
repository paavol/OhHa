/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkitestit;

import org.junit.*;
import static org.junit.Assert.*;
import shakki.Lahetti;
import shakki.Torni;

/**
 * Testataan Torni-luokan toimivuutta.
 *
 * @author Maijanen
 */
public class TorniTest {

    Torni vasenMus;
    Torni oikeaMus;
    Torni vasenVal;
    Torni oikeaVal;

    public TorniTest() {
    }

    /**
     * Luodaan alkutilanteessa neljä tornia shakin alkutilanteen mukaisiin
     * paikkoihin.
     */
    @Before
    public void setUp() {
        vasenMus = new Torni(0, 0, false);
        oikeaMus = new Torni(0, 7, false);
        vasenVal = new Torni(7, 0, true);
        oikeaVal = new Torni(7, 7, true);
    }

    /**
     * Testataan, että tornit ovat niille annetuissa koordinaateissa.
     */
    @Test
    public void tornitOikeissaPaikoissa() {
        assertTrue(vasenMus.getX() == 0 && vasenMus.getY() == 0);
        assertTrue(oikeaMus.getX() == 0 && oikeaMus.getY() == 7);
        assertTrue(vasenVal.getX() == 7 && vasenVal.getY() == 0);
        assertTrue(oikeaVal.getX() == 7 && oikeaVal.getY() == 7);
    }

    /**
     * Testataan, että tornit liikkuvat shakkisääntöjen mukaisesti.
     */
    @Test
    public void liikkuuKutenTorni() {
        assertTrue(vasenMus.liiku(3, 0));
        assertTrue(oikeaMus.liiku(0, 2));
        assertTrue(vasenVal.liiku(7, 4));
        assertTrue(oikeaVal.liiku(2, 7));

    }

    /**
     * Testataan, ettei tornit pysty liikkumaan shakkisääntöjen vastaisesti.
     */
    @Test
    public void yrittaaLiikkuaVaarin() {
        assertFalse(vasenMus.liiku(3, 1));
        assertFalse(oikeaMus.liiku(1, 2));
        assertFalse(vasenVal.liiku(6, 4));
        assertFalse(oikeaVal.liiku(2, 6));
    }

    /**
     * Testataan, että musta torni on oikeasti musta, eli sen parametrin
     * valkoinenko arvo on false.
     */
    @Test
    public void mustaOnMusta() {
        assertEquals(vasenMus.valkoinenko(), false);
    }

    /**
     * Testataan, että valkoinen torni on oikeasti valkoinen, eli sen parametrin
     * valkoinenko arvo on true.
     */
    @Test
    public void valkoinenOnValkoinen() {
        assertEquals(vasenVal.valkoinenko(), true);
    }

    /**
     * Testataan toStringin toimivuus.
     */
    @Test
    public void toStringOikein() {
        assertEquals("T ", vasenMus.toString());
    }
}
