import java.util.Scanner;

public class Oppgave_undervisning {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Poeng: ");
        int poeng = sc.nextInt();
        sc.close();

        if(poeng >= 96){
            System.out.println("Karakter: A");
        }
        else if (poeng >= 86 && poeng <= 95){
            System.out.println("Karakter: B");
        }
        else if (poeng >= 71 && poeng <= 85){
            System.out.println("Karakter: C");
        }
        else if (poeng >= 55 && poeng <= 70){
            System.out.println("Karakter: D");
        }
        else if (poeng >= 36 && poeng <= 54){
            System.out.println("Karakter: E");
        }
        else{
            System.out.println("Karakter: F");
        }
    }
}