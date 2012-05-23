/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkitestit;

import org.junit.*;
import static org.junit.Assert.*;
import shakki.Kuningas;
import shakki.Nappula;
import shakki.Ruutu;

/**
 *
 * @author Maijanen
 */
public class RuutuTest {

    Ruutu ruutu;
    Ruutu ruutu2;
    Kuningas kunkku;

    public RuutuTest() {
    }

    /**
     * Luodaan alkutilanteessa kaksi ruutua, joista toiseen asetetaan nappulaksi
     * uusi kuningas.
     */
    @Before
    public void setUp() {
        ruutu = new Ruutu(0, 0);
        ruutu2 = new Ruutu(5, 5);
        kunkku = new Kuningas(7, 7, true);
        ruutu2.setNappula(kunkku);


    }

    /**
     * Testataan, että ruutuun saadaan asetettua arvo Nappulalle.
     */
    @Test
    public void asetetaanRuutuunNappula() {
        ruutu.setNappula(kunkku);
        assertNotNull(ruutu.getNappula());

    }

    /**
     * Testataan, että alkutilanteessa Nappulan arvo on null, kun sitä ei ole
     * asetettu.
     */
    @Test
    public void nappulaOnNull() {
        assertNull(ruutu.getNappula());
    }

    /**
     * Testataan, että Ruudun Nappula saadaan asetettua tyhjäksi.
     */
    @Test
    public void asetetaanRuutuTyhjaksi() {
        ruutu2.setTyhjaksi();
        assertNull(ruutu2.getNappula());
    }
}
