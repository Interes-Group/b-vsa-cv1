package sk.stuba.fei.uim.vsa.service;

public interface BookServiceInterface {

    /**
     *  nájde v DB knihu so zadaným menom a vráti jej cenu. Ak neexistuje taká kniha vráti -1 a vypíše spávu "Knihu nemáme"
     * @param meno
     * @return
     */
    double cenaKnihy(String meno);

    /**
     * pridá do DB knihu s daným menom a cenou. Ak kniha s daným menom v DB už existuje, vráti false.
     * @param meno
     * @param cena
     * @return
     */
    boolean pridajKnihu(String meno, double cena);

    /**
     *  ktorá nájde v DB knihu so zadaným menom a zníži jej cenu o o 20% (v databáze). Ak neexistuje taká kniha neurobí nič.
     * @param meno
     */
    void zlava(String meno);
}
