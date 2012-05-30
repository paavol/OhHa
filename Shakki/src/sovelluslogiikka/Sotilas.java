/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstraktin Nappula-luokan perivä luokka, joka pitää sisällään kyseisen
 * shakkinappulan erikoistoiminnot.
 *
 * @author Maijanen
 */
public class Sotilas extends Nappula {

    /**
     * Sotilas perii konstruktorissaan parametrit Nappula-luokasta.Lisäksi
     * sotilaalla on värin mukaan määritelty imageIcon.
     *
     * @param x
     * @param y
     * @param valkoinenko
     */
    public Sotilas(int x, int y, boolean valkoinenko) {
        super(x, y, valkoinenko);
    }

    /**
     * Sotilaan toString.
     *
     * @return
     */
    @Override
    public String toString() {
        return "s ";
    }

    private boolean sotilaanLiikkuminen(int uusiX, int uusiY) {
        
        if (getX() == 6 || getX() == 1) {
            if (valkoinenko) {
                return (liikkuuKaksiYlos(uusiX, uusiY) || liikkuuYhdenYlos(uusiX, uusiY)
                        || valkoinenSyoKulmittain(uusiX, uusiY));
            } else {
                return (liikkuuKaksiAlas(uusiX, uusiY) || liikkuuYhdenAlas(uusiX, uusiY)
                        || mustaSyoKulmittain(uusiX, uusiY));
            }
        } else if (valkoinenko) {
            return (liikkuuYhdenYlos(uusiX, uusiY) || valkoinenSyoKulmittain(uusiX, uusiY));
        } else {
            return (liikkuuYhdenAlas(uusiX, uusiY) || mustaSyoKulmittain(uusiX, uusiY));
        }
    }

//    private boolean valkoisenLiikkuminen(int uusiX, int uusiY) {
//        if (this.valkoinenko) {
//            if (getX() == 6) {
//                return (liikkuuKaksiYlos(uusiX, uusiY) || liikkuuYhdenYlos(uusiX, uusiY)
//                        || valkoinenSyoKulmittain(uusiX, uusiY));
//            } else if (liikkuuYhdenYlos(uusiX, uusiY) || valkoinenSyoKulmittain(uusiX, uusiY)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private boolean mustanLiikkuminen(int uusiX, int uusiY) {
//        if (this.valkoinenko == false) {
//            if (getX() == 1) {
//                return (liikkuuKaksiAlas(uusiX, uusiY) || liikkuuYhdenAlas(uusiX, uusiY)
//                        || mustaSyoKulmittain(uusiX, uusiY));
//            } else if (liikkuuYhdenAlas(uusiX, uusiY) || mustaSyoKulmittain(uusiX, uusiY)) {
//                return true;
//            }
//        }
//        return false;
//    }
    /**
     * Metodi tarkistaa sotilaan shakkisääntöjen mukaiset siirrot ja palauttaa
     * true, mikäli siirto parametreina saatuihin koordinaatteihin on
     * mahdollinen.Valkoisella ja mustalla sotilaalla on erilaiset liikkumiset,
     * joten esimerkiksi valkoinen sotilas pystyy liikkumaan ainoastaan
     * ylöspäin.
     *
     * @param uusiX
     * @param uusiY
     * @return
     */
    @Override
    public boolean voikoLiikkua(int uusiX, int uusiY) {
        return sotilaanLiikkuminen(uusiX, uusiY);
//        if (valkoisenLiikkuminen(uusiX, uusiY) || mustanLiikkuminen(uusiX, uusiY)) {
//            return true;
//        }
//        return false;
    }

    private boolean valkoinenSyoKulmittain(int uusiX, int uusiY) {
        return ((uusiX == getX() - 1) && (uusiY == getY() + 1
                || uusiY == getY() - 1));
    }

    private boolean mustaSyoKulmittain(int uusiX, int uusiY) {
        return ((uusiX == getX() + 1) && (uusiY == getY() + 1
                || uusiY == getY() - 1));
    }

    private boolean liikkuuYhdenYlos(int uusiX, int uusiY) {
        return ((uusiX == getX() - 1) && uusiY == getY());
    }

    private boolean liikkuuKaksiYlos(int uusiX, int uusiY) {
        return ((uusiX == getX() - 2) && uusiY == getY());
    }

    private boolean liikkuuYhdenAlas(int uusiX, int uusiY) {
        return ((uusiX == getX() + 1) && uusiY == getY());
    }

    private boolean liikkuuKaksiAlas(int uusiX, int uusiY) {
        return ((uusiX == getX() + 2) && uusiY == getY());
    }

    /**
     * Nappula-luokalta peritty metodi, joka palauttaa sotilaan uusiin
     * koordinaatteihin kulkeman reitin taulukossa.Taulukko sisältää siis
     * maksimissaan yhden arvon, koska päätepisteitä ei tallenneta taulukkoon ja
     * sotilas voi liikkua enintään kaksi ruutua kerralla.
     *
     * @param uusiX
     * @param uusiY
     * @return
     */
    @Override
    public List<int[]> tallennaReittiTaulukkoon(int uusiX, int uusiY) {

        int vanhaX = getX();
        int vanhaY = getY();
        if (Math.abs(uusiX - vanhaX) < 2) {
            return new ArrayList<int[]>();
        }
        List<int[]> reitti = new ArrayList<int[]>();

        if (uusiX < vanhaX) {
            reitti.add(new int[]{vanhaX - 1, vanhaY});

        } else if (uusiX > vanhaX) {
            reitti.add(new int[]{vanhaX + 1, vanhaY});
        }
        return reitti;
    }
}
