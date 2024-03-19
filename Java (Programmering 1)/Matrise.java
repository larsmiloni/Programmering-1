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
            for( int j = 0; j < kolonner; j ++){
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

            for(int i = 0; i < bKolonner; i++){
                for(int j = 0; j < aRader; j++){
                    for(int k = 0; k < aKolonner; k++){
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
