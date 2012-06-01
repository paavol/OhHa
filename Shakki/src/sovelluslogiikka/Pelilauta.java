/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import java.util.List;

/**
 * Pelilauta on logiikkaosion tärkein luokka, jossa tapahtuu kaikki nappuloiden
 * hallinnointi ja laudalla liikkuminen.
 *
 * @author Maijanen
 */
public class Pelilauta {

    private Nappula[][] lauta;
    private NappulatAlkutilanteessa nappulat;
    private Nappula valkoinenKuningas;
    private Nappula mustaKuningas;

    public Pelilauta() {
        this.lauta = new Nappula[8][8];
        nappulat = new NappulatAlkutilanteessa();
    }

    /**
     * Metodi luo shakin alkutilanteen mukaisen laudan nappuloineen.
     */
    public void alustaLauta() {
        luoNappulatPelilautaan();
    }

    /**
     * Metodi palauttaa kaksiulotteisen taulukon "laudan".
     *
     * @return
     */
    public Nappula[][] getLauta() {
        return lauta;
    }

    /**
     * Metodilla pystyy lisäämään nappuloita laudalle esimerkiksi, jos haluaa
     * pelata kulmashakkia tai linnoitusshakkia. Tämä metodi siis mahdollistaa
     * pelin muokkaamisen helposti. Pystytään esimerkiksi muokkaamaan peliä
     * kulmashakiksi tai luomaan leikkimielisiin peleihin
     * "tasoituskuningattaria".
     *
     * @param nappula
     */
    public void lisaaNappulaLaudalle(Nappula nappula) {
        lauta[nappula.getX()][nappula.getY()] = nappula;
    }

