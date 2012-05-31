/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import sovelluslogiikka.Nappula;

/**
 *
 * @author Maijanen
 */
public class Kuvat {

    private Map<String, ImageIcon[]> kuvat;

    /**
     * Konstruktorissa annetaan jokaiselle nappulatyypille hashmapiin arvoksi
     * kaksi kuvaa taulukossa.Avaimen toimii toString.Kuvia on kaksi, koska
     * molemmilla nappuloille tarvitsee oman väriset kuvat.
     */
    public Kuvat() {
        kuvat = new HashMap<String, ImageIcon[]>();
        kuvat.put("K ", new ImageIcon[]{new ImageIcon("nappulakuvakkeet/5.gif"), new ImageIcon("nappulakuvakkeet/11.gif")});
        kuvat.put("Q ", new ImageIcon[]{new ImageIcon("nappulakuvakkeet/4.gif"), new ImageIcon("nappulakuvakkeet/10.gif")});
        kuvat.put("s ", new ImageIcon[]{new ImageIcon("nappulakuvakkeet/0.gif"), new ImageIcon("nappulakuvakkeet/6.gif")});
        kuvat.put("H ", new ImageIcon[]{new ImageIcon("nappulakuvakkeet/1.gif"), new ImageIcon("nappulakuvakkeet/7.gif")});
        kuvat.put("L ", new ImageIcon[]{new ImageIcon("nappulakuvakkeet/2.gif"), new ImageIcon("nappulakuvakkeet/8.gif")});
        kuvat.put("T ", new ImageIcon[]{new ImageIcon("nappulakuvakkeet/3.gif"), new ImageIcon("nappulakuvakkeet/9.gif")});

    }

    /**
     * Metodi lisää kuvan JLabeliin kuvataulukosta riippuen onko parametrina
     * oleva nappula valkoinen vai musta.
     *
     * @param label
     * @param nappula
     */
    public void lisaaKuva(JLabel label, Nappula nappula) {
        try {
            ImageIcon[] taulukko = kuvat.get(nappula.toString());
            if (nappula.valkoinenko()) {
                label.setIcon(taulukko[0]);
            } else {
                label.setIcon(taulukko[1]);
            }
        } catch (Exception e) {
        }
    }
}
