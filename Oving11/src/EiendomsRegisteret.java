import java.util.ArrayList;

/**
 * Klasse for eiendoms registeret
 */
public class EiendomsRegisteret {

    private final ArrayList<Eiendom> eiendommer;

    /**
     * Konstruktør som lager en ny ArrayList eiendommer som kan inneholde objekter fra klassen eiendom.
     */
    public EiendomsRegisteret(){
        eiendommer = new ArrayList<>();
    }
    public ArrayList<Eiendom> getEiendommer(){
        return eiendommer;
    }

    /**
     * Metode for å legge til en ny eiendom i registeret.
     * @param kommuneNavn
     * @param kommuneNr
     * @param gårdsNr
     * @param bruksNr
     * @param bruksNavn
     * @param areal
     * @param eier
     * @return nyEiendom
     */
    public void nyEiendom(String kommuneNavn, int kommuneNr, int gårdsNr, int bruksNr, String bruksNavn, double areal, String eier){
        eiendommer.add(new Eiendom(kommuneNavn, kommuneNr, gårdsNr, bruksNr, bruksNavn, areal, eier));
    }

    /**
     * Metode for å slette en eiendom fra registeret.
     * @param eiendomsId til eiendom som skal slettes.
     */
    public void sletteEiendom(String eiendomsId){
        for (int i = 0; i < getAntallEiendommer(); i++){
            if(eiendommer.get(i).getEindomID().equals(eiendomsId)){
                eiendommer.remove(i);
            }
        }
    }
    public int getAntallEiendommer(){
        return eiendommer.size();
    }

    /**
     * Metode for å finne en eiendom gitt eiendoms id-en.
     * @param eiendomsId til eiendommen man vil finne.
     * @return en kopi av eiendommen med gitt eiendoms id.
     */
    public Eiendom finneEiendomEiendomsId(String eiendomsId){
        Eiendom eiendom = new Eiendom(null,0,0,0,null,0,null);
        for (int i = 0; i < eiendommer.size(); i++){
            if(eiendommer.get(i).getEindomID().equals(eiendomsId)){
                return new Eiendom(eiendommer.get(i));
            }
        }
        return null;
    }

    /**
     * Metode som regner ut gjennomsnittlig areal til eiendommene i registeret.
     * @return gjennomsnittlig areal.
     */
    public double gjennomsnittsAreal(){
        double totAreal = 0;
        for(int i = 0; i < eiendommer.size(); i++){
            totAreal += eiendommer.get(i).getAreal();
        }
        return totAreal / getAntallEiendommer();
    }

    /**
     * Metode for å finne en eiendomer gitt gårdsnummer.
     * @param gårdsNr til eiendommene du vil finne.
     * @return alle eiendommene registrert med gårdsnummeret.
     */
    public ArrayList<Eiendom> eiendommerMedGårdsNr(int gårdsNr){
        ArrayList<Eiendom> gårdsNrArr = new ArrayList<>();
        for (int i = 0; i < getAntallEiendommer(); i++){
            if(eiendommer.get(i).getGårdsNr() == gårdsNr) {
                gårdsNrArr.add(eiendommer.get(i));
            }
        }
        return gårdsNrArr;
    }

    /**
     * toString metode for klassen EiendomsRegisteret.
     * @return alle eiendommene i eiendomsregisteret.
     */
    public String toString() {
        StringBuilder seAlle = new StringBuilder();
        for (int i = 0; i < eiendommer.size(); i++){
            seAlle.append("\n").append(eiendommer.get(i));
        }
        return seAlle.toString();
    }
}
