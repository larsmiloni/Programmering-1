import java.util.Scanner;

public class BareGodtaINT{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a integer: ");

        do{
            String input = sc.next();
            System.out.print("'" + input + "' is not a integer.\nTry again: ");
        }
        while (!sc.hasNextInt());
        
        int num = sc.nextInt();
        System.out.println("Your integer is :" + num);

        sc.close();
    }
}