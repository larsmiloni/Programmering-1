import java.util.ArrayList;

/**
 * klasse for meny
 */
public class Meny {
    private ArrayList<Rett> retter;

    /**
     * konstruktøren til klassen Meny
     * @param retter tar inn en Arraylist som kan inneholde retter
     */
    public Meny(ArrayList<Rett> retter) {
        this.retter = retter;
    }

    /**
     * @return returner ArrayListen retter
     */
    public ArrayList<Rett> getRetter() {
        return retter;
    }

    /**
     * legger sammen alle prisene på rettene i ArrayLiseten retter.
     * @return total pris på alle rettene i retter.
     */
    public double getTotPris() {
        double pris = 0;
        for (int i = 0; i < getRetter().size(); i++) {
            pris += getRetter().get(i).getPris();
        }
        return pris;
    }

    /**
     * toString for meny. brukes i metoden for å finne menyer i et tidsintervall.
     * @return retter i menyen og totalpris hvi menyen er i tidsintervallet.
     */
    public String toString() {
        StringBuilder retter = new StringBuilder();
        for (int i = 0; i < getRetter().size(); i++) {
            if (i != 0) {
                retter.append(", ");
            }
            retter.append(getRetter().get(i).toKortString());
        }
        retter.append("\nTotal pris: ").append(getTotPris());
        return retter.toString();
    }

}
