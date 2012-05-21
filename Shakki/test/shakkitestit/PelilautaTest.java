package shakkitestit;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
import org.junit.*;
import static org.junit.Assert.*;
import shakki.*;

/**
 *
 * @author paavolyy
 */
public class PelilautaTest {

    Pelilauta pelilauta;
    Kuningas k1;
    Kuningas k2;
    Hevonen hevonen;
    Nappula k3;
    Torni t1;
    Torni t2;

    public PelilautaTest() {
    }

    @Before
    public void setUp() {
        pelilauta = new Pelilauta();

        pelilauta.asetaNappulaLaudalle(0, 4, k1);
        pelilauta.asetaNappulaLaudalle(7, 4, k2);
        pelilauta.asetaNappulaLaudalle(0, 0, t1);
        pelilauta.asetaNappulaLaudalle(0, 7, t2);
        pelilauta.asetaNappulaLaudalle(0, 1, hevonen);
        k3 = pelilauta.getNappulaRuudusta(1, 1);

    }

    @Test
    public void k3OnOikeastiLaudalla() {
        assertEquals(k3, pelilauta.getNappulaRuudusta(1, 1));
    }

    @Test
    public void k2OnOikeastiLaudalla() {
        assertEquals(k2, pelilauta.getNappulaRuudusta(7, 4));
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
    public void hevonenLiikkuuOikein() {
        pelilauta.liikutaNappulaa(2, 2, hevonen);
        assertNotNull(pelilauta.getNappulaRuudusta(2, 2));
    }

    @Test
    public void hevonenYrittaaLiikkuaVaarin() {
    }

    @Test
    public void kuningasLiikkuuAlas() {
        pelilauta.liikutaNappulaa(1, 4, k1);
        assertNotNull(pelilauta.getNappulaRuudusta(1, 4));
    }

    @Test
    public void kuningasLiikkuuAlaoikealle() {
        pelilauta.liikutaNappulaa(1, 5, k1);
        assertNotNull(pelilauta.getNappulaRuudusta(1, 5));
    }

    @Test
    public void kuningasLiikkuuAlavasemmalle() {
        pelilauta.liikutaNappulaa(1, 3, k1);
        assertNotNull(pelilauta.getNappulaRuudusta(1, 3));

    }

    @Test
    public void kuningasLiikkuuYlavasemmalle() {
        pelilauta.liikutaNappulaa(6, 3, k2);
        assertNotNull(pelilauta.getNappulaRuudusta(6, 3));
    }

    @Test
    public void kuningasLiikkuuYlaoikealle() {
        pelilauta.liikutaNappulaa(6, 5, k2);
        assertNotNull(pelilauta.getNappulaRuudusta(6, 5));
    }

    @Test
    public void keskellaTyhjiaRuutuja() {
        assertNull(pelilauta.getNappulaRuudusta(4, 4));
        assertNull(pelilauta.getNappulaRuudusta(3, 5));
        assertNull(pelilauta.getNappulaRuudusta(5, 5));
    }

    @Test
    public void kuningasLiikkuuYlos() {
        pelilauta.liikutaNappulaa(6, 4, k2);
        assertNotNull(pelilauta.getNappulaRuudusta(6, 4));
    }

    @Test
    public void kuningasLiikkuuVasemmalle() {
        pelilauta.liikutaNappulaa(6, 4, k2);
        pelilauta.liikutaNappulaa(6, 3, k2);
        assertNotNull(pelilauta.getNappulaRuudusta(6, 3));
    }

    @Test
    public void kuningasLiikkuuOikealle() {
        pelilauta.liikutaNappulaa(6, 4, k2);
        pelilauta.liikutaNappulaa(6, 5, k2);
        assertNotNull(pelilauta.getNappulaRuudusta(6, 5));
    }

    @Test
    public void nappulaaYritetaanLiikuttaaVaarin() {
        pelilauta.liikutaNappulaa(2, 4, k1);
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
