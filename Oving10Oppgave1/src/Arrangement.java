/**
 * Klasse for et arrangement
 */
public class Arrangement {
    private final int entydigNr;
    private String navn, sted, arrangør, type;
    private double tidspunkt;

    /**
     * Konstruktøren til klasse arangement
     * @param entydigNr entydig nummer på arrangemntet
     * @param navn på arangementet
     * @param sted hvor arrangementet skal holdes
     * @param arrangør til arrangementet
     * @param type arrangement
     * @param tidspunkt arrangementet skal holdes
     */
    public Arrangement(int entydigNr, String navn, String sted, String arrangør, String type, double tidspunkt){
        this.entydigNr = entydigNr;
        this.navn = navn;
        this.sted = sted;
        this.arrangør = arrangør;
        this.type = type;
        this.tidspunkt = tidspunkt;
    }

    public int getEntydigNr() {
        return entydigNr;
    }

    public String getNavn() {
        return navn;
    }

    public String getSted() {
        return sted;
    }

    public String getArrangør() {
        return arrangør;
    }

    public String getType() {
        return type;
    }

    public double getTidspunkt() {
        return tidspunkt;
    }

    /**
     * @return informasjon om et objekt av klasse Arrangement som String
     */
    public String toString() {
        String t = String.format("%.1f", this.getTidspunkt());
        String tid = t.substring(6, 8) + "." + t.substring(4, 6) + "." + t.substring(0, 4) + " kl. " + t.substring(8, 10) + ":" + t.substring(10, 12);
        return "Id: " + this.getEntydigNr() + ", navn: " + this.getNavn() + ", sted: " + this.getSted() + ", arrangør: " + this.getArrangør() + ", type: " + this.getType() + ", tidspunk: " + tid + "\n";
    }
}

