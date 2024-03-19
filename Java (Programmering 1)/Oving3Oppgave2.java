import java.util.Scanner;

public class Oving3Oppgave2 {
    
    public static void main(String[] args){

        


        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Hvilket tall vil du sjekke om er et primtall: "); 
            
            // While loop for å sjekke om tall er heltall.
            while (!sc.hasNextInt()){
                System.out.print("\nProgrammet godtar bare heltall.\nPrøv igjen: ");
                sc.next();
            }
            int tall = sc.nextInt();

            // Sjekker om tall fra i opp til halvparten av tallet du valgte gir rest.
            boolean flag = true;
            for (int i = 2; i <= tall / 2; ++i) {
                //Hvis tallet delt på i ikke gir rest er det ikke et primtall. Da blir for loopen breaka og flag = false.
                if (tall % i == 0){
                    flag = false;
                    break;
                }
            }

            if (!flag){
                System.out.println(tall + " er IKKE et primtall.\n");
            }
            else if (flag){
                System.out.println(tall + " er et primtall.\n");
            }
            else{
                sc.close();
            }
        } 
    }
}
