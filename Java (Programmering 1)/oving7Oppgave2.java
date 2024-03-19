public class oving7Oppgave2 {

    public static void main(String[] args) {
        
        Tekstbehandling tekst = new Tekstbehandling("Jeg bor i Trondheim, og er 19 år.");

        System.out.println("Antall ord: " + tekst.ordITeksten());
        System.out.println("Gjennomsnittlig ordlengde: " + tekst.gjennomsnittligOrdlengde());
        System.out.println("Gjennomsnitlig antall ord per periode: " + tekst.gjennomsnittligAntallOrdPerPeriode());
        System.out.println("Skifte ut ord: " + tekst.skifteUtOrd("19", "18"));
        System.out.println("Teksten: " + tekst.getTekst());
        System.out.println("Teksten i store bokstaver: " + tekst.storeBokstaver());
    }
}
