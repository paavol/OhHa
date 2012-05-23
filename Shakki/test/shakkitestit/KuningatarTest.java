/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkitestit;

import org.junit.*;
import static org.junit.Assert.*;
import shakki.Kuningatar;

/**
 * Testiluokka testaa Kuningatar-luokan toimintaa.
 *
 * @author Maijanen
 */
public class KuningatarTest {

    Kuningatar m;
    Kuningatar v;

    public KuningatarTest() {
    }

    /**
     * Luodaan alkutilanteessa kaksi kuningatarta shakkipelin alkutilanteen
     * mukaisiin paikkoihin.
     */
    @Before
    public void setUp() {
        m = new Kuningatar(0, 3, false);
        v = new Kuningatar(7, 3, true);

    }

    /**
     * Testataan, että luodut kuningattaret ovat niille annetuissa
     * koordinaateissa.
     */
    @Test
    public void kuningattaretOikeissaPaikoissa() {
        assertTrue(m.getX() == 0 && m.getY() == 3);
        assertTrue(v.getX() == 7 && v.getY() == 3);
    }

    /**
     * Testataan, että kuningattaret liikkuvat kuten hienojen kuningattarien
     * kuuluukin shakkisääntöjen mukaisesti.
     */
    @Test
    public void liikkuuKutenKuningatar() {
        assertTrue(m.liiku(6, 3));
        assertTrue(v.liiku(4, 0));
    }

    /**
     * Testataan, ettei kuningattaret liiku shakkisääntöjen vastaisesti.
     */
    @Test
    public void yrittaaLiikkuaVaarin() {
        assertFalse(v.liiku(1, 4));
        assertFalse(m.liiku(4, 0));
    }

    /**
     * Testataan, että musta kuningatar on oikeasti väriltään musta, eli
     * parametrin valkoinenko arvo on false.
     */
    @Test
    public void mustaOnMusta() {
        assertEquals(m.valkoinenko(), false);
    }

    /**
     * Testataan, että valkoinen kuningatar on oikeasti väriltään valkoinen, eli
     * parametrin valkoinenko arvo on true.
     */
    @Test
    public void valkoinenOnValkoinen() {
        assertEquals(v.valkoinenko(), true);
    }

    /**
     * Testataan luokan toStringin toimivuus.
     */
    @Test
    public void toStringOikein() {
        assertEquals("Q ", m.toString());
    }
}
