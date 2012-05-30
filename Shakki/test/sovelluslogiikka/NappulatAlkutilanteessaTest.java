/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Testataan NappulatAlkutilanteessa-luokan toimivuutta.
 *
 * @author Maijanen
 */
public class NappulatAlkutilanteessaTest {

    NappulatAlkutilanteessa n;

    public NappulatAlkutilanteessaTest() {
    }

    /**
     * Luodaan alkutilanteessa olevat nappulat.
     */
    @Before
    public void setUp() {
        n = new NappulatAlkutilanteessa();
    }

    /**
     * Testaan, että luotu taulukko on täynnä nappuloita, joiden arvo ei ole
     * null.
     */
    @Test
    public void taulukossaEiNullia() {
        for (Nappula nappula : n.getNappulat()) {
            assertNotNull(nappula);
        }
    }
}
