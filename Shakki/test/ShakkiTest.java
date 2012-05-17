/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.*;
import static org.junit.Assert.*;
import shakki.Nappula;
import shakki.Pelilauta;
import shakki.Shakki;
import shakki.Torni;

/**
 *
 * @author Maijanen
 */
public class ShakkiTest {

    Pelilauta lauta;
    Shakki shakki;

    public ShakkiTest() {
    }

    @Before
    public void setUp() {
        shakki = new Shakki();
        lauta = new Pelilauta();
    }

    @Test
    public void tornitLoytyyLaudalta() {

        
        assertEquals(Torni.class, lauta.palautaNappulatListana().get(0));
        assertEquals(Torni.class, lauta.palautaNappulatListana().get(1));
        assertEquals(Torni.class, lauta.palautaNappulatListana().get(2));
        assertEquals(Torni.class, lauta.palautaNappulatListana().get(3));
    }

//    public void nappulaOikeassaPaikassa() {
//        Torni torni = new Torni(2, 2);
//        lauta.
//        lauta.palautaNappulatListana().get(lauta.palautaNappulatListana().size());
//    }
    
}
