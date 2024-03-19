/**
 * Klasse for eiendom
 */
public class Eiendom {
    private final String kommuneNavn, bruksnavn;
    private String eier;
    private final int kommuneNr, gårdsNr, bruksNr;
    private double areal;

    /**
     * Konstruktør som lager en ny eiendom
     * @param kommuneNavn kommune navn
     * @param kommuneNr kommune nummer
     * @param gårdsNr gårds nummer
     * @param bruksNr bruks nummer
     * @param bruksnavn bruks navn
     * @param areal areal til eiendom
     * @param eier eier til eiendom
     */
    public Eiendom(String kommuneNavn, int kommuneNr, int gårdsNr, int bruksNr, String bruksnavn, double areal, String eier){
        this.kommuneNavn = kommuneNavn;
        this.kommuneNr = kommuneNr;
        this.gårdsNr = gårdsNr;
        this.bruksNr = bruksNr;
        this.bruksnavn = bruksnavn;
        this.areal = areal;
        this.eier = eier;
    }

    /**
     * Konstruktør som lager en deep kopi av en eiendom.
     * @param eiendom eiendom som skal kopieres.
     */
    public Eiendom(Eiendom eiendom) {
        this.kommuneNavn = eiendom.getKommuneNavn();
        this.kommuneNr = eiendom.getKommuneNr();
        this.gårdsNr = eiendom.getGårdsNr();
        this.bruksNr = eiendom.getBruksNr();
        this.bruksnavn = eiendom.getBruksnavn();
        this.areal = eiendom.getAreal();
        this.eier = eiendom.getEier();

    }
    public String getKommuneNavn() {
        return kommuneNavn;
    }
    public int getKommuneNr() {
        return kommuneNr;
    }
    public int getGårdsNr() {
        return gårdsNr;
    }
    public int getBruksNr() {
        return bruksNr;
    }
    public String getBruksnavn() {
        return bruksnavn;
    }
    public double getAreal() {
        return areal;
    }
    public String getEier() {
        return eier;
    }

    public void setAreal(double areal) {
        this.areal = areal;
    }
    public void setEier(String eier) {
        this.eier = eier;
    }

    /**
     * @return kommuneNr, gårdsNr og bruksNr satt sammen til en unik eiendoms id.
     */
    public String getEindomID(){
        return kommuneNr + "-" + gårdsNr + "/" + bruksNr;
    }
    /**
     * @return all informasjon om et objekt av klasse eiendom.
     */
    public String toString() {
        if(bruksnavn.equals("")) {
            return "Eiendom{" +
                    "kommuneNavn=" + kommuneNavn +
                    ", eier=" + eier +
                    ", kommuneNr=" + kommuneNr +
                    ", gårdsNr=" + gårdsNr +
                    ", bruksNr=" + bruksNr +
                    ", areal=" + areal +
                    ", eiendoms id=" + getEindomID() +
                    '}';
        }
        else {
            return "Eiendom{" +
                    "kommuneNavn=" + kommuneNavn +
                    ", bruksnavn=" + bruksnavn +
                    ", eier=" + eier +
                    ", kommuneNr=" + kommuneNr +
                    ", gårdsNr=" + gårdsNr +
                    ", bruksNr=" + bruksNr +
                    ", areal=" + areal +
                    ", eiendoms id=" + getEindomID() +
                    '}';
        }
    }
}
