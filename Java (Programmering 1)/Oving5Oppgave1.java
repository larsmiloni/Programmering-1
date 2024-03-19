public class Oving5Oppgave1 {
    public static void main(String[] args) {

        Brøk a, b;

        //brøk a
        a = new Brøk(1,2);
        //brøk b
        b = new Brøk(3);

        //summere
        Brøk.summere(a, b);
        System.out.println("(" + a.teller + "/" + a.nevner + ") + (" + b.teller + "/" + b.nevner + ") = " + Brøk.getSvar());

        //subtrahere
        Brøk.subtrahere(a, b);
        System.out.println("(" + a.teller + "/" + a.nevner + ") - (" + b.teller + "/" + b.nevner + ") = " + Brøk.getSvar());

        //multiplisere
        Brøk.multiplisere(a, b);
        System.out.println("(" + a.teller + "/" + a.nevner + ") * (" + b.teller + "/" + b.nevner + ") = " + Brøk.getSvar());

        //dividere
        Brøk.dividere(a, b);
        System.out.println("(" + a.teller + "/" + a.nevner + ") / (" + b.teller + "/" + b.nevner + ") = " + Brøk.getSvar());

    }
}
