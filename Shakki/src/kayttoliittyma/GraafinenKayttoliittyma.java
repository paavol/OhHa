/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import sovelluslogiikka.Pelilauta;

/**
 * Graafinen käyttöliittymä mahdollistaa pelin pelaamisen graafisesti
 * hiirenklikkauksilla. Ensimmäinen klikkaus valitsee nappulan ja toinen asettaa
 * sille paikan, jos siirto on kelvollinen.
 *
 * @author paavolyy
 */
public class GraafinenKayttoliittyma extends JFrame implements MouseListener, Runnable {

    private JFrame frame;
    private JPanel pelialusta;
    private int vanhaX;
    private int vanhaY;
    private int uusiX;
    private int uusiY;
    private Pelilauta lauta;
    private Kuvat kuvat;
    private JLabel vuoroteksti;
    private JLabel valittu;
    private int valitunVari;

    /**
     * Konstruktori saa Pelilaudan parametrina ja luo uuden shakkinappuloiden
     * kuvat sisältävän luokan. Konstruktorissa asetetaan myös vanhoille ja
     * uusille koordinaateille -1 koordinaateiksi, jotta arvot ovat varmasti
     * epäkelvot ennen ensimmäistä siirtoa.
     *
     * @param lauta
     */
    public GraafinenKayttoliittyma(Pelilauta lauta) {
        this.lauta = lauta;
        this.kuvat = new Kuvat();
        vanhaX = -1;
        vanhaY = -1;
        uusiX = -1;
        uusiY = -1;

    }

