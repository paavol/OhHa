package sovelluslogiikka;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Testiluokka testaa Kuningas-luokan toimintaa.
 *
 * @author paavolyy
 */
public class KuningasTest {

    Kuningas m;
    Kuningas v;

    public KuningasTest() {
    }

    /**
     * Luo kaksi kuningasta pelin alkutilanteen mukaisiin paikkoihin.
     *
     */
    @Before
    public void setUp() {
        m = new Kuningas(0, 4, false);
        v = new Kuningas(7, 4, true);
    }

    /**
     * Testataan, että kuninkaat ovat niille annetuissa koordinaateissa.
     */
    @Test
    public void kuninkaatOikeissaPaikoissa() {
        assertTrue(m.getX() == 0 && m.getY() == 4);
        assertTrue(v.getX() == 7 && v.getY() == 4);
    }

    /**
     * Testataan, että kuninkaat liikkuvat kuninkaan shakkisääntöjen mukaan.
     */
    @Test
    public void liikkuuKutenKuningas() {
        assertTrue(m.voikoLiikkua(1, 4));
        assertTrue(m.voikoLiikkua(1, 5));
        assertTrue(v.voikoLiikkua(6, 3));
        assertTrue(v.voikoLiikkua(6, 4));
    }

    /**
     * Yritetään liikuttaa kuninkaita mahdottomiin ruutuihin.
     */
    @Test
    public void yrittaaLiikkuaVaarin() {
        assertFalse(m.voikoLiikkua(3, 0));
        assertFalse(v.voikoLiikkua(6, 2));
    }

    /**
     * Testataan, että valkoinen kuningas on oikeasti väriltään valkoinen, eli
     * parametrin valkoinenko arvo on true.
     */
    @Test
    public void valkoinenOnValkoinen() {
        assertEquals(v.valkoinenko(), true);
    }

    /**
     * Testataan, että musta kuningas on oikeasti väriltään musta, eli
     * parametrin valkoinenko arvo on false.
     */
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
