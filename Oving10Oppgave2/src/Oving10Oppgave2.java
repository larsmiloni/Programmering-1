import java.util.ArrayList;
import java.util.Scanner;

/**
 * Klasse for psvm og metoder som tar input.
 */
public class Oving10Oppgave2 {

    public Scanner sc = new Scanner(System.in);
    public MenyRegister menyRegister = new MenyRegister();

    /**
     * main metode
     * lager et objekt av klassen Oving10Oppgave 2 for å utføre metodene testdata og meny.
     * Metoden meny går i en loop.
     * @param args
     */
    public static void main(String[] args) {
        Oving10Oppgave2 oving10Oppgave2 = new Oving10Oppgave2();
        oving10Oppgave2.testData();
        while (true) {
            oving10Oppgave2.meny();
        }
    }

    /**
     * Metode for test data.
     * Bruker metoden nyRett til å lage nye retter.
     */
    private void testData() {
        menyRegister.nyRett("Scampi", 60, "vet ikke", "Forrett");
        menyRegister.nyRett("Hvitløksbrød", 40, "vet ikke", "Forrett");
        menyRegister.nyRett("Pizza", 110, "vet ikke", "Hovedrett");
        menyRegister.nyRett("Burger", 120, "vet ikke", "Hovedrett");
        menyRegister.nyRett("Fløtegratinerte poteter", 150, "vet ikke", "Hovedrett");
        menyRegister.nyRett("Brownie", 85, "vet ikke", "Dessert");
        menyRegister.nyRett("Karamellpudding", 100, "vet ikke", "Dessert");
    }

    /**
     * Metode for meny
     * Spør brukeren om hvilke oprasjoner de vil utføre.
     * Man kan velge mellom 5 metoder man vil utføre.
     */
    private void meny() {
        System.out.println("");
        System.out.println("Tast 1 for å registrere ny rett");
        System.out.println("Tast 2 for å finne retter med et bestemt navn");
        System.out.println("Tast 3 for å finne alle retter av en gitt type");
        System.out.println("Tast 4 for å finne alle menyer innenfor et gitt prisintervall");
        System.out.println("Tast 5 for å registrere en ny meny");

        int menyValg = sc.nextInt();
        switch (menyValg) {
            case 1:
                nyRett();
                break;
            case 2:
                rettGittNavn();
                break;
            case 3:
                rettGittType();
                break;
            case 4:
                menyPrisintervall();
                break;
            case 5:
                nyMeny();
                break;
            default:
                System.out.println("Du må skrive inne et tall fra 1 til 5");
                break;
        }
    }

    /**
     * Metode for å lage en ny rett
     * Man skriver først inn navnet på retten man vil registrere,
     * om navnet allerede er brukt på en annen rett får man en beskjed om det, og man kommer ikke videre.
     * Hvis det er et nytt navn, blir man spurt om pris, type og oppskrift til retten.
     */
    private void nyRett() {
        sc.nextLine();
        System.out.print("Navn: ");
        String navn = sc.nextLine();
        if (menyRegister.getRettGittNavn(navn).size() > 0) {
            System.out.println("Det er allerede en rett med dette navnet registrert");
        }
        else {
            System.out.print("Type: ");
            String type = sc.nextLine();
            System.out.print("Pris: ");
            int pris = sc.nextInt();
            sc.nextLine();
            System.out.print("Oppskrift: ");
            String oppskrift = sc.nextLine();
            Rett nyRett = menyRegister.nyRett(navn, pris, oppskrift, type);
            System.out.println("Retten ble registrert");
            System.out.println(nyRett.toString());
        }
    }

    /**
     * Metode for å finne rett gitt type
     * Metoden spør deg om type
     * Metoden lager en ArrayList retterType som fylles med retter av gitt type ved å bruke metoden getAlleRetterAvEnType.
     * Så printer den ut alle rettene i retterType.
     */
    private void rettGittType() {
        sc.nextLine();
        System.out.print("Type: ");
        String type = sc.nextLine();
        ArrayList<Rett> retterType = menyRegister.getAlleRetterAvEnType(type);
        if (retterType.size() > 0) {
            for (int i = 0; i < retterType.size(); i++) {
                System.out.println(retterType.get(i).toString());
            }
        } else {
            System.out.println("Ingen retter av typen" + type + "er registrert");
        }
    }

