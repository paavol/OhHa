/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkitestit;

import org.junit.*;
import static org.junit.Assert.*;
import shakki.Kuningatar;

/**
 *
 * @author Maijanen
 */
public class KuningatarTest {

    Kuningatar m;
    Kuningatar v;

    public KuningatarTest() {
    }

    @Before
    public void setUp() {
        m = new Kuningatar(0, 3, false);
        v = new Kuningatar(7, 3, true);

    }

    @Test
    public void kuningattaretOikeissaPaikoissa() {
        assertTrue(m.getX() == 0 && m.getY() == 3);
        assertTrue(v.getX() == 7 && v.getY() == 3);
    }

    @Test
    public void liikkuuKutenKuningatar() {
        assertTrue(m.liiku(6, 3));
        assertTrue(v.liiku(4, 0));
    }

    @Test
    public void yrittaaLiikkuaVaarin() {
        assertFalse(v.liiku(1, 4));
        assertFalse(m.liiku(4, 0));
    }

    @Test
    public void yrittaaLiikkuaNegatiiviseen() {
        assertFalse(v.liiku(4, -1));
    }

    @Test
    public void mustaOnMusta() {
        assertEquals(m.valkoinenko(), false);
    }

    @Test
    public void valkoinenOnValkoinen() {
        assertEquals(v.valkoinenko(), true);
    }

    @Test
    public void toStringOikein() {
        assertEquals("Q ", m.toString());
    }
}
