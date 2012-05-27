/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import shakki.Nappula;
import shakki.NappulatAlkutilanteessa;
import shakki.Pelilauta;
import shakki.Ruutu;

/**
 *
 * @author paavolyy
 */
public class GraafinenKayttoliittyma extends JFrame implements Kayttoliittyma, MouseListener, MouseMotionListener {

    private JLayeredPane pelialusta;
    private JPanel pelilauta;
    private JLabel shakkinappula;
    private NappulatAlkutilanteessa nappulat;

    public GraafinenKayttoliittyma() {
        luoKomponentit();
        run();
    }

    private void run() {
        JFrame graafinen = this;
        graafinen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        graafinen.pack();
        graafinen.setResizable(true);
        graafinen.setLocationRelativeTo(null);
        graafinen.setVisible(true);
    }

    private void luoKomponentit() {
        Dimension laudanKoko = new Dimension(600, 600);
        pelialusta = new JLayeredPane();
        getContentPane().add(pelialusta);
        pelialusta.setPreferredSize(laudanKoko);
        pelialusta.addMouseListener(this);
        pelialusta.addMouseMotionListener(this);

        pelilauta = new JPanel();
        pelialusta.add(pelilauta, JLayeredPane.DEFAULT_LAYER);
        pelilauta.setLayout(new GridLayout(8, 8));
        pelilauta.setPreferredSize(laudanKoko);
        pelilauta.setBounds(0, 0, laudanKoko.width, laudanKoko.height);
        ruudutMustavalkoisiksi();
        shakkinappula = new JLabel(new ImageIcon("/Users/Maijanen/Downloads/jchess/images/0"));
        pelialusta.add(shakkinappula);
        JPanel panel = (JPanel) pelilauta.getComponent(0);

        panel.add(shakkinappula);

    }

    private void ruudutMustavalkoisiksi() {
        for (int i = 0; i < 64; i++) {
            JPanel ruutu = new JPanel(new BorderLayout());
            pelilauta.add(ruutu);
            int rivi = (i / 8) % 2;
            if (rivi == 0) {
                ruutu.setBackground(i % 2 == 0 ? Color.white : Color.black);
            } else {
                ruutu.setBackground(i % 2 == 0 ? Color.black : Color.white);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseDragged(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void piirraLauta(Ruutu[][] lauta, boolean valkoisenVuoro) {
    }

    @Override
    public int[] siirto() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
