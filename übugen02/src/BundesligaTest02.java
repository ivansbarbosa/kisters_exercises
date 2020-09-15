import java.util.*;
import java.io.*;
public class BundesligaTest02 {
    Scanner input;

    public static void main (String[] args){
        BundesligaTest02 results = new BundesligaTest02();
        //results.nameList();
        results.score();
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
        String [] nameList = new String[0];
        while(input.hasNextLine()){
            String line = input.nextLine();
            String nameTeam = line.substring(0,25);
            nameTeam = nameTeam.trim();
            nameList = addArray(nameList, nameTeam);
        }
        System.out.println(Arrays.toString(nameList));
    }

    public void score(){
        //String[] score = new String[0];
        ArrayList<List<String>> score = new ArrayList<List<String>>();// why does not work with ArrayList<ArrayList<String>>?
        while (input.hasNextLine()){
            String line = input.nextLine();
            String scoreLine = line.substring(25,96);
            String[] scoreSeparated = scoreLine.split(" ");
            List<String>scoreList = Arrays.asList(scoreSeparated);
            score.add(scoreList);
            System.out.println((score)); // every value in an array

            //score.add(String.valueOf(scoreSeparated));
            //System.out.println(score);
            // see arraylist
            //score = addArray(scoreSeparated,scoreLine);
        }
        //System.out.println(score);
        //System.out.println(Arrays.toString(score));
    }


}
