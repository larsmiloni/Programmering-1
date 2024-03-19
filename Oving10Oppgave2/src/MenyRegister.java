import java.util.ArrayList;

/**
 * klasse for meny register
 */
public class MenyRegister {

    private ArrayList<Meny> menyer;
    private ArrayList<Rett> retter;

    /**
     * konstruktør for menyregister
     * lager en Arraylist som kan inneholde menyer
     * og en Arraylist som kan inneholde retter
     */
    public MenyRegister(){
        menyer = new ArrayList<>();
        retter =  new ArrayList<>();
    }
    public ArrayList<Rett> getRetter(){
        return retter;
    }
    public ArrayList<Meny> getMenyer(){
        return menyer;
    }

    /**
     * Metode for å registrere en ny rett
     * metoden legger retten i ArrayListen retter.
     * @param navn på rett
     * @param pris på rett
     * @param oppskrift på rett
     * @param type rett
     * @return rett
     */
    public Rett nyRett(String navn, int pris, String oppskrift, String type){
        Rett rett = new Rett(navn, pris, oppskrift, type);
        retter.add(rett);
        return rett;
    }

    /**
     * Metode for å finne en rett gitt navnet.
     * Metoden sjekker alle rettene i ArrayListen retter om navnene er lik navnet metoden har fått.
     * så legger de retten i ArrayListen arrNavn om navnet er likt
     * @param navn på rett
     * @return arrNavn
     */
    public ArrayList<Rett> getRettGittNavn(String navn){
        ArrayList<Rett> arrNavn = new ArrayList<Rett>();
        for (int i = 0; i < getRetter().size(); i++){
            if (getRetter().get(i).getNavn().toLowerCase().equals(navn.toLowerCase())){
                arrNavn.add(getRetter().get(i));
            }
        }
        return arrNavn;
    }

    /**
     * Metode for å finne alle rettene av en gitt type
     * Sjekker alle rettene i ArrayListen retter, hvis typen til retten i ArrayListen er lik typen gitt til metoden
     * vil retten bli lagt i ArrayListen arrType
     * @param type på rett
     * @return arrType
     */
    public ArrayList<Rett> getAlleRetterAvEnType(String type){
        ArrayList<Rett> arrType = new ArrayList<Rett>();
        for(int i = 0; i < getRetter().size(); i++){
            if (getRetter().get(i).getType().toLowerCase().equals(type.toLowerCase())){
                arrType.add(getRetter().get(i));
            }
        }
        return arrType;
    }

    /**
     * Metode for å lage en ny meny
     * @param retter som skal være med i menyen
     * @return meny
     */
    public Meny nyMeny(ArrayList<Rett> retter){
        Meny meny = new Meny(retter);
        getMenyer().add(meny);
        return meny;
    }

    /**
     * Metode for å finne alle menyer innenfor et gitt tidsintervall.
     * Sjekker alle menyer i ArrayListen menyer om de er innenfor prisintervallet,
     * hvis de er det vil menyen bli lagt til i ArrayListen arrPrisintervall
     * @param minPris minimum pris på menyen
     * @param maxPris maximum pris på menyen
     * @return arrPrisintervall
     */
    public ArrayList<Meny> getMenyerPrisintervall(double minPris, double maxPris){
        ArrayList<Meny> arrPrisintervall = new ArrayList<Meny>();
        for(int i = 0; i < getMenyer().size(); i++){
            if(getMenyer().get(i).getTotPris() <= maxPris && getMenyer().get(i).getTotPris() >= minPris){
                arrPrisintervall.add(getMenyer().get(i));
            }
        }
        return arrPrisintervall;
    }
}
