/*import java.util.Scanner;

class Matrise{
    
    private final double[][] matrise;

    private Matrise(double[][] n){
        matrise = n;
    }

    public Matrise fyllMatrise(double[][] n){
        return new Matrise(n);
    }

    public double[][] getMatrise(){
        return matrise;
    }

    public int getAntallRader(){
        int rader = matrise.length;
        return rader;
    }
    public int getAntallKolonner(){
        int kolonner = matrise[0].length;
        return kolonner;
    }


    public Matrise addereMatrise(Matrise a, Matrise b){
        int rader = a.getAntallRader();
        int kolonner = a.getAntallKolonner();
        double[][] n = new double[rader][kolonner];

        for(int i = 0; i < rader; i++){
            for( int j = 0; i < kolonner; i ++){
                n[i][j] = a.matrise[i][j] + b.matrise[i][j];
            }
        }
        return new Matrise(n);
    }

    public Matrise multipliserMatrise(Matrise a, Matrise b){
        int aRader = a.getAntallRader();
        int aKolonner = a.getAntallKolonner();
        int bRader = b.getAntallRader();
        int bKolonner = b.getAntallKolonner();

        if (aKolonner == bRader){
            double[][] n = new double[aRader][bKolonner];

            for(int i = 0; i < aKolonner; i++){
                for(int j = 0; j < bRader; j++){
                    for(int k = 0; k < aRader; k++){
                        n[j][i] = n[j][i] + a.getMatrise()[j][k] * b.getMatrise()[k][i];
                    }
                }
            }
            return new Matrise(n);
        }
        else{
            return null;
        }
    }

    public Matrise transponerMatrise(Matrise a){
        int rader = a.getAntallRader();
        int kolonner = a.getAntallKolonner();
        double[][] n = new double[rader][kolonner];

        for(int i = 0; i < rader; i++){
            for(int j = 0; j < kolonner; j++){
                n[i][j] = a.getMatrise()[j][i];
            }
        }
        return new Matrise(n);
    }
}



public class oving6Oppgave3 {

    private static Scanner sc = new Scanner(System.in);
    private static Matrise[] matrise = new Matrise[2]; 
    private static oving6Oppgave3 a = new oving6Oppgave3();
    public static void main(String[] args) {
        a.start();
    }

    public void start(){
        matrise[0].fyllMatrise(lagMatrise());
        System.out.println("Matrise nr. 1:");
        skrivUtMatrise(matrise[0]);
    }
    

    public void meny(){
        System.out.println("Tast 1 for å addere denne matrisen med en annen.");
        System.out.println("Tast 2 for å multiplisere denne matrisen med en annen.");
        System.out.println("Tast 3 for å transponere denne matrisen.");

        int menyValg = sc.nextInt();

        switch(menyValg){
            case 1: // addere
                    matrise[1] = matrise[1].fyllMatrise(lagMatrise(matrise[0].getAntallRader(), matrise[0].getAntallKolonner()));
                    System.out.println("Matrise nr. 2:");
                    skrivUtMatrise(matrise[1]);
                    Matrise a = matrise[1].addereMatrise(matrise[0], matrise[1]);
                    System.out.println("Resultat:");
                    skrivUtMatrise(a);
                    
                    break;

            case 2: // multiplisere
                    System.out.println("Lag matrise nr. 2 (antall rader må være lik " + matrise[0].getAntallKolonner());
                    matrise[1] = matrise[1].fyllMatrise(lagMatrise());
                    System.out.println("Matrise nr. 2:");
                    skrivUtMatrise(matrise[1]);
                    Matrise b = matrise[1].multipliserMatrise(matrise[0], matrise[1]);
                    if (b != null){
                        System.out.println("Resultat:");
                        skrivUtMatrise(b);
                    }
                    else{
                        System.out.println("Noe gikk galt");
                    }
                    break;
                    
            case 3: // transponere
                    Matrise c = matrise[0].transponerMatrise(matrise[0]);
                    System.out.println("Resultat:");
                    skrivUtMatrise(c);
                    break;
            default:System.out.println("Du må taste inn et tall mellom 1 og 3.");
                    meny();
        }
    }

    public double[][] lagMatrise(){
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

    public double[][] lagMatrise(int rader, int kolonner){
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
    public void skrivUtMatrise(Matrise m){
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
} */

/*import java.util.Scanner;

class Matrise{
    
    private final double[][] m;

    private Matrise(double[][] n){
        m = n;
    }

    public static Matrise fyllMatrise(double[][] n){
        return new Matrise(n);
    }

    public double[][] getMatrise(){
        return m;
    }

    public int getAntallRader(){
        int rader = m.length;
        return rader;
    }
    public int getAntallKolonner(){
        int kolonner = m[0].length;
        return kolonner;
    }


    public static Matrise addereMatrise(Matrise a, Matrise b){
        int rader = a.getAntallRader();
        int kolonner = a.getAntallKolonner();
        double[][] n = new double[rader][kolonner];

        for(int i = 0; i < rader; i++){
            for( int j = 0; i < kolonner; i ++){
                n[i][j] = a.m[i][j] + b.m[i][j];
            }
        }
        return new Matrise(n);
    }

    public static Matrise multipliserMatrise(Matrise a, Matrise b){
        int aRader = a.getAntallRader();
        int aKolonner = a.getAntallKolonner();
        int bRader = b.getAntallRader();
        int bKolonner = b.getAntallKolonner();

        if (aKolonner == bRader){
            double[][] n = new double[aRader][bKolonner];

            for(int i = 0; i < aKolonner; i++){
                for(int j = 0; j < bRader; j++){
                    for(int k = 0; k < aRader; k++){
                        n[j][i] = n[j][i] + a.getMatrise()[j][k] * b.getMatrise()[k][i];
                    }
                }
            }
            return new Matrise(n);
        }
        else{
            return null;
        }
    }

    public static Matrise transponeMatrise(Matrise a){
        int rader = a.getAntallRader();
        int kolonner = a.getAntallKolonner();
        double[][] n = new double[rader][kolonner];

        for(int i = 0; i < rader; i++){
            for(int j = 0; j < kolonner; j++){
                n[i][j] = a.getMatrise()[j][i];
            }
        }
        return new Matrise(n);
    }
}



public class oving6Oppgave3 {

    private static Scanner sc = new Scanner(System.in);
    private static Matrise[] matrise = new Matrise[2]; 
    public static void main(String[] args) {
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
                    Matrise c = matrise[0].transponeMatrise(a);
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
} */