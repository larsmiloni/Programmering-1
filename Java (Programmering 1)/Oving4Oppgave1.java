import java.util.Scanner;

class Valuta{


	private double valutaKurs;
	private String valutaNavn;

	Valuta(double valutaKurs, String valutaNavn){
		this.valutaKurs = valutaKurs;
		this.valutaNavn = valutaNavn;
	}

	public double getValutaKrus(){
		return this.valutaKurs;
	}
	public String getValutaNavn(){
		return this.valutaNavn;
	}

	// Metode for å regne til NOK
	public double tilNok(int antallValgtValuta){
		return antallValgtValuta * valutaKurs;
	
	}
	// Metode for å regne fra NOK
	public double fraNok(int antallNok){
		return antallNok / valutaKurs;
	}
}

class Oving4Oppgave1{
	public static void main(String[] args) {

		//Objekter for EUR, USD og SEK
		Valuta euro = new Valuta(10.02, "EUR");
		Valuta amerikanske_dollar = new Valuta(10.03, "USD");
		Valuta svenske_kroner = new Valuta(0.94, "SEK");
	
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Vil du regne til eller fra NOK?\nTil = 1\nFra = 2\navslutt = 3\n: ");
		int tilEllerFraValg = sc.nextInt();

		// Regne til NOK
		if (tilEllerFraValg == 1){

			System.out.print("\nHvilken valuta vil du regne til NOK?\nUSD = 1\nEUR = 2\nSEK = 3\navslutt = 4\n: ");
			int valutaValg = sc.nextInt();

			if (valutaValg == 1){
				System.out.print("\nHvor mange USD vil du regne om til NOK: ");
				int antallValgtValuta = sc.nextInt();
				double a = amerikanske_dollar.tilNok(antallValgtValuta);
				System.out.println(antallValgtValuta + " USD  = " + a + " NOK");
			}

			else if (valutaValg == 2){
				System.out.print("\nHvor mange EUR vil du regne om til NOK: ");
				int antallValgtValuta = sc.nextInt();
				double a = euro.tilNok(antallValgtValuta);
				System.out.println(antallValgtValuta + " EUR  = " + a + " NOK");
			}

			else if (valutaValg == 3){
				System.out.print("\nHvor mange SEK vil du regne om til NOK: ");
				int antallValgtValuta = sc.nextInt();
				double a = svenske_kroner.tilNok(antallValgtValuta);
				System.out.println(antallValgtValuta + " SEK  = " + a + " NOK");
			}

			else{
				sc.close();
			}
		}

		//Regne fra NOK
		else if (tilEllerFraValg == 2){

			System.out.print("\nHvilken valuta vil du regne fra NOK?\nUSD = 1\nEUR = 2\nSEK = 3\navslutt = 4\n: ");
			int valutaValg = sc.nextInt();

			if (valutaValg == 1){
				System.out.print("\nHvor mange NOK vil du regne om til USD: ");
				int antallNok = sc.nextInt();
				double a = amerikanske_dollar.fraNok(antallNok);
				System.out.println(antallNok + " NOK  = " + a + " USD");
			}

			else if (valutaValg == 2){
				System.out.print("\nHvor mange NOK vil du regne om til EUR: ");
				int antallNok = sc.nextInt();
				double a = euro.fraNok(antallNok);
				System.out.println(antallNok + " NOK  = " + a + " EUR");
			}

			else if (valutaValg == 3){
				System.out.print("\nHvor mange NOK vil du regne om til SEK: ");
				int antallNok = sc.nextInt();
				double a = svenske_kroner.fraNok(antallNok);
				System.out.println(antallNok + " NOK  = " + a + " SEK");
			}

			else{
				sc.close();
			}
		}

		else{
			sc.close();
		}
	}
}