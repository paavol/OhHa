/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shakki;

/**
 * Abstraktin Nappula-luokan perivä luokka, joka pitää sisällään kyseisen
 * shakkinappulan erikoistoiminnot.
 *
 * @author paavolyy
 */
public class Kuningas extends Nappula {

    /**
     * Konstruktori luo Kuningas luokan ilmentymän, joka saa parametreina x- ja
     * y-koordinaatit ja perii abstraktin Nappula-luokan.
     *
     * @param x
     * @param y
     */
    public Kuningas(int x, int y, boolean valkoinenko) {
        super(x, y, valkoinenko);
    }

    /**
     * Metodi tarkistaa pystyykö nappula liikkumaan annettuihin
     * parametreihin.Metodi tarkistaa samalla onko haluttu liike Kuninkaan
     * oikeaoppisen liikkumisen mukainen ja onko parametreina annettu
     * koordinaatti shakkilaudalla.Tämän jälkeen asetetaan nappulalle uudet
     * koordinaatit ja palautetaan true.
     *
     * @param uusiX
     * @param uusiY
     *
     */
    /**
     * Metodi kertoo miten Kuningas pystyy ylipäänsä liikkumaan.Kuninkaan
     * liikkeillä on kaikkiaan kahdeksan eri mahdollisuutta, joista vähintään
     * yhden toteutuessa metodi palauttaa true.
     *
     * @param uusiX
     * @param uusiY
     *
     */
    @Override
    public boolean liiku(int uusiX, int uusiY) {

        if (uusiX == getX() + 1 && uusiY == getY()
                || uusiX == getX() + 1 && uusiY == getY() - 1
                || uusiX == getX() + 1 && uusiY == getY() + 1
                || uusiX == getX() - 1 && uusiY == getY()
                || uusiX == getX() - 1 && uusiY == getY() - 1
                || uusiX == getX() - 1 && uusiY == getY() + 1
                || uusiX == getX() && uusiY == getY()
                || uusiX == getX() && uusiY == getY() - 1
                || uusiX == getX() && uusiY == getY() + 1) {
            return true;
        }
        return false;
    }

    /**
     * Kuningas-luokan toString.
     *
     *
     */
    @Override
    public String toString() {
        return "K ";
    }

  }
