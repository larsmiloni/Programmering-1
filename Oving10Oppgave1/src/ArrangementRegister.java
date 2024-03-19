import java.util.*;
/**
 * Klasse for Arrangement register
 */
public class ArrangementRegister {
    public ArrayList<Arrangement> arrangementer;

    /**
     * Konstruktør for klasser ArrangementRegister
     * lager en ny ArrayList arrangementer som kan inneholde Arrangement.
     */
    public ArrangementRegister(){
        arrangementer = new ArrayList<Arrangement>();
    }

    /**
     * Metode for å registrere et nytt arrangement
     * @param navn på arrangement
     * @param sted for arrangement
     * @param arrangør til arrangement
     * @param type arrangement
     * @param tidspunkt til arrangement
     * @return arrangement
     */
    public Arrangement nyttArrangement(String navn, String sted, String arrangør, String type, double tidspunkt){
        int entydigNr = arrangementer.size();
        Arrangement arrangement = new Arrangement(entydigNr, navn, sted, arrangør, type, tidspunkt);
        return arrangement;
    }

    /**
     * Lager en ny ArrayList stedArr for arrangementer som er på et gitt sted.
     * sjekker alle arrangementer om de er på det gitte stedet, hvis de er det blir de lagt til i stedArr.
     * @param sted for arrangement
     * @return stedArr
     */
    public ArrayList<Arrangement> listeArrPåSted(String sted){
        ArrayList<Arrangement> stedArr = new ArrayList<Arrangement>();
        for(int i = 0; i < arrangementer.size(); i++){
            if (arrangementer.get(i).getSted().equals(sted)){
                stedArr.add(arrangementer.get(i));
            }
        }
        return stedArr;
    }

    /**
     * Metode for å finne arrangementer på en gitt dato.
     * lager en ArrayList datoArr hvor man legger alle arrangementer som har samme dato som den gitte datoen.
     * @param dato for arrangement
     * @return datoArr
     */
    public ArrayList<Arrangement> listeArrPåDato(double dato){
        ArrayList<Arrangement> datoArr = new ArrayList<Arrangement>();
        for(int i = 0; i < arrangementer.size(); i++){
            int datoUtenTid = (int)Math.floor(arrangementer.get(i).getTidspunkt() / 10000);
            if(datoUtenTid == (int)dato){
                datoArr.add(arrangementer.get(i));
            }
        }
        return datoArr;
    }

    /**
     * Metode for å sjekke hvilke arrangementer som er innenfor et gitt tidsintervall
     * det lages en ArrayList arrTidsintervall so fylles med de arrangementene som er innenfor tidsintervallet.
     * så sortere alle arrangementene etter dato.
     * @param StartDato for arrangementene
     * @param SluttDato for arrangementene
     * @return arrTidsintervall
     */
    public ArrayList<Arrangement> listeArrInnenforTidsintervall(double StartDato, double SluttDato){
        ArrayList<Arrangement> arrTidsintervall = new ArrayList<Arrangement>();
        for (int i = 0; i < arrangementer.size(); i++){
            int datoUtenTid = (int)Math.floor(arrangementer.get(i).getTidspunkt() / 10000);
            if(datoUtenTid >= (int)StartDato && datoUtenTid <= (int)SluttDato){
                arrTidsintervall.add(arrangementer.get(i));
            }
        }
        Comparator<Arrangement> sortertEtterTid = Comparator.comparingInt((Arrangement a) -> (int) a.getTidspunkt());
        Collections.sort(arrTidsintervall, sortertEtterTid);
        return  arrTidsintervall;
    }
}
