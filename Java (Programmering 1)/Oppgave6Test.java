public class Oppgave6Test {
    
    public static void main(String[] args) {
        
        int[] antallTegn = new int[30];
        String alfabetet = "abcdefghijklmnopqrstuvwxyzæøå";
        String tekst = "Hei, Harry!!!";
        String tekstLowerCase = tekst.toLowerCase();

        for(int i = 0; i < tekstLowerCase.length(); i++){
            if (alfabetet.indexOf(tekstLowerCase.charAt(i)) >= 0){
                int j = alfabetet.indexOf(tekstLowerCase.charAt(i));
                antallTegn[j]++;
            } 
            else{
                antallTegn[29]++;
            }
        }

        for(int k = 0; k < 29; k++){
            System.out.println(alfabetet.charAt(k) + ": " + antallTegn[k]);
        }
        System.out.println("spesielle tegn: " + antallTegn[29]);
    }
}
