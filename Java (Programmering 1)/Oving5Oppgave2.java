import java.util.Random;
import java.util.Scanner;

class MinRandom{

    private static Random rn = new Random();
    private static Scanner sc = new Scanner(System.in);
    private static MinRandom minRandom = new MinRandom();
    

    //Random heltall i intervallet
    private int nesteHeltall(int nedre, int øvre){
        return rn.nextInt(øvre - nedre + 1) + nedre;
    }

    //Random desimaltall i intervallet
    private double nesteDesimaltall(int nedre, int øvre){
        return rn.nextDouble() * (øvre - nedre) + nedre;
    }

    public static void main(String[] args) {

        //Velge minste tall i intervallet
        System.out.print("Minste tall i intervallet: ");
        int nedre = sc.nextInt();
        //Velger største tall i intervallet
        System.out.print("Største tall i intervallet: ");
        int øvre = sc.nextInt();
        
        //Velge om man vil ha random heltall eller desimaltall
        System.out.print("Vil du ha et random heltall eller desimal?\nheltall = 1\ndesimaltall = 2\n: ");
        int valg = sc.nextInt();

        //heltall
        if (valg == 1){
            System.out.println("\nDitt randome heltall i intervallet [" + nedre + ", " + øvre + "] er " + minRandom.nesteHeltall(nedre,øvre));
        }

        //desimaltall
        else{
            System.out.println("\nDitt randome desimaltall i intervaller [" + nedre + ", " + øvre + "> er " + minRandom.nesteDesimaltall(nedre, øvre));
        }
        sc.close();
    }
}