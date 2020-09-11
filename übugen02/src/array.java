// it is not possible to add value direct to an array.
// in java arrays have fixed size
// the solution is to create a new array which contains the new values

// Therefore it is necessary to create a method containing (length of old array, old array and new value)
// following steps are necessary: 1 - create new array (length of new array = length of old array +1)
// 2 - populate the new array -> loop to copy values of old arra
//
//
// y
// This method should return the new array.
import java.io.*;
import java.lang.*;
import java.util.*;
public class array {
    public static int[] addValue(int lengthOldArray, int[] oldArray, int newValue){
        int[] newArray = new int[ lengthOldArray + 1];
        for (int i = 0; i < lengthOldArray; i++){
            newArray[i] = oldArray[i];
        }
        newArray[lengthOldArray] = newValue;
        return newArray;
    }

    public static String[] addValueOld(String[] oldArray, String value ){
        int lengthOld = oldArray.length;
        String[] newArray = new String[lengthOld + 1];
        for (int i = 0; i < lengthOld; i++){
            newArray[i] = oldArray[i];
        }
        newArray[lengthOld] = value;
        return newArray;
    }

    public static void main(String[] args){

        int[] array = {};
        int newValue= 50;
        int lengthOld = 0;


        int [] test = {1,2,3,4,5};


        for (int i = 0; i < test.length; i++){
            int number = test[i];
            System.out.println(number);
        }

        String [] test2 = {"a", "b", "c"};

        String [] oldarray = {};
        for (int i = 0; i < test2.length; i++){
            String letter = test2[i];
            oldarray = addValueOld(oldarray,letter);

        }
        System.out.println(Arrays.toString (oldarray));

        int [] newarray = addValue(lengthOld, array, newValue);
        System.out.println(Arrays.toString (newarray) );
        lengthOld = 1;

        int [] newarray2 = addValue(lengthOld, newarray, newValue);
        System.out.println(Arrays.toString (newarray2) );




    }














//    public static int[] addNum (int n, int [] arr, int x){
//        int [] newArray = new int[n+1]; // value in brackets is the size of the array
//
//        for (int i = 0; i< n; i++){
//            newArray[i] = arr[i];
//        }
//            newArray[n] = x;
//            return newArray;
//
//    }
//

//    public static void main (String[] args){
//
//        int n = 10;
//        int arr[] = {1,2,3,4,5,6,7,8,9,10};
//        //int arr[] = {};
//        System.out.println ("Initial Array:\n" + Arrays.toString(arr)); // print array
//        int x = 50;
//        arr = addNum(n, arr, x);
//        System.out.println("new array + element:\n" + Arrays.toString(arr));
//
//
////        //print array
//        int [] myList = new int[]{1, 2, 3,};
//        for (int i = 0; i < myList.length; i++){
//            System.out.println (myList[i] + " ");
//        }


    //}
}
