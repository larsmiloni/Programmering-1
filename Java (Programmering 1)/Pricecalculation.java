import java.util.Scanner;


class Matvare {

    String navn;
    double pris;
    int antall;

     Matvare (String navn, double pris, int antall){

        this.navn = navn;
        this.pris = pris;
        this.antall = antall;
    }
    

    public static double totPris(double pris, int antall){

        return (pris * antall);
        
    }
}


public class Pricecalculation {
    
    public static void main(String[] args) {
        

        Matvare[] arr = new Matvare[4];

        arr[0] = new Matvare("pølser", 40, 0);
        arr[1] = new Matvare("epler", 5, 0);
        arr[2] = new Matvare("brød", 20, 0);
        arr[3] = new Matvare("egg", 30, 0);


        Scanner sc = new Scanner(System.in);
        
        int totalPris = 0;

        for (int i = 0; i < 4; i++){
            System.out.print("\nHvor mange " + arr[i].navn + " vil du kjøpe: ");
            arr[i].antall = sc.nextInt();

           // totalPris += arr[i].totPris(arr[i].pris, arr[i].antall);
        }
        System.out.println("Total pris er: " + totalPris);
        sc.close();
    }
}

