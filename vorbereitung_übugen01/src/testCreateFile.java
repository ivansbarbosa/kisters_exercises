import java.util.*;

public class testCreateFile {
    public static void main (String[] args){
        Formatter x;
        try {
            x = new Formatter("ivan.txt");
        }
        catch (Exception e){
            System.out.println("File was not created");
        }
    }
}
