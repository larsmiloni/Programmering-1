/**
 * Klasse for person som inneholder en konstruktør med atributter fornavn, etternavn og fødselsår.
 * Metoder for hente fornavn, etternavn og fødselsår. 
 */
class Person{

    String fornavn, etternavn;
    int fødselsår;

    /**
     * Konstruktør for klassen Person.
     * @param fornavn til personen av datatypen string.
     * @param etternavn til personen av datatypen string.
     * @param fødselsår til personen av datatypen int
     */
    Person(String fornavn, String etternavn, int fødselsår){
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.fødselsår = fødselsår;
    }
    /**
     * Henter fornavn til en person.
     * @return fornavn
     */
    public String getFornavn(){
        return fornavn;
    }
    /**
     * Henter etternavn til en person.
     * @return etternavn
     */
    public String getEtternavn(){
        return etternavn;
    }
    /**
     * Henter fødselsår til en person.
     * @return fødselsår
     */
    public int getFødselsår(){
        return fødselsår;
    }
}