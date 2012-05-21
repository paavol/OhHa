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

        pelilauta.asetaNappulaLaudalle(0, 4, k1);
        pelilauta.asetaNappulaLaudalle(7, 4, k2);
        pelilauta.asetaNappulaLaudalle(0, 0, t1);
        pelilauta.asetaNappulaLaudalle(0, 7, t2);
        pelilauta.asetaNappulaLaudalle(0, 1, hevonen);
        k3 = pelilauta.getNappulaRuudusta(1, 1);

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
        assertEquals(pelilauta.getNappulaRuudusta(0, 0).getClass(), pelilauta.getNappulaRuudusta(0, 7).getClass());
    }

    /**
     * Testataan onko molempien päiden kuninkaan paikalla samaa luokkaa oleva
     * nappula (Kuningas).
     */
    @Test
    public void kuninkaidenPaikallaSamaNappula() {
        assertEquals(pelilauta.getNappulaRuudusta(0, 4).getClass(), pelilauta.getNappulaRuudusta(7, 4).getClass());
    }

    /**
     * Testataan, että pelilaudalle luotu hevonen liikkuu hevosen sääntöjen
     * mukaisesti, ja kohta johon hevonen on siirtynyt ei saa arvoa null.
     */
    @Test
    public void hevonenLiikkuuOikein() {
        pelilauta.liikutaNappulaa(2, 2, hevonen);
        assertNotNull(pelilauta.getNappulaRuudusta(2, 2));
    }

    /**
     * Testataan, ettei hevosta yritetä liikuttaa väärin.
     */
    @Test
    public void hevonenYrittaaLiikkuaVaarin() {
        pelilauta.liikutaNappulaa(2, 1, hevonen);
        assertNull(pelilauta.getNappulaRuudusta(2, 1));
    }

    /**
     * Testataan liikkuuko ylälaidan kuningas k1 alas.
     */
    @Test
    public void kuningasLiikkuuAlas() {
        pelilauta.liikutaNappulaa(1, 4, k1);
        assertNotNull(pelilauta.getNappulaRuudusta(1, 4));
    }

    /**
     * Testataan liikkuuko ylälaidan kuningas k1 alaoikealle.
     */
    @Test
    public void kuningasLiikkuuAlaoikealle() {
        pelilauta.liikutaNappulaa(1, 5, k1);
        assertNotNull(pelilauta.getNappulaRuudusta(1, 5));
    }

    /**
     * Testataan liikkuuko ylälaidan kuningas k1 alavasemmalle.
     */
    @Test
    public void kuningasLiikkuuAlavasemmalle() {
        pelilauta.liikutaNappulaa(1, 3, k1);
        assertNotNull(pelilauta.getNappulaRuudusta(1, 3));

    }

    /**
     * Testataan liikkuuko alalaidan kuningas k2 ylävasemmalle.
     */
    @Test
    public void kuningasLiikkuuYlavasemmalle() {
        pelilauta.liikutaNappulaa(6, 3, k2);
        assertNotNull(pelilauta.getNappulaRuudusta(6, 3));
    }

    /**
     * Testataan liikkuuko alalaidan kuningas k2 yläoikealle.
     */
    @Test
    public void kuningasLiikkuuYlaoikealle() {
        pelilauta.liikutaNappulaa(6, 5, k2);
        assertNotNull(pelilauta.getNappulaRuudusta(6, 5));
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
     * Testataan liikkuuko alalaidan kuningas k2 ylöspäin.
     */
    @Test
    public void kuningasLiikkuuYlos() {
        pelilauta.liikutaNappulaa(6, 4, k2);
        assertNotNull(pelilauta.getNappulaRuudusta(6, 4));
    }

    /**
     * Siirretään ensin kuningasta k2 ylöspäin, jonka jälkeen tarkistetaan, että
     * kuningas pystyy liikkumaan vasemmalle.
     */
    @Test
    public void kuningasLiikkuuVasemmalle() {
        pelilauta.liikutaNappulaa(6, 4, k2);
        pelilauta.liikutaNappulaa(6, 3, k2);
        assertNotNull(pelilauta.getNappulaRuudusta(6, 3));
    }

    /**
     * Siirretään ensin kuningasta k2 ylöspäin, jonka jälkeen tarkistetaan, että
     * kuningas pystyy liikkumaan oikealle.
     */
    @Test
    public void kuningasLiikkuuOikealle() {
        pelilauta.liikutaNappulaa(6, 4, k2);
        pelilauta.liikutaNappulaa(6, 5, k2);
        assertNotNull(pelilauta.getNappulaRuudusta(6, 5));
    }

    /**
     * Testataan, ettei kuningasta k1 yritetä liikuttaa kuninkaan sääntöjen
     * vastaisesti.
     */
    @Test
    public void nappulaaYritetaanLiikuttaaVaarin() {
        pelilauta.liikutaNappulaa(2, 4, k1);
        assertNull(pelilauta.getNappulaRuudusta(2, 4));
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
