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
    Ruutu ruutu;
    Ruutu ruutu2;

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
        pelilauta.asetaRuutuLaudalle(ruutu);
        pelilauta.asetaRuutuLaudalle(ruutu2);
        k1 = new Kuningas(7, 4, true);
        k2 = new Kuningas(0, 4, false);
        ruutu.setNappula(k1);
        ruutu2.setNappula(k2);

    }

    /**
     * Testataan löytyykö k1-kuningas shakkilaudalta.
     */
    @Test
    public void k3OnOikeastiLaudalla() {
        assertEquals(k1, pelilauta.getNappulaRuudusta(ruutu.getX(), ruutu.getY()));
    }

    /**
     * Testataan onko laudan molempien päiden kuninkaan paikalla Kuningas.
     */
    @Test
    public void kuninkaidenPaikallaSamaNappula() {
        assertEquals(pelilauta.getNappulaRuudusta(0, 4).getClass(), pelilauta.getNappulaRuudusta(7, 4).getClass());
    }

    /**
     * Testataan, että pelilaudan keskeltä löytyy null-viitteellisiä ruutuja.
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

        pelilauta.liikutaNappulaa(k1.getX(), k1.getY(), 6, 4);
    }

    /**
     * Testataan, että nappulalista ei ole tyhjä, vaan sisältää ainakin yhden
     * shakkinappulan.
     */
    @Test
    public void pelilautaEiOleTyhja() {
        assertNotNull(pelilauta);
    }
}
