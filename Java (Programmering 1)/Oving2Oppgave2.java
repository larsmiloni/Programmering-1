
public class Oving2Oppgave2{

    public static void main(String[] args){

        double KjottdeigPrisA = 35.90;
        double KjottdeigVektA = 450;
        double PrisPrGramA = KjottdeigPrisA / KjottdeigVektA;

        double KjottdeigPrisB = 39.50;
        double KjottdeigVektB = 500;
        double PrisPrgramB = KjottdeigPrisB / KjottdeigVektB;

        if (PrisPrGramA > PrisPrgramB){
            System.out.println("Kjøttdeig B er billigst.");
        }
        else if (PrisPrGramA == PrisPrgramB){
            System.out.println("Kjøttdeig A og Kjøttdeig B koster like mye.");
        }
        else{
            System.out.println("Kjøttdeig A er billigst.");
        }
    }
}