    /**
     * Run-metodi ajetaan mainissa ja se luo uuden 600*600 olevan ikkunan
     * JFrame, johon se luo pelialustan (luokomponentit). Metodi laittaa myös
     * pyörimään metodin peliKaynnissa, joka pyörii ikuisesti. On pelaajien
     * vastuulla havaita matti- ja patti-tilanteet. Näissä tilanteissa mikään
     * nappula ei enää liiku. Paitsi tilanteessa, jossa on enää jäljellä kaksi
     * kuningasta. Pohjana pelilaudalle toimii JFrame, johon muut komponentit
     * luodaan.
     */
    @Override
    public void run() {

        frame = this;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600, 650);
        frame.setLayout(new BorderLayout());
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        luoKomponentit(frame.getContentPane());
        peliKaynnissa();

    }

    private void peliKaynnissa() {
        Boolean valkoisenVuoro = true;
        lauta.alustaLauta();
        piirraLauta(valkoisenVuoro);

        while (true) {

            int[] siirronKoordinaatit;
            do {
                siirronKoordinaatit = siirto();
            } while (!(lauta.liikutaNappulaa(siirronKoordinaatit[ 0], siirronKoordinaatit[ 1],
                    siirronKoordinaatit[ 2], siirronKoordinaatit[ 3], valkoisenVuoro)));
            valkoisenVuoro = !valkoisenVuoro;
            piirraLauta(valkoisenVuoro);
        }
    }

    /**
     * Private-metodissa luodaan JPanel, pelialusta, sekä JLabel, vuoroteksti.
     * Pelialustalle asetetaan kaikki nappulat ja mustavalkoiset ruudut, kun
     * taas vuorotekstissä näkyy vuorossa olevan pelaajan vuoro.
     *
     * @param container
     */
    private void luoKomponentit(Container container) {
        pelialusta = new JPanel();
        pelialusta.setPreferredSize(new Dimension(600, 600));
        vuoroteksti = new JLabel();
        vuoroteksti.setFont(new Font(vuoroteksti.getFont().getFontName(), vuoroteksti.getFont().getStyle(), 23));
        vuoroteksti.setPreferredSize(new Dimension(600, 50));
        vuoroteksti.setHorizontalAlignment(SwingConstants.CENTER);
        vuoroteksti.setBackground(Color.WHITE);
        vuoroteksti.setForeground(Color.BLACK);
        vuoroteksti.setOpaque(true);

        container.add(pelialusta);
        container.add(vuoroteksti, BorderLayout.NORTH);
        vuoroteksti.setLayout(new BorderLayout());
        pelialusta.setLayout(new GridLayout(8, 8));

    }

    /**
     * Metodi piirtää pelilaudan uudelleen jokaisen vuoron jälkeen ja ilmoittaa
     * kenen vuoro on menossa.
     *
     * @param valkoisenVuoro
     *
     */
    public void piirraLauta(boolean valkoisenVuoro) {
        pelialusta.invalidate();
        pelialusta.removeAll();
        vuorotekstinLisaaminen(valkoisenVuoro);

        ruutujenLisaaminenPelialustalle();
        pelialusta.validate();
    }

    private void vuorotekstinLisaaminen(boolean valkoisenVuoro) {
        if (valkoisenVuoro) {
            vuoroteksti.setForeground(Color.BLACK);
            vuoroteksti.setText("Valkoisen vuoro");
            vuoroteksti.setBackground(Color.WHITE);
        } else {
            vuoroteksti.setForeground(Color.WHITE);
            vuoroteksti.setText("Mustan vuoro");
            vuoroteksti.setBackground(Color.BLACK);
        }
    }

    private void ruutujenLisaaminenPelialustalle() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Ruutu ruutu = new Ruutu(i, j);
                ruutu.setHorizontalAlignment(SwingConstants.CENTER);
                if (lauta.getLauta()[i][j] != null) {
                    kuvat.lisaaKuva(ruutu, lauta.getLauta()[i][j]);
                }
                if (i % 2 == j % 2) {
                    ruutu.setBackground(Color.white);
                } else {
                    ruutu.setBackground(Color.darkGray);
                }
                ruutu.setOpaque(true);
                ruutu.addMouseListener(this);
                pelialusta.add(ruutu);
            }
        }
    }

    /**
     * Metodi kuvaa yhden siirron toiminnan ja palauttaa taulukon siirrosta.
     * Mikäli syötetyt arvot ovat epäkelpoja, palautetaan taulukko täynnä
     * negatiivisia lukuja, jota ei peliKaynnissa-metodissa tulla hyväksymään
     * oikeiksi arvoiksi.
     *
     * @return int[]
     */
    public int[] siirto() {
        if (uusiY >= 0) {
            int a = vanhaX;
            int b = vanhaY;
            int c = uusiX;
            int d = uusiY;
            vanhatKoordinaatitEpakelvoiksi();
            return new int[]{a, b, c, d};
        } else {
            return new int[]{-1, -1, -1, -1};
        }
    }

    private void vanhatKoordinaatitEpakelvoiksi() {
        vanhaX = -1;
        vanhaY = -1;
        uusiX = -1;
        uusiY = -1;
    }

    /**
     * Metodi ohjaa hiirenpainalluksin tapahtuvaa toimintaa. Valittu ruutu
     * maalautuu vaaleanpunaisella ja väri häviää valinnan poistuttua.
     * Valitunväri-apumuuttuja tallentaa valitun ruudun värin, jonka se
     * palauttaa ruudulle takaisin, jos valinta perutaan tekemättä siirtoa.
     * Valittu-apumuuttuja taas tallentaa ensin painetun ruudun tiedot, jotta
     * väri saadaan palautettua oikeaan ruutuun.
     *
     * @param me
     */
    @Override
    public void mousePressed(MouseEvent me) {
        Ruutu ruutu = (Ruutu) me.getSource();
        if (vanhaX < 0) {
            vanhaX = ruutu.getI();
        } else {
            uusiX = ruutu.getI();
        }
        if (vanhaY < 0) {
            vanhaY = ruutu.getJ();
            valitunVari = ruutu.getBackground().getRGB();
            valittu = ruutu;
            ruutu.setBackground(Color.pink);
        } else {
            uusiY = ruutu.getJ();
            try {
                valittu.setBackground(new Color(valitunVari));
            } catch (Exception e) {
            }
        }
    }

    /**
     * Metodi ei käytössä.
     *
     * @param me
     */
    @Override
    public void mouseClicked(MouseEvent me) {
    }

    /**
     * Metodi ei käytössä.
     *
     * @param e
     */
    @Override
    public void mouseReleased(MouseEvent e) {
    }

    /**
     * Metodi ei käytössä.
     *
     * @param e
     */
    @Override
    public void mouseEntered(MouseEvent e) {
    }

    /**
     * Metodi ei käytössä.
     *
     * @param e
     */
    @Override
    public void mouseExited(MouseEvent e) {
    }
}
