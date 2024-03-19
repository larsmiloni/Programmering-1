class NyString{

    private String tekst;
    
    NyString(String setning){
        this.tekst = setning;
    }
    
    /**
     * 
     * @return 
     */

    public String forkorting(){
        String nyTekst = "";
        String gammelTekst = this.tekst;
        String ord[] = gammelTekst.split(" ");
        for(int i = 0; i < ord.length; i++){
            nyTekst += ord[i].charAt(0);
        }
        return nyTekst;
    }

    public String FjerningAvTegn(String bokstav){
        String gammelTekst = this.tekst;
        String nyTekst = gammelTekst;

        while(nyTekst.indexOf(bokstav) > -1){
            nyTekst = nyTekst.substring(0, nyTekst.indexOf(bokstav)) + nyTekst.substring(nyTekst.indexOf(bokstav) + 1);
        }
        return nyTekst;     
    }
}