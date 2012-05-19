package shakkitestit;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.*;
import static org.junit.Assert.*;
import shakki.Kuningas;
import shakki.Pelilauta;

/**
 *
 * @author paavolyy
 */
public class PelilautaTest {

    Pelilauta pelilauta;
    Kuningas kuningas;

    public PelilautaTest() {
    }

    @Before
    public void setUp() {
        pelilauta = new Pelilauta();
        kuningas = new Kuningas(0, 4);
    }

    @Test
    public void kulmissaSamatNappulat() {
        assertEquals(pelilauta.getNappulaRuudusta(0, 0).getClass(), pelilauta.getNappulaRuudusta(0, 7).getClass());
    }

    @Test
    public void kuninkaidenPaikallaSamaNappula() {
        assertEquals(pelilauta.getNappulaRuudusta(0, 4).getClass(), pelilauta.getNappulaRuudusta(7, 4).getClass());
    }
    @Test
    public void keskellaTyhjiaRuutuja() {
             assertNull(pelilauta.getNappulaRuudusta(4, 4));
             assertNull(pelilauta.getNappulaRuudusta(3, 5));
             assertNull(pelilauta.getNappulaRuudusta(5, 5));
    }

    @Test
    public void nappulaLiikkuuUuteenPaikkaan() {
        pelilauta.liikutaNappulaa(1, 4, kuningas);
        assertNotNull(pelilauta.getNappulaRuudusta(1, 4));
    }

    @Test
    public void nappulaaYritetaanLiikuttaaVaarin() {
        pelilauta.liikutaNappulaa(2, 4, kuningas);
        assertNull(pelilauta.getNappulaRuudusta(2, 4));
    }

    @Test
    public void nappulalistaEiOleTyhja() {
        assertNotNull(pelilauta);

    }

//    @Test
//    public void nappulaaYritettiinLiikuttaaVaarin() {
//        assertFalse(true);
//    }
//    @Test
//    public void nappulaPoistettiinListalta() {
//    }
//
//    @Test
//    public void nappulatonRuutuNakyyViivana() {
//    }
//
//    @Test
//    public void onkoRuudussaNappulaa() {
//    }
}
