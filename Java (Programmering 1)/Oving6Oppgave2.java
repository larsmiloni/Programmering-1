import java.util.Scanner;

public class Oving6Oppgave2{
    public static void main(String[] args) {
        
        while (true){
            tekstInput();
        }
    
    }
    public static void tekstInput(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Skriv inn tekst: ");
        String tekst = sc.nextLine();
        Tekstanalyse tekstanalyse = new Tekstanalyse(tekst);
        if(tekst == "")
            sc.close();
        else
            resultater(tekstanalyse);
    }

    public static void resultater(Tekstanalyse tekstanalyse){
        String bokstav = "a";

        System.out.println("\nAntall forskjellige bokstaver: " + tekstanalyse.getAntallForskjellige());
        System.out.println("Det er totalt " + tekstanalyse.getTotAntall() + " bokstaver i teksten.");
        System.out.println(tekstanalyse.getProsentIkkeBokstav() + "% av teksten er andre tegn enn bokstaver.");
        System.out.println("Det finnes " + tekstanalyse.getAntallAvEnBokstav(bokstav) + " " + bokstav + "-er i teksten.");
        System.out.println(tekstanalyse.getVanligsteBokstav());
    }
}
