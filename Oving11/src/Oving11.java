import java.util.Scanner;

public class Oving11 {

    EiendomsRegisteret eiendomer = new EiendomsRegisteret();
    Scanner sc = new Scanner(System.in);

    /**
     * Main metode til programmet. Kjører metoden meny i en while loop.
     * @param args
     */
    public static void main(String[] args) {
        Oving11 o = new Oving11();
        o.testData();
        while(true){
            o.meny();
        }
    }

    /**
     * Metode for å legge inn testdata i eiendoms registeret.
     */
    public void testData(){
        eiendomer.nyEiendom("Gloppen", 1445, 77, 631, "", 1017.6, "Jens Olsen");
        eiendomer.nyEiendom("Gloppen", 1445, 77, 131, "Syningom", 661.3, "Nicolay Madsen");
        eiendomer.nyEiendom("Gloppen", 1445, 75, 19, "Fugletun", 650.6, "Evilyn Jensen");
        eiendomer.nyEiendom("Gloppen", 1445, 74, 188, "", 1457.2, "Karl Ove Bråten");
        eiendomer.nyEiendom("Gloppen", 1445, 69, 47, "Høiberg", 1339.4, "Elsa Indregård");
    }

    /**
     * Metode for meny. Gir brukere 7 valg som utfører forskjellige oprasjoner.
     */
    public void meny(){
        int menyValg = 0;
        try {
            System.out.println("");
            System.out.println("Tast (1) for å registrere en ny eiendom");
            System.out.println("Tast (2) for å se alle eiendommene registrert");
            System.out.println("Tast (3) for å finne en eiendom med EiendomsId");
            System.out.println("Tast (4) for å regne ut gjennomsnittlig areal til eiendommene");
            System.out.println("Tast (5) for å se antall eiendommer registrert");
            System.out.println("Tast (6) for å slette en eiendom");
            System.out.println("Tast (7) for å avslutte programmet");
            menyValg = Integer.parseInt(sc.nextLine());
        }
        catch (NumberFormatException nfe){
            System.out.println("ugyldig input");
        }
        switch (menyValg) {
            case 1 -> nyEiendom();
            case 2 -> seAlle();
            case 3 -> eiendomGittEiendomsId();
            case 4 -> gjennomsnittAreal();
            case 5 -> antallEiendommer();
            case 6 -> sletteEiendom();
            case 7 -> System.exit(0);
            default -> System.out.println("Du må skrive et tall mellom 1 og 7.");
        }
    }

    /**
     * Metode for å lage en ny eiendom.
     */
    public void nyEiendom(){
        String kommuneNavn = null, bruksNavn = null, eier = null;
        int kommuneNr = 0, gårdsNr = 0, bruksNr = 0;
        double areal = 0;
        try {
            System.out.print("Kommune navn: ");
            kommuneNavn = sc.nextLine();
            System.out.print("Kommune nummer: ");
            kommuneNr = Integer.parseInt(sc.nextLine());
            System.out.print("Gårds nummer: ");
            gårdsNr = Integer.parseInt(sc.nextLine());
            System.out.print("Bruks nummer: ");
            bruksNr = Integer.parseInt(sc.nextLine());
            System.out.print("Bruks navn: ");
            bruksNavn = sc.nextLine();
            System.out.print("Areal: ");
            areal = Double.parseDouble(sc.nextLine());
            System.out.print("Eier: ");
            eier = sc.nextLine();
        }
        catch (NumberFormatException nfe){
            System.out.println("ugyldig input");
            return;
        }
        eiendomer.nyEiendom(kommuneNavn, kommuneNr, gårdsNr, bruksNr, bruksNavn, areal, eier);
        System.out.println("Eiendommen ble lagt til i registeret.");
    }

    /**
     * Metode for å se alle eiendommer registrert.
     * Metoden bruker toString metoden til Eiendomsregisteret.
     */
    public void seAlle(){
        if(eiendomer.getAntallEiendommer() == 0){
            System.out.println("Det er ingen eiendommer som er registrert.");
        }
        else {
            System.out.println("Registrerte eiendommer:");
            System.out.println(eiendomer);
        }
    }

    /**
     * Metode for å finne en eiendom gitt eiendoms id.
     * Metoden bruker finneEiendomEiendomsId metoden til klassen EiendomsRegisteret.
     */
    public void eiendomGittEiendomsId(){
        System.out.println(eiendomer);
        System.out.print("Eiendom Id: ");
        String eiendomsId = sc.nextLine();
        for (int i = 0; i < eiendomer.getAntallEiendommer(); i++){
            if(eiendomer.getEiendommer().get(i).getEindomID().equals(eiendomsId)){
                System.out.println(eiendomer.finneEiendomEiendomsId(eiendomsId));
                return;
            }
        }
        System.out.println("Det er IKKE registrert en eiendom med den eiendom id-en.");
    }

    /**
     * Metode for å finne gjenomsnittlig areal til eiendommene i registeret.
     * Bruker metoden gjennomsnittsAreal fra klasse EiendomsRegisteret.
     */
    public void gjennomsnittAreal(){
        if (eiendomer.getAntallEiendommer() == 0){
            System.out.println("Det er ingen eiendommer registrert");
        }
        else {
            System.out.println("Gjenomsnittlig areal: ");
            System.out.println(eiendomer.gjennomsnittsAreal());
        }
    }

    /**
     * Antall eiendommer i registeret.
     * Bruker metoden getAntallEiendommer fra klasse EiendomsRegisteret.
     */
    public void antallEiendommer(){
        System.out.println("Antall eiendommer registrert: ");
        System.out.println(eiendomer.getAntallEiendommer());
    }

    /**
     * Metode for å slette eiendom.
     * Bruker metoden slettEiendom fra klassen EiendomsRegisteret.
     */
    public void sletteEiendom (){
        if (eiendomer.getAntallEiendommer() == 0){
            System.out.println("Det er ingen eiendommer registrert");
        }
        else {
            System.out.println(eiendomer);
            System.out.println("Skriv inn eiendoms id-en til den eiendommen du vil slette fra registeret.");
            String eiendommsId = sc.nextLine();

            for(int i = 0; i < eiendomer.getAntallEiendommer(); i++){
                if(eiendomer.getEiendommer().get(i).getEindomID().equals(eiendommsId)){
                    eiendomer.sletteEiendom(eiendommsId);
                    System.out.println("Eiendommen ble slettet");
                    return;
                }
            }
            System.out.println("Det er IKKE registrert en eiendom med den eiendoms id-en.");
        }
    }
}
