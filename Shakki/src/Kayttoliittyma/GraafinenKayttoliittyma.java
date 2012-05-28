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
public class GraafinenKayttoliittyma extends JFrame implements Kayttoliittyma, MouseListener {

    private boolean ensimmainenKaynnistys;
    private JFrame frame;
    private JPanel pelilauta;
    private JPanel[][] ruudut;

    public GraafinenKayttoliittyma() {
        ensimmainenKaynnistys = true;
        ruudut = new JPanel[8][8];
    }

    private void run() {

        frame = this;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setPreferredSize(new Dimension(600, 600));
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
                ////graafinenRuutu.setEnabled(true);

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

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    /**
     * Metodi reagoi hiiren painalluksiin.
     *
     * @param me
     */
    @Override
    public void mouseClicked(MouseEvent me) {
//        Component c = pelilauta.findComponentAt(me.getX(), me.getY());
//        Point alkusijainti = c.getParent().getLocation();
//        if (pelilauta.getNappulaRuudusta(alkusijainti.x, alkusijainti.y).valkoinenko()) {
//            pelilauta.liikutaNappulaa(alkusijainti.x, alkusijainti.y, me.getX(), me.getY(), true);
//        } else {
//            pelilauta.liikutaNappulaa(alkusijainti.x, alkusijainti.y, me.getX(), me.getY(), false);
//        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
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
                if (lauta[i][j].getNappula() != null) {
                    JButton nappula = lauta[i][j].getNappula();
                    if (i % 2 == j % 2) {
                        nappula.setBackground(Color.white);
                    } else {
                        nappula.setBackground(Color.darkGray);
                    }

                    this.ruudut[i][j].add(nappula); 
                }
            }
        }
    }

    /**
     * Metodi kuvaa yhden siirron toiminnan ja palauttaa taulukon siirrosta.
     *
     * @return
     */
    @Override
    public int[] siirto() {

//        return new int[]{vanhaX, vanhaY, uusiX, uusiY};
        throw new UnsupportedOperationException("Not supported yet.");
    }
}