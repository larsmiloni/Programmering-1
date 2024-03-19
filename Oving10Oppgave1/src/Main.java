import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Klasse for main metode og ande metoder med input fra brukeren.
 */
public class Main {
    private Scanner sc = new Scanner(System.in);
    private  ArrangementRegister register = new ArrangementRegister();

    public static void main(String[] args) {
        Main m = new Main();
        while(true){
            m.meny();
        }
    }

    /**
     * Metode for meny hvor man kan velge mellom 5 ulike oprasjoner.
     */
    private void meny(){
        System.out.println("Tast 1 for å registrere et nytt arangement.");
        System.out.println("Tast 2 for å finne arrangementer på et gitt sted.");
        System.out.println("Tast 3 for å finne arrangementer på en gitt dato.");
        System.out.println("Tast 4 for å finne arrangementer innenfor et tidsintervall.");
        System.out.println("Tast 5 for å sortere arrangementene etter sted, type eller tidspunkt.");

        int menyValg = sc.nextInt();

        switch (menyValg){
            case (1):
                lagArrangement();
                break;
            case (2):
                stedArr();
                break;
            case (3):
                datoArr();
                break;
            case (4):
                arrInnenforTidsintervall();
                break;
            case (5):
                sortereArr();
        }
    }

    /**
     * Metode for å skrive ut alle arrangementer i en ArrayList
     * @param liste
     */
    private void skrivUtArrangement(ArrayList<Arrangement> liste){
        if (liste.size() > 0){
                System.out.println(liste);
        }
        else{
            System.out.println("Fant ingen arrangementer.");
        }
    }

    /**
     * Metode for å lage et nytt arangement.
     */
    private void lagArrangement(){
        sc.nextLine();
        System.out.print("Navn: "); String navn = sc.nextLine();
        System.out.print("Sted: "); String sted = sc.nextLine();
        System.out.print("Arrangør: "); String arrangør = sc.nextLine();
        System.out.print("Type: "); String type = sc.nextLine();
        System.out.print("Tidspunkt (YYYYMMDDTTMM): "); double tidspunkt = sc.nextDouble();
        Arrangement a = register.nyttArrangement(navn, sted, arrangør, type, tidspunkt);
        register.arrangementer.add(a);
    }

    /**
     * Metode for å finne arrangementer på gitt sted.
     */
    private void stedArr(){
        sc.nextLine();
        System.out.print("Sted: ");
        String sted = sc.nextLine();
        skrivUtArrangement(register.listeArrPåSted(sted));
    }

    /**
     * Metode for å finne arrangementer på en gitt dato.
     */
    private void datoArr(){
        System.out.println("Dato (YYYYMMDD): ");
        double dato = sc.nextDouble();
        skrivUtArrangement(register.listeArrPåDato(dato));
    }

    /**
     * Metode for å finne arangementer innenfor et tidsintervall.
     */
    private void arrInnenforTidsintervall(){
        System.out.println("Startdato (YYYYMMDD): ");
        double startdato = sc.nextDouble();
        System.out.println("Sluttdato (YYYYMMDD): ");
        double sluttdato = sc.nextDouble();
        skrivUtArrangement(register.listeArrInnenforTidsintervall(startdato, sluttdato));
    }

    /**
     * Metode for å sortere arrangementene
     * Du kan velge om du vil sortere etter sted, type eller tidspunkt.
     */
    private void sortereArr(){
        System.out.println("Tast 1 for å sortere etter sted.");
        System.out.println("Tast 2 for å sortere etter type.");
        System.out.println("Tast 3 for å sortere etter tidspunkt.");
        int valg = sc.nextInt();
        switch (valg){
            case(1):
                Comparator<Arrangement> sorterEtterSted = Comparator.comparing(Arrangement::getSted);
                ArrayList<Arrangement> arr1 = register.arrangementer;
                Collections.sort(arr1, sorterEtterSted);
                skrivUtArrangement(arr1);
                break;
            case(2):
                Comparator<Arrangement> sorterEtterType = Comparator.comparing(Arrangement::getType);
                ArrayList<Arrangement> arr2 = register.arrangementer;
                Collections.sort(arr2, sorterEtterType);
                skrivUtArrangement(arr2);
                break;
            case(3):
                Comparator<Arrangement> sorterEtterTid = Comparator.comparingInt((Arrangement a) -> (int) a.getTidspunkt());
                ArrayList<Arrangement> arr3 = register.arrangementer;
                Collections.sort(arr3, sorterEtterTid);
                skrivUtArrangement(arr3);
                break;
            default:
                System.out.println("Du må taste et tall fra 1-3.");
                sortereArr();
                break;
        }
    }
}
