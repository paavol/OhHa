/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import shakki.Pelilauta;

/**
 * Graafinen käyttöliittymä mahdollistaa pelin pelaamisen graafisesti
 * hiirenklikkauksilla.
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

    public GraafinenKayttoliittyma(Pelilauta lauta) {
        this.lauta = lauta;
        this.kuvat = new Kuvat();
        vanhaX = -1;
        vanhaY = -1;
        uusiX = -1;
        uusiY = -1;
    }

    @Override
    public void run() {

        frame = this;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setPreferredSize(new Dimension(600, 600));
        frame.setSize(600, 600);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        luoKomponentit(frame.getContentPane());

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

    private void luoKomponentit(Container container) {
        pelialusta = new JPanel();
        pelialusta.setPreferredSize(new Dimension(600, 600));

        container.add(pelialusta);
        pelialusta.setLayout(new GridLayout(8, 8));

    }

    /**
     * Metodi piirtää pelilaudan annetuin parametrein.
     *
     * @param lauta
     * @param valkoisenVuoro
     */
    public void piirraLauta(boolean valkoisenVuoro) {
        pelialusta.invalidate();
        pelialusta.removeAll();

        if (valkoisenVuoro) {
            System.out.println("VALKOISEN VUORO");
        } else {
            System.out.println("MUSTAN VUORO");
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Ruutu ruutu = new Ruutu(i, j);

                if (lauta.getNappulaLaudalta(i, j) != null) {
                    kuvat.lisaaKuva(ruutu, lauta.getNappulaLaudalta(i, j));
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
        pelialusta.validate();
    }

    /**
     * Metodi kuvaa yhden siirron toiminnan ja palauttaa taulukon siirrosta.
     *
     * @return
     */
    public int[] siirto() {
        if (uusiY >= 0) {
            int a = vanhaX;
            int b = vanhaY;
            int c = uusiX;
            int d = uusiY;

            vanhaX = -1;
            vanhaY = -1;
            uusiX = -1;
            uusiY = -1;
            return new int[]{a, b, c, d};
        } else {
            return new int[]{-1, -1, -1, -1};
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {

        Ruutu ruutu = (Ruutu) me.getSource();
        if (vanhaX < 0) {
            vanhaX = ruutu.getI();
        } else {
            uusiX = ruutu.getI();
        }
        if (vanhaY < 0) {
            vanhaY = ruutu.getJ();
        } else {
            uusiY = ruutu.getJ();
        }
        System.out.println(ruutu.getI());
        System.out.println(ruutu.getJ());
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
