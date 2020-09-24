public class Gesamtstand {
    String nameTeam;
    int punkte;
    int tore ;
    int gegentore;

    Gesamtstand(String nameTeam, int punkte, int tore, int gegentore){
        this.nameTeam = nameTeam;
        this.punkte = punkte;
        this.tore = tore;
        this.gegentore = gegentore;
    }

    @Override
    public String toString(){
        return ("Vereinsname: " + nameTeam + "\nTore: " + tore + "\nGegentore: " + gegentore + "\nPunkte: " + punkte);
    }
    public static String bla(){
        return "bla";
    }
}
