import java.util.Scanner;

class Oving1Oppgave2 {

    public static void main(String[] args){
        
        // lager scanner
        Scanner sc = new Scanner(System.in);

        // scanner for timer
        System.out.print("Antall Timer = ");
        int timer = sc.nextInt();
        
        // scanner for minutter
        System.out.print("Antall Minutter = ");
        int minutter = sc.nextInt();

        // scanner for sekunder
        System.out.print("Antall Sekunder = ");
        int sekunder = sc.nextInt();

        // avslutter scanner
        sc.close();

        // formel for å regne ut totalt antall sekunder
        int totaltAntallSekunder = timer * 3600 + minutter * 60 + sekunder;

        // printer ut totalt antall sekunder
        System.out.println("Totalt antall sekunder = " + totaltAntallSekunder);
    }
}
    