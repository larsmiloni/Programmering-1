import java.util.Scanner;

/**
 * Hovedklasse med psvm for å kjør koden.
 * Klasse hente informasjon som printer ut all informasjon om en arbeidstaker.
 */
public class oving8Oppgave1{

    /**
     * main metode med objekter for person og arbeidstaker.
     */
    public static void main(String[] args) {
        
        Person person1 = new Person("Lars Mikkel", "Nilsen", 2003);
        ArbTaker arbtaker1 = new ArbTaker(person1, 5, 2019, 20000, 20);

        meny(arbtaker1);
    }

    /**
     * Metode som printer ut all informasjon om en arbeidstaker.
     * @param arbtaker er hvilken arbeidstaker man skal printe ut informasjonen om.
     */

public static void hentInformasjon(ArbTaker arbtaker){
        int ansattIMerEnn = 6;

        System.out.println("Navn: " + arbtaker.navn());
        System.out.println("Alder: " + arbtaker.alder());
        System.out.println("Betaler: " + arbtaker.skattPerMåned() + " i skatt per måneden.");
        System.out.println("Bruttolønn per år er: " + arbtaker.bruttolønnPerÅr());
        System.out.println("Skattetrekk per år er: " + arbtaker.skattetrekkPerÅr());
        System.out.println("Har vært ansatt i bedriften i " + arbtaker.antallÅrAnsatt() + " år");
        System.out.println("Har person 1 vært ansatt i mer enn " + ansattIMerEnn + " år? " + arbtaker.ansattLengreEnn(ansattIMerEnn) + "!!!");
        System.out.println("Månedslønn er: " + arbtaker.getMånedslønn());
        System.out.println("Skatteprosent er: " + arbtaker.getSkatteprosent() + "\n");
    }

    /**
     * Metode for en meny, hvor man kan endre på månedslønn og skatteprosent.
     * @param arbTaker arbeidstaker man vil bruke i menyen
     */
    
    public static void meny(ArbTaker arbTaker){
        Scanner sc = new Scanner(System.in);
        boolean meny = true;

        hentInformasjon(arbTaker);

        while(meny){
            System.out.print("1 = Endre månedslønn\n2 = Endre skatteprosent\n3 = Ikke endre noe\n: ");
            int menyValg = sc.nextInt();

            switch(menyValg){
                case 1:
                    System.out.print("Månedslønnen er: " + arbTaker.månedslønn + "\nNy månedslønn: ");
                    double nyMånedslønn = sc.nextDouble();
                    arbTaker.setMånedslønn(nyMånedslønn);
                    hentInformasjon(arbTaker);
                    break;
                case 2:
                    System.out.print("Skatteprosenten er: " + arbTaker.skatteprosent + "%\nNy skatteprosen: ");
                    double nySkatteprosent = sc.nextDouble();
                    arbTaker.setSkatteprosent(nySkatteprosent);
                    hentInformasjon(arbTaker);
                    break;
                case 3:
                    hentInformasjon(arbTaker);
                    meny = false;
            }
        }
        sc.close();
    }
}