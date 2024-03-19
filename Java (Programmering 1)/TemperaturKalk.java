import java.util.Scanner;

class TemperaturKalk {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Tast (1) for fahrenheit til celsius");
        System.out.println("Tast (2) for celsius til fahrenheit");
        int FahrenheitOrCelsius = sc.nextInt();

        if (FahrenheitOrCelsius == 1) {
            System.out.print("Fahrenheit = ");
            int fahrenheit = sc.nextInt();

            int celsiusKonvertert = (5 * (fahrenheit - 32)) / 9;

            System.out.println(fahrenheit + " fahrenheit = " + celsiusKonvertert + " celsius");
        }

        else {
            System.out.print("Celsius = ");
            int celsius = sc.nextInt();

            int fahrenheitKonvertert = (celsius * 9)/5 + 32;

            System.out.println(celsius + " celsius = " + fahrenheitKonvertert + " fahrenheit");
        
        }
        sc.close();
    }
}
