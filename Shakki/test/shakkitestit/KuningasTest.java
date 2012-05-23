package shakkitestit;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
import org.junit.*;
import static org.junit.Assert.*;
import shakki.Kuningas;

/**
 *
 * @author paavolyy
 */
public class KuningasTest {

    Kuningas m;
    Kuningas v;

    public KuningasTest() {
    }

    /**
     * Luo kaksi kuningasta, joista toinen ei saa parametreinaan kelvollisia
     * arvoja.
     */
    @Before
    public void setUp() {
        m = new Kuningas(0, 4, false);
        v = new Kuningas(7, 4, true);
    }

    /**
     * Testataan, että oikea kuningas m on saanut oikeat parametrit.
     */
    @Test
    public void kuninkaatOikeissaPaikoissa() {
        assertTrue(m.getX() == 0 && m.getY() == 4);
        assertTrue(v.getX() == 7 && v.getY() == 4);
    }

    /**
     * Testataan, että kuningas m liikkuu kuninkaan sääntöjen mukaan.
     */
    @Test
    public void liikkuuKutenKuningas() {
        assertTrue(m.liiku(1, 4));
        assertTrue(m.liiku(1, 5));
        assertTrue(v.liiku(6, 3));
        assertTrue(v.liiku(6, 4));
    }

    /**
     * Yritetään liikuttaa kuningasta m mahdottomaan ruutuun.
     */
    @Test
    public void yrittaaLiikkuaVaarin() {
        assertFalse(m.liiku(3, 0));
        assertFalse(v.liiku(6, 2));
    }

    @Test
    public void valkoinenOnValkoinen() {
        assertEquals(v.valkoinenko(), true);
    }

    @Test
    public void mustaOnMusta() {
        assertEquals(m.valkoinenko(), false);
    }

    /**
     * Tarkistetaan toStringin toimivuus.
     */
    @Test
    public void palauttaaOikeanMerkin() {
        assertEquals(m.toString(), "K ");
    }
}
