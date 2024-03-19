class Brøk{

    public double nevner, teller;
    public static double svar;

    // Konstruktør for nevner != 1
    Brøk(double teller, double nevner) throws IllegalArgumentException{
        // Hvis nevner = 0
        if (nevner == 0){
            throw new IllegalArgumentException("Nevneren kan ikke være 0");
        }
        // Hvis nevner != 0
        else{
            this.nevner = nevner;
            this.teller = teller;
        }
    }
    // Konstruktør for nevner = 1.
    Brøk(double teller){
        nevner = 1;
        this.teller = teller;
    }

    // Summerer brøk a og b
    public static void summere(Brøk a, Brøk b){
        svar = (a.teller / a.nevner) + (b.teller / b.nevner);
    }

    // Subtraherer brøk a og b
    public static void  subtrahere(Brøk a, Brøk b){
        svar = (a.teller / a.nevner) - (b.teller / b.nevner);
    }

    // Multipliserer brøk a og b
    public static void multiplisere(Brøk a, Brøk b){
        svar = (a.teller / a.nevner) * (b.teller / b.nevner);
    }

    // Dividerer brøk a og b
    public static void dividere(Brøk a, Brøk b){
        svar = (a.teller / a.nevner) / (b.teller / b.nevner);
    }

    // Returner svar fra de andre metodene
    public static double getSvar() {
        return svar;
    }
}
