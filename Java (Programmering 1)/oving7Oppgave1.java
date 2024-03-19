import java.util.Scanner;

public class oving7Oppgave1 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Skriv en setning: ");
        String setning = sc.nextLine();

        System.out.print("Tast 1 for å forkorte en tekst.\nTast 2 for å fjerne tegn fra tekst.\n: ");
        int menyValg = sc.nextInt();

        NyString tekst = new NyString(setning);

        if(menyValg == 1){
            System.out.println("Setningen forkortet: " + tekst.forkorting());
        }
        else{
            System.out.print("Hvilket tegn vil du fjerne fra setningen: ");
            String tegn = sc.next();
            
            System.out.println("Setning etter at bokstav er fjernet: " + tekst.FjerningAvTegn(tegn));
        }
        sc.close();
    }
}
