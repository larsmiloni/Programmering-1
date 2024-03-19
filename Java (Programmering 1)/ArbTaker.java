/**
 * Klasse for arbeidstaker med metoder for å hente og sette ny informasjon om arbeidstaker, og regne ut forskjellige ting om arbeidstaker.
 */
class ArbTaker{

    java.util.GregorianCalendar kalender = new java.util.GregorianCalendar();

    Person personalia;
    int arbTakerNr, ansettelsesår;
    double månedslønn, skatteprosent;

    /**
     * Konstruktør for arbeidstaker
     * @param personalia av datatypen Person fra klassen Person.
     * @param arbTakerNr nummer for arbeidstaker av datatypen int.
     * @param ansettelsesår til personen av datatypen int.
     * @param månedslønn til en person av datatypen int.
     * @param skatteprosent til en person av datatypen int.
     */
    ArbTaker(Person personalia, int arbTakerNr, int ansettelsesår, double månedslønn, double skatteprosent){
        this.personalia = personalia;
        this.arbTakerNr = arbTakerNr;
        this.ansettelsesår = ansettelsesår;
        this.månedslønn = månedslønn;
        this.skatteprosent = skatteprosent;
    }
    /**
     * Henter personalia.
     * @return personlia
     */
    public Person getPersonalia() {
        return personalia;
    }
    /**
     * Henter arbeidstaker nummer.
     * @return arbTakerNr
     */
    public int getArbTakerNr(){
        return arbTakerNr;
    }
    /**
     * Henter ansettelsesår.
     * @return ansettelsesår.
     */
    public int getAnsettelsesår(){
        return ansettelsesår;
    }
    /**
     * Henter månedslønn.
     * @return månedslønn
     */
    public double getMånedslønn(){
        return månedslønn;
    }
    /**
     * Henter skatteprosent.
     * @return skatteprosent
     */
    public double getSkatteprosent() {
        return skatteprosent;
    }
    /**
     * Setter en ny månedslønn.
     * @param månedslønn er den nye månedslønna.
     */
    public void setMånedslønn(double månedslønn) {
        this.månedslønn = månedslønn;
    }
    /**
     * Setter en ny skatteprosent.
     * @param skatteprosent er den nye skatteprosenten.
     */
    public void setSkatteprosent(double skatteprosent) {
        this.skatteprosent = skatteprosent;
    }
    /**
     * Regner ut skatt per måned.
     * @return månedslønn * skatteprosent/100
     */
    public double skattPerMåned(){
        double skattPerMåned = månedslønn * skatteprosent / 100;

        return skattPerMåned;
    }
    /**
     * Regner ut bruttolønn per år. 12 måneder i et år.
     * @return bruttomånedslønn * 12
     */
    public double bruttolønnPerÅr(){
        double bruttolønnPerÅr = månedslønn * 12;

        return bruttolønnPerÅr;
    }
    /**
     * Regner ut skattetrekk per år. Du betaler full skatt i 10 måneder, ikke skatt i juni og halv skatt i desember.
     * Det tilsvarer 10,5 måneder med skattebetaling.
     * @return skatt per måned * 10.5
     */
    public double skattetrekkPerÅr(){
        double skattetrekkPerÅr = skattPerMåned() * 10.5;
    
        return skattetrekkPerÅr;
    }
    /**
     * Setter sammen etternavn og fornavn fra klassen Person.
     * @return etternavn og fornavn fra klassen Person.
     */
    public String navn(){
        String navnPåForm = personalia.getEtternavn() + ", " + personalia.getFornavn();

        return navnPåForm;
    }
    /**
     * Regner ut alderen til en person. Variabelen år er hvilket år det er (2022).
     * @return år - fødselsår
     */
    public int alder(){
        int år = kalender.get(java.util.Calendar.YEAR);
        int alder = år - personalia.getFødselsår();

        return alder;
    }
    /**
     * Regner ut antall år personen er ansatt. Variabelen år er hvilket år det er (2022).
     * @return år - ansettelsesår
     */
    public int antallÅrAnsatt(){
        int år = kalender.get(java.util.Calendar.YEAR);
        int antallÅrAnsatt = år - ansettelsesår;
    
        return antallÅrAnsatt;
    }
    /**
     * Metoden finner ut av om personen er ansatt i lengre enn en tid.
     * @param ansattIMerEnn kan man sette inn en int i main for å sjekke om personen har vært ansatt i mer enn inten.
     * @return Ja om personen har vært ansatt i mer enn ansattIMerENN, og NEI hvis personen ikke har det.
     */
    public String ansattLengreEnn(int ansattIMerEnn){
        String ansattLengreEnn = "";
        if (antallÅrAnsatt() > ansattIMerEnn){
            ansattLengreEnn = "JA";
        }
        else{
            ansattLengreEnn = "NEI";
        }
        return ansattLengreEnn;
    }
}
