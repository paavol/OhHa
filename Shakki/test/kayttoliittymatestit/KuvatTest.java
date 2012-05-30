/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittymatestit;

import Kayttoliittyma.Kuvat;
import javax.swing.JLabel;
import org.junit.*;
import static org.junit.Assert.*;
import shakki.Sotilas;

/**
 *
 * @author Maijanen
 */
public class KuvatTest {

    Kuvat kuvat;
    Sotilas solttu;

    public KuvatTest() {
    }

    @Before
    public void setUp() {
        kuvat = new Kuvat();
        solttu = new Sotilas(1, 1, true);
    }

    @Test
    public void valkoisenSotilaanKuva() {
        JLabel label = new JLabel();
        kuvat.lisaaKuva(label, solttu);
        assertEquals(solttu, label);
    }
//
//    @Test
//    public void valkoisenKuninkaanKuva() {
//    }
//
//    @Test
//    public void valkoisenSotilaanKuva() {
//    }
}
