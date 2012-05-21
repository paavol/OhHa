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

    Kuningas k1;
    Kuningas mahdotonKuningas1;

    public KuningasTest() {
    }

    /**
     * Luo kaksi kuningasta, joista toinen ei saa parametreinaan kelvollisia
     * arvoja.
     */
    @Before
    public void setUp() {
        k1 = new Kuningas(0, 0);
        mahdotonKuningas1 = new Kuningas(-1, 2);
    }

    /**
     * Testataan, että oikea kuningas k1 on saanut oikeat parametrit.
     */
    @Test
    public void laudallaOlevaOikein() {
        assertTrue(k1.getX() == 0 && k1.getY() == 0);
    }

    /**
     * Testataan, että väärä kuningas ei ole hyväksynyt negatiivista arvoa.
     */
    @Test
    public void laudallaOlevaVaarin() {
        assertFalse(mahdotonKuningas1.getX() == 0 && mahdotonKuningas1.getY() == 2);
    }

    /**
     * Testataan, ettei nappula pysty liikkumaan pois pelilaudalta.
     */
    @Test
    public void liikkuuLaudaltaPois() {
        assertFalse(k1.voikoNappulaLiikkua(-1, 0));
    }

    /**
     * Testataan, että kuningas k1 liikkuu kuninkaan sääntöjen mukaan.
     */
    @Test
    public void liikkuuKutenKuningas() {
        assertTrue(k1.mahdollinenRuutuLiikkua(1, 1));
    }

    /**
     * Yritetään liikuttaa kuningasta k1 mahdottomaan ruutuun.
     */
    @Test
    public void yrittaaLiikkuaVaarin() {
        assertFalse(k1.mahdollinenRuutuLiikkua(3, 0));
    }

    /**
     * Tarkistetaan toStringin toimivuus.
     */
    @Test
    public void palauttaaOikeanMerkin() {
        assertEquals(k1.toString(), "K ");
    }
}
