
class Tekstbehandling{

    private String teksten;

    Tekstbehandling(String tekst){
        this.teksten = tekst;
    }

    public int ordITeksten(){
        String tekst = this.teksten;
        String ord[] = tekst.split(" ");
        int antallOrd = ord.length;
        return antallOrd;
    }

    public double gjennomsnittligOrdlengde(){
        String tekst = this.teksten;
        String nyTekst = tekst.replace(",", "");
        nyTekst = nyTekst.replace(".", "");
        nyTekst = nyTekst.replace("!", "");
        nyTekst = nyTekst.replace("?", "");
        
        String nyTekstUtenMellomrom = nyTekst.replace(" ", "");

        String ord[] = nyTekst.split(" ");

        double antallBokstaver = nyTekstUtenMellomrom.length();
        double antallOrd = ord.length;

        double gjennomsnittligOrdlengde = antallBokstaver / antallOrd;

        return gjennomsnittligOrdlengde;
    }

    public double gjennomsnittligAntallOrdPerPeriode(){
        String tekst = this.teksten;
        String[] perioder = tekst.split("[,?.!]");
        String ord[] = tekst.split(" ");

        double antallOrd = ord.length;
        double antallPerioder = perioder.length;
      
        double gjennomsnittligAntallOrdPerPeriode = antallOrd / antallPerioder;
        
        return gjennomsnittligAntallOrdPerPeriode;
    }

    public String skifteUtOrd(String fraOrd, String tilOrd){
        String tekst = this.teksten;
        String nyTekst = tekst.replace(fraOrd, tilOrd);

        return nyTekst;
    }

    public String getTekst(){
        return this.teksten;
    }

    public String storeBokstaver(){
        String tekst = this.teksten;
        String storeBokstaver = tekst.toUpperCase();

        return storeBokstaver;
    }
}

