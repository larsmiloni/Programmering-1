/**
 * Klasse for rett
 */
public class Rett {
    private final String navn, oppskrift, type;
    private final double pris;

    /**
     * konstruktør til klassen Rett
     * @param navn navn på rett
     * @param pris pris på rett
     * @param oppskrift oppskrift til rett
     * @param type type rett (forrett, hovedrett, dessert)
     */
    public Rett(String navn, int pris, String oppskrift, String type){
        this.navn = navn;
        this.pris = pris;
        this.oppskrift = oppskrift;
        this.type = type;
    }
    public String getNavn() {
        return navn;
    }
    public double getPris() {
        return pris;
    }
    public String getOppskrift() {
        return oppskrift;
    }
    public String getType() {
        return type;
    }

    /**
     * @return navn, pris, oppskrift og type til objektet som en string.
     */
    public String toString(){
        return "Navn: " + this.getNavn() + ", Pris: " + this.getPris() + ", Type: " + this.getType() + ", Oppskrift: " + this.getOppskrift();
    }

    /**
     * kort verson av toString
     * @return navn og pris på objektet
     */
    public String toKortString(){
        return this.getNavn() + ": " + this.getPris() + "kr";
    }
}
