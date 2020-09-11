import java.io.*;
import java.util.*;

public class Bundesliga02 {
    public void openFile(){
        try{
            File table = new File("table/bundesliga1314.txt"); //check the path name and gives the way to the file
            Scanner input = new Scanner (table); //this object allow to read the file

            //String [] teamList = new String[n+1];

            while (input.hasNextLine()) {

                String line = input.nextLine();
                String teamName = line.substring(0,25);
                System.out.println(teamName);
                System.out.println(line.length());
            }
        }

        catch (Exception e){
            System.out.println(" data does not exist");
        }
    }

    public static void main (String[] args){
        Bundesliga02 results = new Bundesliga02();
        results.openFile();
    }


}
