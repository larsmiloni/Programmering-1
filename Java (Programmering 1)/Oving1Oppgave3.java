import java.util.Scanner;

public class Oving1Oppgave3 {
    
    public static void main(String[] args){
        
        // lager scanner 
        Scanner sc = new Scanner(System.in);
        System.out.print("Antall sekunder du vil gjøre om til timer, minutter og sekunder: ");
        int sekunder1 = sc.nextInt();
        sc.close();
        
        // regner ut timer 
        int timer = sekunder1 / 3600;

        // regner ut minutter
        int minutter = (sekunder1 - timer*3600) / 60;

        // regner ut sekunder
        int sekunder = (sekunder1 - timer*3600 - minutter*60);

        // printer ut antall timer minutter og sekunder
        System.out.println("Antall timer = " + timer);
        System.out.println("Antall minutter = " + minutter);
        System.out.println("Antall sekunder = " + sekunder);

    }
}
