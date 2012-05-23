/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkitestit;

import org.junit.*;
import static org.junit.Assert.*;
import shakki.Sotilas;

/**
 *
 * @author Maijanen
 */
public class SotilasTest {

    Sotilas s1v;
    Sotilas s1m;

    public SotilasTest() {
    }

    @Before
    public void setUp() {
        s1m = new Sotilas(1, 4, false);
        s1v = new Sotilas(6, 5, true);
    }

    @Test
    public void liikkuuKutenEhtaSotilas() {
        assertTrue(s1m.liiku(3, 4));
        assertTrue(s1v.liiku(5, 5));

    }
     @Test
    public void yrittaaLiikkuaVaarin() {
        assertFalse(s1m.liiku(4, 4));
        assertFalse(s1v.liiku(4, 6));
    }

    @Test
    public void mustaOnMusta() {
        assertEquals(s1m.valkoinenko(), false);
    }

    @Test
    public void valkoinenOnValkoinen() {
        assertEquals(s1v.valkoinenko(), true);
    }

    @Test
    public void toStringOikein() {
        assertEquals("s ", s1m.toString());
    }
}
