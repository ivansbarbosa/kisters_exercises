import java.io.*;
import java.util.*;

public class Bundesliga {

    public void openFile(){
        try{
            File file =new File ("table\\bundesliga1314.txt");

            Scanner input = new Scanner (file);



            while (input.hasNextLine()){
                String team = input.nextLine();
                for (String nameTeam:team.split(" ",2)){
                    System.out.println(nameTeam);
                }

                //System.out.println(team);
                //System.out.println(input.nextLine());

            }
        }
        catch (Exception e) {
            System.out.println("could not find file");
            e.printStackTrace();
        }
    }


    public static void main (String [] args){
        Bundesliga test = new Bundesliga(); // once you use static, you need to declare your variable and afterwards you can call a function.
        test.openFile();
    }

}



