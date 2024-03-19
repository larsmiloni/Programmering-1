class Tekstanalyse{

    private static int[] antallTegn;
    private static String alfabetet = "abcdefghijklmnopqrstuvwxyzæøå";

    Tekstanalyse(String tekst){

        antallTegn = new int[30];        

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
    }
    public int getAntallForskjellige(){
        int resultat = 0;
        for(int i = 0; i < 29; i++){
            if(antallTegn[i] != 0){
                resultat++;
            }
        }
        return resultat;
    }

    public int getTotAntall(){
        int resultat = 0;
        for(int i = 0; i < 29; i++){
            resultat = resultat + antallTegn[i];
        }
        return resultat;
    }

    public double getProsentIkkeBokstav(){
        
        
        int antallBokstaver = getTotAntall();
        double antallIkkeBokstaver = antallTegn[29];

        double totaltAntallTegn = antallBokstaver + antallIkkeBokstaver;

        double resultat = (antallIkkeBokstaver / totaltAntallTegn) * 100;

        resultat = Math.round(resultat);

        return resultat;
    }

    public int getAntallAvEnBokstav(String bokstav){
        int resultat = antallTegn[alfabetet.indexOf(bokstav)];
        return resultat;
    }

    public String getVanligsteBokstav(){

        int høyestVerdi = 0;
        String høyesteBokstav = "";

        for(int i = 0; i < 29; i++){
            if (antallTegn[i] > høyestVerdi){
                høyestVerdi = antallTegn[i];
                høyesteBokstav = Character.toString(alfabetet.charAt(i));
            }
            //kanskje gøre om til to.string
            else if(antallTegn[i] == høyestVerdi){
                høyesteBokstav = høyesteBokstav + ", " + alfabetet.charAt(i);
            }
        }
        return "'" + høyesteBokstav + "' er den/de vanligste bokstaven(e).\n'" + høyesteBokstav + "' er brukt: " + høyestVerdi + " ganger (hver).";

    }

}