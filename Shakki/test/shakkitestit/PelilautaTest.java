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
    Ruutu ruutu;
    Ruutu ruutu2;
    Ruutu ruutu3;
    Ruutu ruutu4;
    Ruutu ruutu5;

    public PelilautaTest() {
    }

    /**
     * Alustaa pelilaudan ja lisää laudalle kuninkaan molempiin päihin oleviin
     * ruutuihin.
     *
     */
    @Before
    public void setUp() {
        pelilauta = new Pelilauta();
        ruutu = new Ruutu(7, 4);
        ruutu2 = new Ruutu(0, 4);
        ruutu3 = new Ruutu(1, 0);
        ruutu4 = new Ruutu(0, 5);
        ruutu5 = new Ruutu(0, 0);
        pelilauta.asetaRuutuLaudalle(ruutu);
        pelilauta.asetaRuutuLaudalle(ruutu2);
        pelilauta.asetaRuutuLaudalle(ruutu3);
        pelilauta.asetaRuutuLaudalle(ruutu4);

        k1 = new Kuningas(7, 4, true);
        k2 = new Kuningas(0, 4, false);
        solttu = new Sotilas(1, 0, true);
        heppa = new Hevonen(0, 5, true);
        ruutu.setNappula(k1);
        ruutu2.setNappula(k2);
        ruutu3.setNappula(solttu);
        ruutu4.setNappula(heppa);
        ruutu5.setTyhjaksi();

    }

    /**
     * Testataan löytyykö k1-kuningas shakkilaudalta.
     */
    @Test
    public void k3OnOikeastiLaudalla() {
        assertEquals(k1, pelilauta.getNappulaRuudusta(ruutu.getX(), ruutu.getY()));
    }

    /**
     * Testataan onko laudan molempien päiden kuninkaan paikalla Kuningas,
     * getNappulaRuudusta-metodin testausta.
     */
    @Test
    public void kuninkaidenPaikallaSamaNappula() {
        assertEquals(pelilauta.getNappulaRuudusta(0, 4).getClass(), pelilauta.getNappulaRuudusta(7, 4).getClass());
    }

    /**
     * Testataan, että pelilaudan keskeltä löytyy null-viitteellisiä ruutuja,
     * getNappulaRuudusta-metodin testausta.
     */
    @Test
    public void keskellaTyhjiaRuutuja() {
        assertNull(pelilauta.getNappulaRuudusta(4, 4));
        assertNull(pelilauta.getNappulaRuudusta(3, 5));
        assertNull(pelilauta.getNappulaRuudusta(5, 5));
    }

    /**
     * Testataan, että kuningas liikkuu oikeasti laudalla laudan sääntöjen
     * mukaisesti.
     */
    @Test
    public void nappulaLiikkuuLaudalla() {

        pelilauta.liikutaNappulaa(k1.getX(), k1.getY(), 6, 4,true);
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
            pelilauta.liikutaNappulaa(1, 0, 0, 0,true);
            assertEquals(Kuningatar.class, pelilauta.getNappulaRuudusta(0, 0).getClass());
        } catch (Exception e) {
        }
    }

    @Test
    public void onkoRuutuVapaa() {
        assertEquals(null, pelilauta.getNappulaRuudusta(5, 5));
    }

    @Test
    public void voikoSyoda() {
        pelilauta.liikutaNappulaa(0, 4, 0, 5,false);
        assertEquals(k2, pelilauta.getNappulaRuudusta(0, 5));
    }

    @Test
    public void ruutuunEiVoiSiirtya() {
        pelilauta.liikutaNappulaa(0, 5, 2, 6,true);
        pelilauta.liikutaNappulaa(0, 4, 0, 5,false);
        Hevonen histamiini = new Hevonen(0, 5, false);
        ruutu4.setNappula(histamiini);
        assertEquals(histamiini, pelilauta.getNappulaRuudusta(0, 5));
    }

    @Test
    public void siirronJalkeenRuutuVapaa() {
        pelilauta.liikutaNappulaa(0, 4, 0, 5,false);
        assertEquals(null, pelilauta.getNappulaRuudusta(0, 4));
    }

    @Test
    public void laudanAlustusToimii() {
        pelilauta.alustaLauta();
        assertEquals(Lahetti.class, pelilauta.getNappulaRuudusta(0, 5).getClass());
    }

    @Test
    public void hevosetPaikallaan() {
        pelilauta.alustaLauta();
        assertEquals(pelilauta.getNappulaRuudusta(0, 1).getClass(), pelilauta.getNappulaRuudusta(0, 6).getClass());
    }

    @Test
    public void heppaHaviaaAlustuksenJalkeen() {
        pelilauta.alustaLauta();
        assertNotSame(heppa.getClass(), pelilauta.getNappulaRuudusta(0, 5).getClass());
    }
}
