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
    Hevonen hevonen;
    Nappula k3;
    Torni t1;
    Torni t2;
    Ruutu ruutu;

    public PelilautaTest() {
    }

    /**
     * Alustaa pelilaudan ja lisää laudalle kuninkaan molempiin päihin, tornit
     * yläpäihin ja hevosen vasemman tornin viereen Lisäksi pelilaudan ruutuun
     * 1,1 luodaan tuntematon nappula.
     */
    @Before
    public void setUp() {
        pelilauta = new Pelilauta();
        pelilauta.asetaRuutuLaudalle(ruutu);
        ruutu.setNappula(k1);
        
       
    }

    /**
     * Testataan löytyykö k3-kuningas shakkilaudalta.
     */
    @Test
    public void k3OnOikeastiLaudalla() {
        assertEquals(k3, pelilauta.getNappulaRuudusta(1, 1));
    }

    /**
     * Testataan löytyykö k2-kuningas shakkilaudalta.
     */
    @Test
    public void k2OnOikeastiLaudalla() {
        assertEquals(k2, pelilauta.getNappulaRuudusta(7, 4));
    }

    /**
     * Testataan onko shakkilaudan yläkulmissa samaa luokkaa olevat nappulat
     * (Torni).
     */
    @Test
    public void kulmissaSamatNappulat() {
        assertEquals(pelilauta.getNappulaRuudusta(0, 0), pelilauta.getNappulaRuudusta(0, 7));
    }

    /**
     * Testataan onko molempien päiden kuninkaan paikalla samaa luokkaa oleva
     * nappula (Kuningas).
     */
    @Test
    public void kuninkaidenPaikallaSamaNappula() {
        assertEquals(pelilauta.getNappulaRuudusta(0, 4), pelilauta.getNappulaRuudusta(7, 4));
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
     * Testataan, että nappulalista ei ole tyhjä, vaan sisältää ainakin yhden
     * shakkinappulan.
     */
    @Test
    public void nappulalistaEiOleTyhja() {
        assertNotNull(pelilauta);
    }
}
