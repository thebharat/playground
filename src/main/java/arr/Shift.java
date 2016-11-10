package arr;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author bharat.thakarar on 10/11/16.
 */


//TODO - try iterative version as well
public class Shift {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        String input;
        int shiftPos;
        while(!(input = scanner.next()).equalsIgnoreCase("exit")){
            char[] inputArray = input.toCharArray();
            shiftPos = scanner.nextInt();
            getLiftShift(inputArray,0,inputArray.length-1,shiftPos);
            System.out.println(inputArray);
        }
    }

    private static void getLiftShift(char[] inputArray, int start, int end, int shiftCount) {
        int len = end - start + 1;
        if(start == end || len == shiftCount ) return;
        if(shiftCount <= len / 2) {
            swap(inputArray, start, start + shiftCount, shiftCount);
            getLiftShift(inputArray,start+shiftCount,end,shiftCount);
        }else{
            getRightShift(inputArray,start,end,len - shiftCount);
        }
    }

    private static void getRightShift(char[] inputArray, int start, int end, int shiftCount) {
        int len = end - start + 1;
        if(start == end || len == shiftCount) return;
        if(shiftCount <= len / 2) {
            swap(inputArray, end - shiftCount*2 +1, end - shiftCount+1, shiftCount);
            getRightShift(inputArray,start,end - shiftCount,shiftCount);
        }else{
            getLiftShift(inputArray,start,end,len - shiftCount);
        }
    }

    private static void swap(char[] inputArray, int start1, int start2, int len) {
        for(int i=0; i<len;i++){
            char temp = inputArray[start1+i];
            inputArray[start1+i] = inputArray[start2+i];
            inputArray[start2+i] = temp;
        }
    }
}
