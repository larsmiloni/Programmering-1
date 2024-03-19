import java.util.Scanner;

public class oving6Oppgave3 {

    private static Scanner sc = new Scanner(System.in);
    private static Matrise[] matrise = new Matrise[2]; 
    public static void main(String[] args) {
        start();
        meny();
    }

    public static void start(){
        matrise[0] = Matrise.fyllMatrise(lagMatrise());
        System.out.println("Matrise nr. 1:");
        skrivUtMatrise(matrise[0]);
    }

    public static void meny(){
        System.out.println("Tast 1 for å addere denne matrisen med en annen.");
        System.out.println("Tast 2 for å multiplisere denne matrisen med en annen.");
        System.out.println("Tast 3 for å transponere denne matrisen.");

        int menyValg = sc.nextInt();

        switch(menyValg){
            case 1: // addere
                    matrise[1] = Matrise.fyllMatrise(lagMatrise(matrise[0].getAntallRader(), matrise[0].getAntallKolonner()));
                    System.out.println("Matrise nr. 2:");
                    skrivUtMatrise(matrise[1]);
                    Matrise a = Matrise.addereMatrise(matrise[0], matrise[1]);
                    System.out.println("Resultat:");
                    skrivUtMatrise(a);
                    
                    break;

            case 2: // multiplisere
                    System.out.println("Lag matrise nr. 2 (antall rader må være lik " + matrise[0].getAntallKolonner());
                    matrise[1] = Matrise.fyllMatrise(lagMatrise());
                    System.out.println("Matrise nr. 2:");
                    skrivUtMatrise(matrise[1]);
                    Matrise b = Matrise.multipliserMatrise(matrise[0], matrise[1]);
                    if (b != null){
                        System.out.println("Resultat:");
                        skrivUtMatrise(b);
                    }
                    else{
                        System.out.println("Noe gikk galt");
                    }
                    break;
                    
            case 3: // transponere
                    Matrise c = Matrise.transponeMatrise(matrise[0]);
                    System.out.println("Resultat:");
                    skrivUtMatrise(c);
                    break;
            default:System.out.println("Du må taste inn et tall mellom 1 og 3.");
                    meny();
        }
    }

    public static double[][] lagMatrise(){
        System.out.print("Antall rader: ");
        int rader = sc.nextInt();
        System.out.print("Antall kolonner: ");
        int kolonner = sc.nextInt();
        double[][] m = new double[rader][kolonner];

        for(int i = 0; i < rader; i++){
            for(int j = 0; j < kolonner; j++){
                System.out.print("[" + i + "][" + j + "]: ");
                m[i][j] = sc.nextDouble();
            }
        }
        return m;
    }

    public static double[][] lagMatrise(int rader, int kolonner){
        double[][] m = new double[rader][kolonner];

        System.out.println("Fyll inn matrisen: ");
        for(int i = 0; i < rader; i++){
            for(int j = 0; j < kolonner; j++){
                System.out.println("[" + i + "][" + j + "]: ");
                m[i][j] = sc.nextDouble();
            }
        }
        return m;
    }
    public static void skrivUtMatrise(Matrise m){
        int rader = m.getAntallRader();
        int kolonner = m.getAntallKolonner();
        double[][] t = m.getMatrise();

        for(int i = 0; i < rader; i++){
            String enRad = "";
            for(int j = 0; j < kolonner; j++){
                enRad += t[i][j] + " ";
            }
            System.out.println(enRad);
        }
    }
}