    /**
     * Metode for å finne en rett gitt navnet
     * Metoden spør om navnet på retten
     * Metoden lager en ArrayList retterNavn som fylles med retter med det gitte navnet, ved å bruke metoden getRettGittNavn.
     * Metoden printer så ut alle rettene i retterNavn hvis det er retter med det gitte navnet,
     * eller forteller at det ikke finnes noen retter med det navnet om det ikke gjøre det.
     */
    private void rettGittNavn() {
        sc.nextLine();
        System.out.println("Navn: ");
        String navn = sc.nextLine();
        ArrayList<Rett> retterNavn = menyRegister.getRettGittNavn(navn);
        if (retterNavn.size() > 0) {
            for (int i = 0; i < retterNavn.size(); i++) {
                System.out.println(retterNavn.get(i).toString());
            }
        } else {
            System.out.println("Det er ingen retter registrert med navnet: " + navn);
        }
    }

    /**
     * Metode for å lage en ny meny
     * Metoden printer ut alle rettene man kan velge å legge inn i en ny meny.
     * I en while loop inne i metoden kan man skrive inn navnet på retten man vil legge til i menyen.
     * Hvis man skriver 1 er menyen ferdig, og lagret som meny, ved å bruke metoden nyMeny.
     */
    private void nyMeny() {
        boolean ferdig = false;
        ArrayList<Rett> retter = new ArrayList<Rett>();

        String alleRetter = "";
        for (int i = 0; i < menyRegister.getRetter().size(); i++) {
            if (i != 0) {
                alleRetter = alleRetter + ", ";
            }
            alleRetter = alleRetter + menyRegister.getRetter().get(i).toKortString();
        }
        System.out.println("Registrerte retter:");
        System.out.println(alleRetter);

        sc.nextLine();
        while (!ferdig) {
            if (retter.size() < 1) {
                System.out.print("Skriv inn navnet på retten som skal være med i menyen: ");
            } else {
                System.out.print("Tast 1 for å registrere menyen eller skriv inn navn på enda en rett som skal være med i menyen: ");
            }
            String navn = sc.nextLine();
            if (navn.equals("1")) {
                ferdig = true;
            } else {
                ArrayList<Rett> nyRett = menyRegister.getRettGittNavn(navn);
                if (nyRett.size() > 0) {
                    retter.add(nyRett.get(0));
                    System.out.println(navn + "ble lagt til i menyen");
                } else {
                    System.out.println("Fant ingen retter med navnet: " + navn);
                }
            }
        }
        System.out.println("Menyen ble registrert");
        menyRegister.nyMeny(retter);
    }

    /**
     * Metode for å finne menyer innenfor et prisintervall
     * Du skriver inn nedre og øvre pris.
     * Metoden lager en ArrayList menyerPrisintervall, og fyller den med alle menyene, ved å bruke metoden getMenyerPrisintervall.
     * Så sjekker metoden alle menyene i menyerPrisintervall, og hvis de er mellom nedre og øvre pris vil de bli printet ut.
     */
    private void menyPrisintervall() {
        System.out.print("Nedre pris: ");
        int minPris = sc.nextInt();
        System.out.print("Øvre pris: ");
        int maxPris = sc.nextInt();
        ArrayList<Meny> menyerPrisintervall = menyRegister.getMenyerPrisintervall(minPris, maxPris);
        System.out.println("Menyer mellom pris " + minPris + " og " + maxPris + ":");
        for (int i = 0; i < menyerPrisintervall.size(); i++) {
            System.out.println("Meny nr " + (i + 1) + ":");
            System.out.println(menyerPrisintervall.get(i).toString());
            System.out.println("");
        }
    }
}
