package sovelluslogiikka;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

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
    Kuningatar q1;

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
        q1 = new Kuningatar(0, 3, false);
        solttu = new Sotilas(1, 0, true);
        heppa = new Hevonen(0, 5, true);
        pelilauta.lisaaNappulaLaudalle(k1);
        pelilauta.lisaaNappulaLaudalle(k2);
        pelilauta.lisaaNappulaLaudalle(q1);
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
     * Tarkastaa, että halutussa paikassa ei ole kuningasta.
     */
    @Test
    public void ruudussaEiOleKuningasta() {
        assertTrue(pelilauta.ruudussaEiKuningasta(7, 3));
    }

    /**
     * Tarkistaa, että kuningas löytyy halutusta paikasta.
     */
    @Test
    public void ruudussaOnKuningas() {
        assertFalse(pelilauta.ruudussaEiKuningasta(7, 4));
    }

    /**
     * Testataan, että nappulalista ei ole tyhjä, vaan sisältää ainakin yhden
     * shakkinappulan.
     */
    @Test
    public void pelilautaEiOleTyhja() {
        assertNotNull(pelilauta.getLauta());
    }

    /**
     * Testataan, että sotilas muuttuu kuningattareksi pelilaudan toiseen
     * päätyyn päästyään.
     */
    @Test
    public void muuttuukoSotilas() {
        try {
            pelilauta.liikutaNappulaa(1, 0, 0, 0, true);
            assertEquals(Kuningatar.class, pelilauta.getNappulaLaudalta(0, 0).getClass());
        } catch (Exception e) {
        }
    }

    /**
     * Testi tarkistaa, että haluttu paikka on null-viitteinen eli tyhjä.
     */
    @Test
    public void onkoRuutuVapaa() {
        assertNull(pelilauta.getNappulaLaudalta(5, 5));
    }

    /**
     * Testataan, että kuningas k2 söi vieressään olevan vastapuolen hevosen.
     */
    @Test
    public void voikoSyoda() {
        pelilauta.liikutaNappulaa(0, 4, 0, 5, false);
        assertEquals(k2, pelilauta.getNappulaLaudalta(0, 5));
    }

    /**
     * Metodi, joka tarkistaa, että hevosella tehty shakki toimii siten, että
     * kuningas ei voi siirtyä kyseiseen ruutuun.
     */
    @Test
    public void ruutuunEiVoiSiirtya() {
        pelilauta.liikutaNappulaa(0, 5, 2, 6, true);
        pelilauta.liikutaNappulaa(0, 4, 0, 5, false);

        assertEquals(k2, pelilauta.getNappulaLaudalta(0, 4));
    }

    /**
     * Testataan, että kuningas on varmasti siirtynyt pois vanhasta ruudusta
     * eikä kuninkaasta ole jäänyt "kopiota".
     */
    @Test
    public void siirronJalkeenRuutuVapaa() {
        pelilauta.liikutaNappulaa(0, 4, 0, 5, false);
        assertNull(pelilauta.getNappulaLaudalta(0, 4));
    }

    /**
     * Testataan laudan alustuksen toiminta.
     */
    @Test
    public void laudanAlustusToimii() {
        pelilauta.alustaLauta();
        assertEquals(Lahetti.class, pelilauta.getNappulaLaudalta(0, 5).getClass());
    }

    /**
     * Testataan, että mustat hevoset ovat niiden alustetuilla oikeilla
     * paikoilla.
     */
    @Test
    public void hevosetPaikallaan() {
        pelilauta.alustaLauta();
        assertEquals(pelilauta.getNappulaLaudalta(0, 1).getClass(), pelilauta.getNappulaLaudalta(0, 6).getClass());
    }

    /**
     * Varmistetaan, että alustus on toiminut siten, että pelilaudalle setUpissa
     * luotu Hevonen "heppa" häviää pelilaudan alustuksen jälkeen.
     */
    @Test
    public void heppaHaviaaAlustuksenJalkeen() {
        pelilauta.alustaLauta();
        assertNotSame(heppa.getClass(), pelilauta.getNappulaLaudalta(0, 5).getClass());
    }

    /**
     * Yritetään siirtää alustetulla laudalla kuningasta shakkitilanteeseen
     * sotilasrivistön eteen.
     */
    //testissä häikkää, koska sotilaiden eteen ei voi kunkku mennä
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

        pelilauta.liikutaNappulaa(k1.getX(), k1.getY(), 7, 3, true);
        assertNull(pelilauta.getNappulaLaudalta(4, 2));


    }

    /**
     * Metodi tarkastaa tilanteen, jossa sotilaan siirtyminen kuninkaan edestä
     * aiheuttaisi shakin omalle kuninkaalle.
     */
    @Test
    public void yritetaanSiirtaaSotilastaKuninkaanEdesta() {
        pelilauta.lisaaNappulaLaudalle(new Sotilas(6, 3, true));
        pelilauta.lisaaNappulaLaudalle(new Kuningatar(0, 3, false));
        pelilauta.liikutaNappulaa(6, 4, 5, 3, true);

        assertNull(pelilauta.getNappulaLaudalta(5, 3));


    }
}
