import java.util.*;
import java.io.*;
public class BundesligaTest {
    Scanner input;
    public static void main(String[] args){
        BundesligaTest nameTeam = new BundesligaTest();
        nameTeam.open();
        nameTeam.separateTeam();
        BundesligaTest results = new BundesligaTest();
        results.open();
        results.separateResults();
    }

    public void open(){
        try{
            File table = new File("table/Bundesliga1314.txt");
            input = new Scanner(table);
        }
        catch (Exception e){
            System.out.println("File not found");
        }
    }

    public void separateTeam(){
        String[] nameTeam = new String[0];
        while (input.hasNextLine()){
            String line = input.nextLine();
            line = line.substring(0,25);
            line = line.trim();
            nameTeam = addArray(nameTeam,line);
        }

        System.out.println(Arrays.toString (nameTeam));
    }

    public void separateResults(){
        while (input.hasNextLine()){
            String line = input.nextLine();
            line = line.substring(25, 96);

            //System.out.println(line);

        }
    }

    public String[] addArray(String[] oldArray, String newString){
        String [] newArray = new String[oldArray.length + 1];
        for (int i = 0; i < oldArray.length; i++){
            newArray[i] = oldArray[i];
        }
        newArray[oldArray.length] = newString;
        return newArray;
    }
}
