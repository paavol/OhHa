/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakkitestit;

import org.junit.*;
import static org.junit.Assert.*;
import shakki.NappulatAlkutilanteessa;

/**
 *
 * @author Maijanen
 */
public class NappulatAlkutilanteessaTest {

    NappulatAlkutilanteessa n;

    public NappulatAlkutilanteessaTest() {
    }

    @Before
    public void setUp() {
        n = new NappulatAlkutilanteessa();
    }

    @Test
    public void nappuloitaOlemassa() {
        assertNotNull(n.getNappula(0));
        assertNotNull(n.getNappula(1));
        assertNotNull(n.getNappula(2));
        assertNotNull(n.getNappula(3));
        assertNotNull(n.getNappula(4));
    }

    @Test
    public void negatiivisillaArvoillaNullia() {
        assertNull(n.getNappula(-1));
    }

    @Test
    public void eiArvojaTaulukonUlkopuolella() {
        assertNotNull(n.getNappula(33));
        throw new ArrayIndexOutOfBoundsException();
        
    }
}
