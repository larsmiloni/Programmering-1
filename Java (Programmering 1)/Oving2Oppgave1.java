import java.util.Scanner;

public class Oving2Oppgave1 {

    public static void main(String[] args){

        // scanner
        Scanner cn = new Scanner(System.in);
        System.out.print("Hvilket år vil du sjekke om er et skuddår: ");
        int aar = cn.nextInt();
        cn.close();
        
        // (hvis år/4 er mulig og år/100 ikke er mulig) eller hvis (år/400 er )
        if ((aar % 4 == 0 && aar % 100 != 0) || (aar % 400 == 0)){
            System.out.println(aar + " er et skuddår.");
        }

        else{
            System.out.println(aar + " er ikke et skuddår.");
        }
    }
}

