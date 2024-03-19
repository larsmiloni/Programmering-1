import java.util.*;

/**
 * Klasse for student
 */
public class Student {

    private final String navn;
    private int antOppg;

    /**
     * Konstruktøren til klassen student.
     * @param navn navn på student
     * @param antOppg antall oppgaver studenten har gjort
     */
    public Student(String navn, int antOppg) {
        this.navn = navn;
        this.antOppg = antOppg;
    }

    /**
     * metode for å hente navn på student
     * @return navn på student
     */
    public String getNavn() {
        return this.navn;
    }

    /**
     * metode for å hente antall oppgaver studenten har gjort
     * @return antall oppgaver studenten har gjort
     */
    public int getAntOppg() {
        return this.antOppg;
    }

    /**
     * Metode for å øke antall oppgaver en student har gjort.
     * @param okning øker antall oppgaver med det man setter inn i parameteret.
     */
    public void okAntOppg(int okning) {
        this.antOppg = this.antOppg + okning;
    }

    /**
     * Gjør om informasjonen for et objekt til string.
     * @return navn og antalloppgaver til objektet. (navn, antOppg)
     */
    public String toString() {
        return this.navn + ", " + Double.toString(this.antOppg);
    }

}