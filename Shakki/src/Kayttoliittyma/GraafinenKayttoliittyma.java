/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import shakki.*;

/**
 * Graafinen käyttöliittymä mahdollistaa pelin pelaamisen graafisesti
 * hiirenklikkauksilla.
 *
 * @author paavolyy
 */
public class GraafinenKayttoliittyma extends JFrame implements Kayttoliittyma, ActionListener {

    private boolean ensimmainenKaynnistys;
    private JFrame frame;
    private JPanel pelilauta;
    private JPanel[][] ruudut;
    private int vanhaX;
    private int vanhaY;
    private int uusiX;
    private int uusiY;

    public GraafinenKayttoliittyma(Peli peli) {
        peli = new Peli();
        ensimmainenKaynnistys = true;
        ruudut = new JPanel[8][8];
        vanhaX = -1;
        vanhaY = -1;
        uusiX = -1;
        uusiY = -1;
    }

    private void run() {

        frame = this;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setPreferredSize(new Dimension(600, 600));
        frame.setSize(600, 600);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        luoKomponentit(frame.getContentPane());
    }

    private void luoKomponentit(Container container) {
        pelilauta = new JPanel();
        pelilauta.setPreferredSize(new Dimension(600, 600));

        container.add(pelilauta);
        pelilauta.setLayout(new GridLayout(8, 8));
        //pelilauta.setBounds(0, 0, laudanKoko.width, laudanKoko.height);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JPanel graafinenRuutu = new JPanel();

                if (i % 2 != j % 2) {
                    graafinenRuutu.setBackground(Color.darkGray);
                } else {
                    graafinenRuutu.setBackground(Color.white);
                }
                pelilauta.add(graafinenRuutu);

                ruudut[i][j] = graafinenRuutu;
            }
        }
    }

    /**
     * Metodi piirtää pelilaudan annetuin parametrein.
     *
     * @param lauta
     * @param valkoisenVuoro
     */
    @Override
    public void piirraLauta(Ruutu[][] lauta, boolean valkoisenVuoro) {
        if (valkoisenVuoro) {
            System.out.println("VALKOISEN VUORO");
        } else {
            System.out.println("MUSTAN VUORO");
        }

        if (ensimmainenKaynnistys) {
            run();
            ensimmainenKaynnistys = false;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JButton nappula;
                if (lauta[i][j].getNappula() != null) {
                    nappula = lauta[i][j].getNappula();
                } else {
                    nappula = new Tyhja(i, j, false);
                }

                if (i % 2 == j % 2) {
                    nappula.setBackground(Color.white);
                } else {
                    nappula.setBackground(Color.darkGray);
                }
                nappula.addActionListener(this);
                this.ruudut[i][j].removeAll();
                this.ruudut[i][j].add(nappula);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Nappula apunappula = (Nappula) ae.getSource();
        if (vanhaX < 0) {
            vanhaX = apunappula.getX();
        } else {
            uusiX = apunappula.getX();
        }
        if (vanhaY < 0) {
            vanhaY = apunappula.getY();
        } else {
            uusiY = apunappula.getY();
        }
        System.out.println(apunappula.getX());
        System.out.println(apunappula.getY());
    }

    /**
     * Metodi kuvaa yhden siirron toiminnan ja palauttaa taulukon siirrosta.
     *
     * @return
     */
    @Override
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
}
