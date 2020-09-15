import java.util.*;
import java.io.*;
public class BundesligaTest02 {
    Scanner input;
    String [] nameList;
    ArrayList<List<String>> score;


    public static void main (String[] args){
        BundesligaTest02 results = new BundesligaTest02();
        results.nameList();
        results.score();
        results.getResult("FC Bayern München");

    }


    BundesligaTest02(){
        try{
            File table = new File("table/bundesliga1314.txt");
            input = new Scanner (table);
        }
        catch (Exception e){
            System.out.println("File not found");
        }
    }

    public String[] addArray (String [] oldArray, String newValue){
        String [] addArray = new String [oldArray.length + 1];
        for(int i = 0; i<oldArray.length; i++){
            addArray[i] = oldArray[i];
        }
        addArray[oldArray.length] = newValue;
        return addArray;
    }
    public void nameList(){
        nameList = new String[0];
        while(input.hasNextLine()){
            String line = input.nextLine();
            String nameTeam = line.substring(0,25);
            nameTeam = nameTeam.trim();
            nameList = addArray(nameList, nameTeam);
        }
        System.out.println(Arrays.toString(nameList));
    }
    public void score(){
        score = new ArrayList<List<String>>();// why does not work with ArrayList<ArrayList<String>>?
        while (input.hasNextLine()){
            String line = input.nextLine();
            String scoreLine = line.substring(25,96);
            String[] scoreSeparated = scoreLine.split(" ");
            List<String>scoreList = Arrays.asList(scoreSeparated);
            score.add(scoreList);
        }
        //System.out.println((score)); // every value in an array
    }
    public void scannerTest(){
//        Scanner input = new Scanner(System.in);
//        System.out.println("Enter name Team 01");
//        String team01 = input.nextLine();
//        System.out.println("Enter name Team 02");
//        String team02 = input.nextLine();

        //team01 = "FC Bayern München";
        //team02 = "Borussia Dortmund";

    }
    public void getResult(String team01){  //String team01, String team02
        int test;
        //int posTeam02;
        for (int i = 0; i < nameList.length; i++){
        //System.out.println(nameList[i]);
            if (team01.equals(nameList[i])){
                test = i;
                System.out.println(test);
            }
        }

    }


}
