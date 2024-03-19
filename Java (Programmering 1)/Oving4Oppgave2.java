/*

import java.util.Random;

class Spiller{

    private String navn;
    private int sumPoeng;

    Spiller (String navn, int sumPoeng){
        this.navn = navn;
        this.sumPoeng = sumPoeng;
    }

    public String getNavn() {
        return this.navn;
    }
    
    public int getSumPoeng1() {
        return this.sumPoeng;
    }

    //metode for å få sum poeng
    public String getSumPoeng(String spiller, int poeng){
        return ("Spiller " + spiller + " har: "  + poeng + " poeng.");
    }

    //metode for å få random tall mellom 1 og 6
    public int kastTerningen(){
        Random rn = new Random();
        int n = rn.nextInt(6) + 1;
        return n;
    }

    //metode som viser hvem som har vunnet
    public boolean erFerdig(){
        return sumPoeng >= 100;
    }
}



public class Oving4Oppgave2 {
    public static void main(String[] args) {

        //objekter for spiller A og B
        Spiller A = new Spiller("A", 0);
        Spiller B = new Spiller("B", 0);

        int starterPoengSum;
        int ikkeStarterPoengSum;
        String starterNavn;
        String ikkeStarterNavn;
        
        // Random om spiller A eller B starter
        Random rn = new Random();
        int hvemStarter = rn.nextInt(2);

        if (hvemStarter == 0){
            starterPoengSum = A.getSumPoeng1();
            starterNavn = A.getNavn();

            ikkeStarterPoengSum = B.getSumPoeng1();
            ikkeStarterNavn = B.getNavn();  
        }
        else{
            starterPoengSum = B.getSumPoeng1();
            starterNavn = B.getNavn();

            ikkeStarterPoengSum = A.getSumPoeng1();
            ikkeStarterNavn = A.getNavn();
        }

        int rundeNummer = 1;

        //while loop går helt til en spiller har over 100 poeng
        while (starterPoengSum < 100 && ikkeStarterPoengSum < 100){

            // Den som starter kaster terning
            int poengKastStarter = A.kastTerningen();
            starterPoengSum += poengKastStarter;

            // hvis den som starter kaster 1, blir poengsumen satt til 0
            if (poengKastStarter == 1) starterPoengSum = 0;

            // hvi poengsummen til starter er under 100 kaster den som ikke starter terningen
            if (starterPoengSum < 100){
                int poengKastIkkeStarter = spill.kastTerningen();
                ikkeStarterPoengSum += poengKastIkkeStarter;
                // hvis den som ikke starter kaster 1 blir poengsummen = 0
                if (poengKastIkkeStarter == 1) ikkeStarterPoengSum = 0;
                }
            // skriver ut hvilken runde det er og stillingen
            System.out.println("\n Runde: " + rundeNummer);
            String a = A.getSumPoeng(starterNavn, starterPoengSum);
            String b = B.getSumPoeng(ikkeStarterNavn, ikkeStarterPoengSum);
            System.out.println(a);
            System.out.println(b);
            rundeNummer++;
        }
        // hvem som vant
        String a = .erFerdig(starterPoengSum, ikkeStarterPoengSum, starterNavn, ikkeStarterNavn);
        System.out.println("\nSpiller " + a + " vant.");
    }
}
*/
 