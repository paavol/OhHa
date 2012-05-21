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

    @Before
    public void setUp() {
        k1 = new Kuningas(0, 0);
        mahdotonKuningas1 = new Kuningas(-1, 2);
    }

    @Test
    public void laudallaOlevaOikein() {
        assertTrue(k1.getX() == 0 && k1.getY() == 0);
    }

    @Test
    public void laudallaOlevaVaarin() {
        assertFalse(mahdotonKuningas1.getX() == 0 && mahdotonKuningas1.getY() == 2);
    }

    @Test
    public void liikkuuLaudaltaPois() {
        assertFalse(k1.voikoNappulaLiikkua(-1, 0));
    }

//    @Test
//    public void liikkuuToisenPaalle() {
//        
//    }
//
//    @Test
//    public void vanhaSijaintiHaviaaLiikkuessa() {
//        
//    }
    @Test
    public void liikkuuKutenKuningas() {
        assertTrue(k1.mahdollinenRuutuLiikkua(1, 1));
    }

    @Test
    public void yrittaaLiikkuaVaarin() {
        assertFalse(k1.mahdollinenRuutuLiikkua(3, 0));
    }

    @Test
    public void palauttaaOikeanMerkin() {
        assertEquals(k1.toString(), "K ");
    }

    @Test
    public void toinenNappulaRuudussa() {
    }
}
