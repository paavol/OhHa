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
 *
 * @author paavolyy
 */
public class GraafinenKayttoliittyma extends JFrame implements Kayttoliittyma, MouseListener {

    private JLayeredPane pelialusta;
    private Pelilauta pelilauta;
    private Nappula nappula;
    int muutosX;
    int muutosY;

    public GraafinenKayttoliittyma() {
        run();
    }

    private void run() {
        luoKomponentit();
        JFrame frame = this;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    private void luoKomponentit() {
        Dimension laudanKoko = new Dimension(600, 600);
        pelialusta = new JLayeredPane();
        getContentPane().add(pelialusta);
        pelialusta.setPreferredSize(laudanKoko);
        pelialusta.addMouseListener(this);

        pelilauta = new Pelilauta();
        
        pelialusta.add(pelilauta, JLayeredPane.DEFAULT_LAYER);
        pelilauta.setLayout(new GridLayout(8, 8));

        pelilauta.setBounds(0, 0, laudanKoko.width, laudanKoko.height);
        ruudutMustavalkoisiksi();
     
    }

    private void ruudutMustavalkoisiksi() {
        pelilauta.alustaLauta();
        for (int i = 0; i < pelilauta.getLauta().length; i++) {
            for (int j = 0; j < pelilauta.getLauta().length; j++) {
                JPanel graafinenRuutu = new JPanel(new BorderLayout());
                graafinenRuutu.setEnabled(true);
                graafinenRuutu.setBackground(Color.white);
                if (i % 2 != j % 2) {
                    graafinenRuutu.setBackground(Color.darkGray);
                } else {
                    graafinenRuutu.setBackground(Color.white);
                }
                pelilauta.add(graafinenRuutu);

                if (pelilauta.getNappulaRuudusta(i, j) != null) {
                    if (i % 2 == j % 2) {
                        pelilauta.getNappulaRuudusta(i, j).setBackground(Color.white);
                    } else {
                        pelilauta.getNappulaRuudusta(i, j).setBackground(Color.darkGray);

                    }
                    graafinenRuutu.add(pelilauta.getNappulaRuudusta(i, j));

                }

            }
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        Component c = pelilauta.findComponentAt(me.getX(), me.getY());
        Point alkusijainti = c.getParent().getLocation();
        if (pelilauta.getNappulaRuudusta(alkusijainti.x, alkusijainti.y).valkoinenko()) {
            pelilauta.liikutaNappulaa(alkusijainti.x, alkusijainti.y, me.getX(), me.getY(), true);
        } else {
            pelilauta.liikutaNappulaa(alkusijainti.x, alkusijainti.y, me.getX(), me.getY(), false);
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void piirraLauta(Ruutu[][] lauta, boolean valkoisenVuoro) {
        if (valkoisenVuoro) {
            System.out.println("VALKOISEN VUORO");
        } else {
            System.out.println("MUSTAN VUORO");
        }
        
    }

    @Override
    public int[] siirto() {

//        return new int[]{vanhaX, vanhaY, uusiX, uusiY};
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
