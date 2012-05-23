/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkitestit;

import org.junit.*;
import static org.junit.Assert.*;
import shakki.Lahetti;

/**
 *
 * @author Maijanen
 */
public class LahettiTest {

    Lahetti vasenVal;
    Lahetti vasenMus;
    Lahetti oikeaVal;
    Lahetti oikeaMus;

    public LahettiTest() {
    }

    @Before
    public void setUp() {
        vasenMus = new Lahetti(0, 2, false);
        oikeaMus = new Lahetti(0, 5, false);
        vasenVal = new Lahetti(7, 2, true);
        oikeaVal = new Lahetti(7, 5, true);
    }

    @Test
    public void lahetitOikeissaPaikoissa() {
        assertTrue(vasenMus.getX() == 0 && vasenMus.getY() == 2);
        assertTrue(oikeaMus.getX() == 0 && oikeaMus.getY() == 5);
        assertTrue(vasenVal.getX() == 7 && vasenVal.getY() == 2);
        assertTrue(oikeaVal.getX() == 7 && oikeaVal.getY() == 5);
    }

    @Test
    public void liikkuuKutenLahetti() {
        assertTrue(vasenMus.liiku(2, 4));
        assertTrue(oikeaMus.liiku(5, 0));
        assertTrue(vasenVal.liiku(4, 5));
        assertTrue(oikeaVal.liiku(3, 1));

    }

    @Test
    public void yrittaaLiikkuaVaarin() {

        assertFalse(vasenMus.liiku(3, 4));
        assertFalse(oikeaMus.liiku(4, 0));
        assertFalse(vasenVal.liiku(4, 4));
        assertFalse(oikeaVal.liiku(3, 2));
    }

    @Test
    public void liikkuuNegatiiviseen() {
        assertTrue(vasenVal.liiku(4, -1));
    }

    @Test
    public void mustaOnMusta() {
        assertEquals(vasenMus.valkoinenko(), false);
    }

    @Test
    public void valkoinenOnValkoinen() {
        assertEquals(vasenVal.valkoinenko(), true);
    }

    @Test
    public void toStringOikein() {
        assertEquals("L ", vasenMus.toString());
    }
}
