import java.util.*;
import java.io.*;

public class Bundesliga11 {
    static List<String> teamList = new ArrayList<>(); // list of team names
    Integer [] [] [] scores = new Integer [18][18][2]; // array containing all scores
    Integer [][] gesamtstand = new Integer [18][3]; // tabel containing total of goals done, total of goals suffered and total punkte

    Bundesliga11(){
        try{
            File table = new File("table/bundesliga1314.txt");
            Scanner input = new Scanner(table);
            while (input.hasNextLine()) {
                convertLine(input.nextLine());
            }
        }catch(Exception e) {
            System.out.println("file not found");
        }
    }

    private void convertLine(String line){
        String nameTeam = line.substring(0,25);
        nameTeam = nameTeam.trim();
        teamList.add(nameTeam);

        String lineScore = line.substring(25,96);
        convertResults(lineScore, teamList.size()-1);
    }

    private void convertResults(String lineScore, int teamIndex){
        String [] splitScore = lineScore.split(" ");

        for (int gameIndex = 0; gameIndex < splitScore.length; gameIndex++) {

            String [] goals = splitScore[gameIndex].split(":");

            if (goals.length == 2){ // filter the values containing only 2 values (Exclude ---). Feed the array scores.
                scores [teamIndex][gameIndex][0] = Integer.valueOf(goals[0]); // home goals
                scores [teamIndex][gameIndex][1] = Integer.valueOf(goals[1]); // guest goals
            }
        }
    }

    public int  checkNamePosition (String teamName){ // check if the team name is valid and return the index(position) in the table.
        boolean found = false;
        int indexHeim = -1; // Why it is necessary to inicialize.
        try{
            for (int indexTeam = 0; indexTeam < teamList.size(); indexTeam++){
                if (teamList.get(indexTeam).equals(teamName)){
                    found = true;
                    indexHeim = indexTeam;
                }
            }
            if(!found){
                throw new IllegalArgumentException("team not found");
            }
        }
        catch(IllegalArgumentException e){
            e.printStackTrace();
        }
        return indexHeim;
    }

    public String getResultat (String heim, String gast){ //return the result of one game
        int positionHeim = checkNamePosition(heim);
        int positiongast = checkNamePosition(gast);
        int scoreHeim = scores[positionHeim] [positiongast] [0];
        int scoregast = scores[positionHeim] [positiongast] [1];
        return (String.valueOf(scoreHeim) + ":" + String.valueOf(scoregast));
    }

    public void sumGoalsPunkt(){
        for (int i = 0; i < scores.length; i++){ // loop through the complete line. Delivery each line to the next loop. it reads the lines for each team. "Read the team names".
            int sumTore = 0, sumGegen = 0, punkte = 0;
            for (int j = 0; j < scores.length; j++){ // loop through the columns of each line. "Read the game results".

                if (i != j){
                    // the parameters toreHeim and gegentoreHeim are retrieved from the line
                    int toreHeim = scores[i][j][0]
                    int gegentoreHeim = scores[i][j][1];
                    // the parameters toreAus and gegentoreAus are retrieved form the column
                    int toreAus = scores[j][i][1];
                    int gegentoreAus = scores[j][i][0];
                    sumTore += toreHeim + toreAus;
                    sumGegen += gegentoreHeim + gegentoreAus;
                    punkte = getPunkte(punkte, toreHeim, gegentoreHeim, toreAus, gegentoreAus);
                }
                gesamtstand[i][0] = sumTore;
                gesamtstand[i][1] = sumGegen;
                gesamtstand[i][2] = punkte;
            }
        }
    }
    // calculate points based on the result of two games (one at home) one outside home.
    private int getPunkte(int punkte, int toreHeim, int gegentoreHeim, int toreAus, int gegentoreAus) {
        if(toreHeim > gegentoreHeim){
            punkte +=3;
        }else if(toreHeim == gegentoreHeim){
            punkte +=1;
        }
        if(toreAus > gegentoreAus){
            punkte +=3;
        }else if(toreAus == gegentoreAus){
            punkte +=1;
        }
        return punkte;
    }

    public Gesamtstand getGesamtstand(String mannschaft) { // feed a table gesamtstand with the
        boolean found = false;
        int teamPosition = 0;
        int tore;
        int gegentore;
        int punkte;
        teamPosition = checkNamePosition(mannschaft);
        tore = gesamtstand[teamPosition] [0];
        gegentore = gesamtstand[teamPosition] [1];
        punkte = gesamtstand[teamPosition][2];
        return (new Gesamtstand(mannschaft,punkte,tore,gegentore));

    }

    public static void main(String[] args){
        Bundesliga11 bLiga = new Bundesliga11();
        bLiga.sumGoalsPunkt();
        System.out.println(bLiga.teamList);
        System.out.println(bLiga.getResultat("Borussia Dortmund", "FC Schalke 04"));
        System.out.println(bLiga.getGesamtstand("FC Bayern München"));
    }
}