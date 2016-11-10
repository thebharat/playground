package bm;

/**
 * @author bharat.thakarar on 28/10/16.
 */
public class Rough {

    void insert(int n, int m, int i, int j){

    }

    public static int getBit(int n, int i){
        return (n & (1 << (i-1))) != 0 ? 1 : 0;
    }

    public static int getMSBPos(int n){
        int count = 31;
        while(getBit((n = n << 1),31) != 1){
            count--;
        }
        return count-1;
    }

    public static void main(String[] args) {
        int n = getMSBPos(10);
        System.out.println("n = " + n);
    }
}
