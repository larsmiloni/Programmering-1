import java.util.Scanner;

public class Oving3Oppgave1 {
    public static void main(String[] args){
        
        // Aktiverer scanner
        Scanner sc = new Scanner(System.in);
        
        // Gangetabell fra. While loop som avsluttes bare om man skriver heltall.
        System.out.print("Hva vill du ha ti gangen fra: ");
        while (!sc.hasNextInt()){
            System.out.print("\nProgrammet godtar bare heltall.\nPrøv igjen: ");
            sc.next();
        }
        int tiGangenFra = sc.nextInt();
        
        // Gangetabellen til. While loop som avsluttes bare om man skriver heltall.
        System.out.print("Hva vill du ha ti gangen til: ");
        while (!sc.hasNextInt()){
            System.out.print("\nProgrammet godtar bare heltall.\nPrøv igjen: ");
            sc.next();
        }
        int tiGangenTil = sc.nextInt();
        sc.close();


        int i = tiGangenFra;
        int j = 1;

        // Yterste loop for å få mellomrom mellom en 10er-gangetabell. Gjentar seg helt til tiGangenTil er større eller erlik i).
        do {
            System.out.println("");

            // Inderste loop for å skrive et gangestykke. Gjentar seg j = 1 til j = 10.
            do {
                System.out.println(i + "*" + j + " = " + i * j);
                j++;
            } while (j <= 10);

            i++;
            j = 1;
        } while (i <= tiGangenTil);
    }
}