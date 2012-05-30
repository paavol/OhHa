/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Testataan Sotilas-luokan toimivuutta.
 *
 * @author Maijanen
 */
public class SotilasTest {

    Sotilas s1v;
    Sotilas s1m;

    public SotilasTest() {
    }

    /**
     * Luodaan alkutilanteessa kaksi sotilasta, yksi musta ja yksi valkoinen.
     */
    @Before
    public void setUp() {
        s1m = new Sotilas(1, 4, false);
        s1v = new Sotilas(6, 5, true);
    }

    /**
     * Testataan, että sotilaat liikkuvat ryhdikkäästi shakkisääntöjen
     * mukaisesti.
     */
    @Test
    public void liikkuuKutenEhtaSotilas() {
        assertTrue(s1m.voikoLiikkua(3, 4));
        assertTrue(s1v.voikoLiikkua(5, 5));
        /**
         * Testataan, ettei sotilaat yritä liikkua shakkisääntöjen vastaisesti.
         */
    }

    @Test
    public void yrittaaLiikkuaVaarin() {
        assertFalse(s1m.voikoLiikkua(4, 4));
        assertFalse(s1v.voikoLiikkua(4, 6));
    }

    /**
     * Testataan, että musta sotilas on oikeasti musta, eli sen parametrin
     * valkoinenko arvo on false.
     */
    @Test
    public void mustaOnMusta() {
        assertEquals(s1m.valkoinenko(), false);
    }

    /**
     * Testataan, että valkoinen sotilas on oikeasti valkoinen, eli sen
     * parametrin valkoinenko arvo on true.
     */
    @Test
    public void valkoinenOnValkoinen() {
        assertEquals(s1v.valkoinenko(), true);
    }

    /**
     * Testataan Sotilaan toStringin toimivuus.
     */
    @Test
    public void toStringOikein() {
        assertEquals("s ", s1m.toString());
    }
}
