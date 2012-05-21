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

    Hevonen h1;
    Hevonen h2;
    Hevonen h3;
    Hevonen h4;
    Hevonen hevoshuijari;

    public HevonenTest() {
    }

    @Before
    public void setUp() {
        h1 = new Hevonen(0, 1);
        h2 = new Hevonen(0, 6);
        h3 = new Hevonen(7, 1);
        h4 = new Hevonen(7, 6);
        hevoshuijari = new Hevonen(-2, 2);
    }

    @Test
    public void laudallaOlevaOikein() {
        assertTrue(h1.getX() == 0 && h1.getY() == 1);
    }

    /**
     * Testataan, että peli ei ole hyväksynyt hevoshuijarin negatiivista arvoa.
     */
    @Test
    public void laudallaOlevaVaarin() {
        assertFalse(hevoshuijari.getX() == 0 && hevoshuijari.getY() == 2);
    }

    /**
     * Testataan, ettei nappula pysty liikkumaan pois pelilaudalta.
     */
    @Test
    public void liikkuuLaudaltaPois() {
        assertFalse(h1.voikoNappulaLiikkua(-1, 0));
    }

    /**
     * Testataan, että hevoset liikkuvat hevosen sääntöjen mukaan.
     */
    @Test
    public void liikkuuKutenHevonen() {
        assertTrue(h1.mahdollinenRuutuLiikkua(2, 2));
        assertTrue(h2.mahdollinenRuutuLiikkua(2, 7));
        assertTrue(h3.mahdollinenRuutuLiikkua(5, 0));
        assertTrue(h4.mahdollinenRuutuLiikkua(5, 5));
    }

    /**
     * Yritetään liikuttaa hevosta h2 mahdottomaan ruutuun.
     */
    @Test
    public void yrittaaLiikkuaVaarin() {
        assertFalse(h2.mahdollinenRuutuLiikkua(3, 0));
    }

    /**
     * Tarkistetaan toStringin toimivuus.
     */
    @Test
    public void palauttaaOikeanMerkin() {
        assertEquals(h3.toString(), "H ");
    }
}
