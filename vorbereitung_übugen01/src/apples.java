public class apples {
    public static void main (String[] args){
        createFile test = new createFile();
        test.openFile();
        test.addRecords();
        test.closeFile();
    }
}
