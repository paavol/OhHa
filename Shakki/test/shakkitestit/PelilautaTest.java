package shakkitestit;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import shakki.*;

/**
 *
 * @author paavolyy
 */
public class PelilautaTest {

    Pelilauta pelilauta;
    Kuningas k1;
    Kuningas k2;
    Sotilas solttu;
    Hevonen heppa;

    public PelilautaTest() {
    }

    /**
     * setupissa luodaan tyhjälle laudalle ruutuja, joihin heitetään muutamia
     * nappuloita pelin testaamiseksi.
     *
     *
     */
    @Before
    public void setUp() {
        pelilauta = new Pelilauta();

        k1 = new Kuningas(7, 4, true);
        k2 = new Kuningas(0, 4, false);
        solttu = new Sotilas(1, 0, true);
        heppa = new Hevonen(0, 5, true);
        pelilauta.lisaaNappulaLaudalle(k1);
        pelilauta.lisaaNappulaLaudalle(k2);
        pelilauta.lisaaNappulaLaudalle(solttu);
        pelilauta.lisaaNappulaLaudalle(heppa);
    }

    /**
     * Testataan löytyykö k1-kuningas shakkilaudalta.
     */
    @Test
    public void k3OnOikeastiLaudalla() {
        assertEquals(k1, pelilauta.getNappulaLaudalta(7, 4));
    }

    /**
     * Testataan onko laudan molempien päiden kuninkaan paikalla Kuningas,
     * getNappulaLaudalta-metodin testausta.
     */
    @Test
    public void kuninkaidenPaikallaSamaNappula() {
        assertEquals(pelilauta.getNappulaLaudalta(0, 4).getClass(), pelilauta.getNappulaLaudalta(7, 4).getClass());
    }

    /**
     * Testataan, että pelilaudan keskeltä löytyy null-viitteellisiä ruutuja,
     * getNappulaLaudalta-metodin testausta.
     */
    @Test
    public void keskellaTyhjiaRuutuja() {
        assertNull(pelilauta.getNappulaLaudalta(4, 4));
        assertNull(pelilauta.getNappulaLaudalta(3, 5));
        assertNull(pelilauta.getNappulaLaudalta(5, 5));
    }

    /**
     * Testataan, että kuningas liikkuu oikeasti laudalla laudan sääntöjen
     * mukaisesti.
     */
    @Test
    public void nappulaLiikkuuLaudalla() {

        pelilauta.liikutaNappulaa(k1.getX(), k1.getY(), 6, 4, true);
    }

    /**
     * Testataan, että nappulalista ei ole tyhjä, vaan sisältää ainakin yhden
     * shakkinappulan.
     */
    @Test
    public void pelilautaEiOleTyhja() {
        assertNotNull(pelilauta);
    }

    @Test
    public void muuttuukoSotilas() {
        try {
            pelilauta.liikutaNappulaa(1, 0, 0, 0, true);
            assertEquals(Kuningatar.class, pelilauta.getNappulaLaudalta(0, 0).getClass());
        } catch (Exception e) {
        }
    }

    @Test
    public void onkoRuutuVapaa() {
        assertNull(pelilauta.getNappulaLaudalta(5, 5));
    }

    @Test
    public void voikoSyoda() {
        pelilauta.liikutaNappulaa(0, 4, 0, 5, false);
        assertEquals(k2, pelilauta.getNappulaLaudalta(0, 5));
    }
//Tämän pitäisi toimia heti, kun shakkitarkastus toimii pollella.
    @Test
    public void ruutuunEiVoiSiirtya() {
        pelilauta.liikutaNappulaa(0, 5, 2, 6, true);
        pelilauta.liikutaNappulaa(0, 4, 0, 5, false);

        assertEquals(k2, pelilauta.getNappulaLaudalta(0, 4));
    }

    @Test
    public void siirronJalkeenRuutuVapaa() {
        pelilauta.liikutaNappulaa(0, 4, 0, 5, false);
        assertNull(pelilauta.getNappulaLaudalta(0, 4));
    }

    @Test
    public void laudanAlustusToimii() {
        pelilauta.alustaLauta();
        assertEquals(Lahetti.class, pelilauta.getNappulaLaudalta(0, 5).getClass());
    }

    @Test
    public void hevosetPaikallaan() {
        pelilauta.alustaLauta();
        assertEquals(pelilauta.getNappulaLaudalta(0, 1).getClass(), pelilauta.getNappulaLaudalta(0, 6).getClass());
    }

    @Test
    public void heppaHaviaaAlustuksenJalkeen() {
        pelilauta.alustaLauta();
        assertNotSame(heppa.getClass(), pelilauta.getNappulaLaudalta(0, 5).getClass());
    }

    @Test
    public void yritetaanSiirtaaKuningastaShakkiinSotilaanEteen() {
        pelilauta.alustaLauta();
        pelilauta.liikutaNappulaa(6, 3, 4, 3, true);
        pelilauta.liikutaNappulaa(7, 4, 6, 3, true);
        pelilauta.liikutaNappulaa(6, 3, 5, 2, true);
        pelilauta.liikutaNappulaa(5, 2, 4, 2, true);
        pelilauta.liikutaNappulaa(4, 2, 3, 2, true);
        pelilauta.liikutaNappulaa(3, 2, 2, 1, true);
        assertNull(pelilauta.getNappulaLaudalta(2, 1));

    }
//tämä testi aiheuttaa kuninkaalle jumin
    @Test
    public void yritetaanSiirtaaKuningastaShakkiinKuningattarenEteen() {
        pelilauta.alustaLauta();
        pelilauta.liikutaNappulaa(6, 3, 5, 3, true);
        pelilauta.liikutaNappulaa(7, 4, 6, 3, true);
        pelilauta.liikutaNappulaa(6, 3, 5, 2, true);
        pelilauta.liikutaNappulaa(5, 2, 4, 2, true);
        pelilauta.liikutaNappulaa(4, 2, 3, 2, true);

        pelilauta.liikutaNappulaa(1, 4, 2, 4, false);
        pelilauta.liikutaNappulaa(0, 3, 4, 7, false);
        pelilauta.liikutaNappulaa(3, 2, 4, 2, true);
        assertNull(pelilauta.getNappulaLaudalta(4, 2));


    }

    @Test
    public void yritetaanSiirtaaSotilastaKuninkaanEdesta() {
        pelilauta.alustaLauta();
        pelilauta.liikutaNappulaa(6, 3, 4, 3, true);
        pelilauta.liikutaNappulaa(7, 4, 6, 3, true);
        pelilauta.liikutaNappulaa(6, 3, 5, 2, true);
        pelilauta.liikutaNappulaa(5, 2, 4, 2, true);


        pelilauta.liikutaNappulaa(1, 4, 2, 4, false);
        pelilauta.liikutaNappulaa(0, 3, 4, 7, false);
        pelilauta.liikutaNappulaa(3, 2, 4, 2, true);
        pelilauta.liikutaNappulaa(4, 3, 3, 3, true);

        assertNull(pelilauta.getNappulaLaudalta(3, 3));


    }
}
