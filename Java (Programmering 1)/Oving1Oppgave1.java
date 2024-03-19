import java.util.Scanner;

class Oving1Oppgave1 {

    public static void main(String[] args){

        // tittel
        System.out.println("Tommer til centimeter.");

        // scanner (tommer fra bruker)
        Scanner sc = new Scanner(System.in);
        System.out.print("Antall tommer = ");
        double tommer = sc.nextDouble();
        sc.close();

        // tommer til centimeter formel
        Double centimeter = tommer * 2.54;

        // printer ut (x tommer = y centimeter)
        System.out.println(tommer + " tommer = " + centimeter + " centimeter");
        
    }
}