/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Testiluokka testaa Lahetti-luokan toimintaa.
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

    /**
     * Luodaan alkutilanteessa lähetit niiden shakkipelin alkutilanteen
     * mukaisille paikoille.
     */
    @Before
    public void setUp() {
        vasenMus = new Lahetti(0, 2, false);
        oikeaMus = new Lahetti(0, 5, false);
        vasenVal = new Lahetti(7, 2, true);
        oikeaVal = new Lahetti(7, 5, true);
    }

    /**
     * Testataan, että lähetit ovat oikeasti niille annetuissa koordinaateissa.
     */
    @Test
    public void lahetitOikeissaPaikoissa() {
        assertTrue(vasenMus.getX() == 0 && vasenMus.getY() == 2);
        assertTrue(oikeaMus.getX() == 0 && oikeaMus.getY() == 5);
        assertTrue(vasenVal.getX() == 7 && vasenVal.getY() == 2);
        assertTrue(oikeaVal.getX() == 7 && oikeaVal.getY() == 5);
    }

    /**
     * Testataan, että lähetti liikkuu shakkisääntöjen mukaisesti.
     */
    @Test
    public void liikkuuKutenLahetti() {
        assertTrue(vasenMus.voikoLiikkua(2, 4));
        assertTrue(oikeaMus.voikoLiikkua(5, 0));
        assertTrue(vasenVal.voikoLiikkua(4, 5));
        assertTrue(oikeaVal.voikoLiikkua(3, 1));

    }

    /**
     * Testataan, ettei lähettiä ole mahdollista siirtää sääntöjen vastaisesti.
     */
    @Test
    public void yrittaaLiikkuaVaarin() {

        assertFalse(vasenMus.voikoLiikkua(3, 4));
        assertFalse(oikeaMus.voikoLiikkua(4, 0));
        assertFalse(vasenVal.voikoLiikkua(4, 4));
        assertFalse(oikeaVal.voikoLiikkua(3, 2));
    }

    /**
     * Testataan, että musta lähetti on oikeasti väriltään musta, eli parametrin
     * valkoinenko arvo on false.
     */
    @Test
    public void mustaOnMusta() {
        assertEquals(vasenMus.valkoinenko(), false);
    }

    /**
     * Testataan, että valkoinen lähetti on oikeasti väriltään valkoinen, eli
     * parametrin valkoinenko arvo on true.
     */
    @Test
    public void valkoinenOnValkoinen() {
        assertEquals(vasenVal.valkoinenko(), true);
    }

    /**
     * Testataan lähetin toStringin toimivuus.
     */
    @Test
    public void toStringOikein() {
        assertEquals("L ", vasenMus.toString());
    }

    @Test
    public void kulkureittiTaulukko() {
        assertEquals(4, vasenMus.tallennaReittiTaulukkoon(5, 7).size());

    }
}
