package rec;

import java.util.*;

/**
 * @author bharat.thakarar on 06/11/16.
 */
public class SuperSet {

    public static void superSetHelper(List<Integer> list,
                                                   Set<Set<Integer>> runningSet,
                                                   int index){
        // terminating condition
        if(index >= list.size())
            return;
        Set<Set<Integer>> newSubSets = new HashSet<Set<Integer>>();
        for (Set<Integer> subset: runningSet) {
            newSubSets.add(copyAndAdd(subset,list.get(index)));
        }
        runningSet.addAll(newSubSets);
        superSetHelper(list,runningSet,index+1);
    }

    public static <E> Set<E>  copyAndAdd(Set<E> orig, E e){
        HashSet<E> newSubset = new HashSet<E>(orig);
        newSubset.add(e);
        return newSubset;
    }

    public static Set<Set<Integer>> getSuperSet(List<Integer> list){
        Set<Set<Integer>> superSet = new HashSet<Set<Integer>>(); // todo generics while new and declration
        superSet.add(new HashSet<Integer>());
        superSetHelper(list,superSet ,0);
        return superSet;
    }

    public static void main(String[] args) {
        System.out.println(getSuperSet(Arrays.asList(1,2,3)));
    }
}
