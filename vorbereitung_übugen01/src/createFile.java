// create file
import java.util.*;
import java.lang.*;
import java.util.*;

public class createFile{
    private Formatter x;

    public void openFile(){
        try{
            x = new Formatter("chinese.txt");
        }
        catch (Exception e){
            System.out.println ("you have an error");
        }
    }

    public void addRecords(){
        x.format("%s%s%s", "1982 ", "ivan ", "barbosa");
        x.format("%s,%s,%s", "2010 ", "thiago ", "Silva" );
        x.format("%s,%s,%s", "2011", "lucio", "barbosa");
    }

    public void closeFile(){
        x.close();
    }

}