    /**
     *
     * Liikutetaan haluttua nappulaa uusiin koordinaatteihin, jos kaikki annetut
     * ehdot täyttyvät. Käsitellään myös erikoistilanteita, kuten sotilaan
     * ylenemistä ja shakkia. Shakkitarkastus tapahtuu jokaisen vuoron lopussa,
     * jolloin pelaaja ei ikinä pysty siirtämään kuningasta shakkitilanteeseen.
     * Jos taas vastapelaaja on shakittanut, niin vuoron loputtua on saatava
     * shakkitilanne pois tai liikutaNappulaa ei hyväksy toimintaa. Ensin
     * tarkistetaan, että siirrettävä nappula on sen pelaajan värinen, jonka
     * vuoro on menossa. Tämän jälkeen metodissa tarkistetaan, että valittu
     * nappula voi liikkua halutulla tavalla, sen kulkureitillä ei ole muita
     * nappuloita ja haluttuun ruutuun voi oikeasti siirtyä.
     *
     * Tarkistetaan vielä, että onko siirretty nappula muuttunut
     * kuningattareksi, mikä vaikuttaa shakkitilanteen tarkistukseen. Tämän
     * jälkeen asetetaan nappulan koordinaatit uuden pisteen mukaisiksi ja
     * tyhjennetään vanha paikka. Jos kuitenkin huomataan, että vuoron jälkeinen
     * tilanne päätyisi shakkiin, kumotaan tehty siirto. Shakkitarkistuksessa
     * käydään siis läpi, ettei omalle kuninkaalle jää shakkia oman vuoron
     * jälkeen. Tämä riittää shakkitarkastukseksi, koska tässä tilanteessa oma
     * vuoro ei voi loppua ennen kuin shakki on purettu, eikä pystytä tekemään
     * laittomia siirtoja.
     *
     * @param uusiX
     * @param uusiY
     * @param nappula
     */
    public boolean liikutaNappulaa(int vanhaX, int vanhaY, int uusiX, int uusiY, boolean valkoisenVuoro) {
        try {
            if (lauta[vanhaX][vanhaY] != null) {
                Nappula apunappula = lauta[vanhaX][vanhaY];
                if (apunappula.valkoinenko() != valkoisenVuoro) {
                    return false;
                }
                if (apunappula.voikoLiikkua(uusiX, uusiY)
                        && kulkureitillaEiNappulaa(apunappula, uusiX, uusiY)
                        && voikoPaikkaanSiirtya(vanhaX, vanhaY, uusiX, uusiY)) {

                    apunappula.setKoordinaatit(uusiX, uusiY);
                    Nappula apunappula2 = lauta[uusiX][uusiY];
                    lauta[uusiX][uusiY] = apunappula;
                    lauta[vanhaX][vanhaY] = null;
                    if (muuttuukoSotilasKuningattareksi(apunappula)) {
                    }
                    if (tuleekoShakki(valkoisenVuoro)) {
                        lauta[uusiX][uusiY] = apunappula2;
                        lauta[vanhaX][vanhaY] = apunappula;
                        apunappula.setKoordinaatit(vanhaX, vanhaY);
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void luoNappulatPelilautaan() {
        try {
            for (Nappula nappula : nappulat.getNappulat()) {
                lauta[nappula.getX()][nappula.getY()] = nappula;
            }
            valkoinenKuningas = lauta[7][4];
            mustaKuningas = lauta[0][4];
        } catch (Exception e) {
        }

    }

    private boolean kulkureitillaEiNappulaa(Nappula nappula, int x, int y) {
        List<int[]> reitti = nappula.tallennaReittiTaulukkoon(x, y);
        for (int[] koordinaatit : reitti) {
            if (lauta[ (koordinaatit[ 0])][ (koordinaatit[ 1])] != null) {
                return false;
            }
        }
        return true;
    }

    private boolean voikoPaikkaanSiirtya(int vanhaX, int vanhaY, int uusiX, int uusiY) {
        if (lauta[vanhaX][vanhaY].getClass().equals(Sotilas.class)) {
            return ((onkoPaikkaVapaa(uusiX, uusiY) && vanhaY == uusiY)
                    || (voikoSyoda(vanhaX, vanhaY, uusiX, uusiY) && vanhaY != uusiY));
        } else {
            return ((onkoPaikkaVapaa(uusiX, uusiY))
                    || voikoSyoda(vanhaX, vanhaY, uusiX, uusiY));
        }
    }

    /**
     * Metodi tarkistaa onko kyseisessä paikassa kuningasta.
     *
     * @param uusiX
     * @param uusiY
     * @return palauttaa
     */
    public boolean paikassaEiKuningasta(int uusiX, int uusiY) {
        if (lauta[uusiX][uusiY] != null) {
            if (lauta[uusiX][uusiY].getClass().getName().equals(Kuningas.class.getName())) {
                return false;
            }
        }
        return true;
    }

    private boolean onkoPaikkaVapaa(int uusiX, int uusiY) {
        if (lauta[uusiX][uusiY] == null) {
            return true;
        }
        return false;
    }

    private boolean voikoSyoda(int vanhaX, int vanhaY, int uusiX, int uusiY) {
        if (lauta[vanhaX][vanhaY].valkoinenko()
                != lauta[uusiX][uusiY].valkoinenko()) {
            return true;
        }
        return false;
    }

    /**
     * Tämän metodin on tarkoitus tarkastaa onko pelitilanne shakki.Toistaiseksi
     * metodi ei tunnista tilanteita.
     *
     * @param valkoinenko
     * @return
     */
    private boolean tuleekoShakki(boolean valkoinenko) {
        int kunkkuX;
        int kunkkuY;
        if (valkoinenko) {
            kunkkuX = valkoinenKuningas.getX();
            kunkkuY = valkoinenKuningas.getY();
        } else {
            kunkkuX = mustaKuningas.getX();
            kunkkuY = mustaKuningas.getY();
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (lauta[i][j] != null) {
                    if (lauta[i][j].valkoinenko() != valkoinenko) {
                        if (lauta[i][j].voikoLiikkua(kunkkuX, kunkkuY)
                                && kulkureitillaEiNappulaa(lauta[i][j], kunkkuX, kunkkuY)
                                && voikoPaikkaanSiirtya(i, j, kunkkuX, kunkkuY)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean muuttuukoSotilasKuningattareksi(Nappula nappula) {
        nappula = lauta[nappula.getX()][nappula.getY()];

        if (nappula.getClass().equals(Sotilas.class)) {
            if (nappula.getX()
                    == 0 || nappula.getX() == 7) {
                if (nappula.valkoinenko) {
                    sotilasMuuttuuKuningattareksi(nappula);
                } else {
                    sotilasMuuttuuKuningattareksi(nappula);
                }
            }
            return true;
        }
        return false;
    }

    private void sotilasMuuttuuKuningattareksi(Nappula nappula) {

        nappula = lauta[nappula.getX()][nappula.getY()];
        if (nappula.valkoinenko()) {
            lisaaNappulaLaudalle(new Kuningatar(nappula.getX(), nappula.getY(), true));
        } else {
            lisaaNappulaLaudalle(new Kuningatar(nappula.getX(), nappula.getY(), false));
        }

    }
}
