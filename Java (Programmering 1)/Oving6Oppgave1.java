import java.util.Random;

public class Oving6Oppgave1 {
    
    static Random rn = new Random();
    public static void main(String[] args) {
        
        int[] array = new int[10];

        for(int i = 0; i < 1000; i++){
            int j = rn.nextInt(10);
            array[j]++;
        }
        for(int k = 0; k < array.length; k++){
            System.out.println("Du fikk " + array[k] + " " + k + "-ere.");
        }
    }
}









    /*
    public static void main(String[] args) {
        int[] tab1 = {1, 4, 6, -2};
        int[] tab2 = {7, 14, -6, 0};

        for(int i = 0; i < tab1.length; i++){
            tab2[i] = tab1[tab1.length -i -1];
            System.out.println(tab2[i]);
        }
    }   
}
*/
    /*
    public static void main(String[] args) {
        int[] tab = {3, 8, -5, 5, 6, 0, 3, -2, 8, 9};

        tab[2] = tab[6]+ 5;
        int a = tab[8];
        tab[7] = a + tab[0] * tab[0];
        tab[4] = tab[4] + 1;
        tab[5] = tab[3] + tab[9];
        tab[3] = tab[2 * tab[0]];

        for(int i = 0; i < tab.length; i++){
            System.out.print(tab[i] + ", ");
        }

    }

}
*/
    /*
    public static void main(String[] args) {
        char[] karakter = {'A', 'N', 'N', 'E'};

        for(int i = karakter.length -1; i >= 0; i--){
            System.out.println(karakter[i]);
        }
    }
}
*/


    /*
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] dagerPerMåned = {31,28,31,30,31,30,31,31,30,31,30,31};
        
        System.out.print("Tast 1 om det er et skuddår");
        int valg = sc.nextInt();
        
        if(valg == 1){
            dagerPerMåned[1] = 29;
        }

        for(int i = 0; i < dagerPerMåned.length; i++){
            System.out.println(dagerPerMåned[i]);
        }
    }
}
*/
        
        /*
        int[] septemberNedbør = new int[30];
        int[] marsNedbør = new int[31];
        int[] uke39Nedbør = {10,20,30,40,0,5,30};

        for(int i = 0; i < uke39Nedbør.length; i++){
            System.out.println(uke39Nedbør[i]);
        }

        System.out.println("");
        System.out.println(uke39Nedbør[2]);
        uke39Nedbør[2] = 0;

        System.out.println(uke39Nedbør[2]);

        uke39Nedbør[1] = uke39Nedbør[6] * uke39Nedbør[5];
        System.out.println(uke39Nedbør[1]);

        System.out.println(septemberNedbør.length);

        System.out.println(uke39Nedbør[uke39Nedbør.length - 1]);

        
    }
}
*/