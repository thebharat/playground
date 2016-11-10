package rec;

import java.util.HashSet;
import java.util.Set;

/**
 * @author bharat.thakarar on 07/11/16.
 */
public class Paranthesis {


    public static void generateParens(Set<String> parens,String currentStr, int max,int leftRem, int rightRem ){
        if(leftRem == 0 && rightRem == 0){
            parens.add(currentStr);
            return;
        }
        if(leftRem!=0 ){
            generateParens(parens,currentStr+ "(" ,max,leftRem-1,rightRem);
        }
        if(rightRem!=0 && leftRem < rightRem){
            generateParens(parens,currentStr+ ")" ,max,leftRem,rightRem-1);
        }
    }

    public static void main(String[] args) {
        HashSet<String> input = new HashSet<String>();
        generateParens(input,"",3,3,3);
        System.out.println(input);
    }

}
