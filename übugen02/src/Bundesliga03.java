import java.io.*;
import java.util.*;
public class Bundesliga03 {
    Scanner input;

    public static void main(String[] args) {
        Bundesliga03 results = new Bundesliga03();
        results.openFile();
        //results.readFile(); what happens when I call this function and the next?
        results.colTeam();
    }

    public void openFile() {
        try {
            File table = new File("table/Bundesliga1314.txt");
            input = new Scanner(table);
            System.out.println("File opened");
        } catch (Exception e) {
            System.out.println("data not found");
        }
    }

    public void readFile() {
        while (input.hasNextLine()) {
            System.out.println(input.nextLine());
        }
    }

    public void colTeam(){
        String [] listTeam = {};
        while (input.hasNextLine()){
            String line = input.nextLine();
            String nameTeam = line.substring(0,25);
            nameTeam = nameTeam.trim();
            listTeam = addValueOld(listTeam, nameTeam);
            //System.out.println(nameTeam);
        }
        System.out.println(Arrays.toString(listTeam));
    }
    // addValue to old array
    public String[] addValueOld(int lengthOld, String[] oldArray, String value ){
        String[] newArray = new String[lengthOld + 1];
        for (int i = 0; i < lengthOld; i++){
            newArray[i] = oldArray[i];
        }
        newArray[lengthOld] = value;
        return newArray;
    }
    // addValue to old array without length
    public String[] addValueOld(String[] oldArray, String value ){
        int lengthOld = oldArray.length;
        String[] newArray = new String[lengthOld + 1];
        for (int i = 0; i < lengthOld; i++){
            newArray[i] = oldArray[i];
        }
        newArray[lengthOld] = value;
        return newArray;
    }




}


