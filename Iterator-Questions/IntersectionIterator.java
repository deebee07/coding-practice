/* 
https://leetcode.com/discuss/interview-question/352049/Lyft-or-Phone-Screen-or-Intersection-Iterator

Given two sorted iterators.
    Implement IntersectionIterator which returns only common elements in both iterators. 
    If you are not familiar with Iterators check similar questions.

public class IntersectionIterator implements Iterator<Integer> {
    
    public IntersectionIterator(Iterator<Integer> it1, Iterator<Integer> it2) {
    }

    public boolean hasNext() {
    }

    public Integer next() {
    }
}

Example 1:

IntersectionIterator it = new IntersectionIterator([1, 2, 4, 5, 6], [1, 3, 5]);
it.hasNext(); // true
it.next(); // 1
it.next(); // 5
it.hasNext(); // false
it.next(); // error
Example 2:

IntersectionIterator it = new IntersectionIterator([1, 2, 4, 5, 6], [3, 7, 8, 9]);
it.hasNext(); // false
Example 3:

IntersectionIterator it = new IntersectionIterator([1, 2, 3, 4], [1, 2, 3, 4]);
it.hasNext(); // true
it.next(); // 1
it.next(); // 2
it.next(); // 3
it.next(); // 4
it.hasNext(); // false

*/

import java.util.Iterator;
import java.util.ArrayList;

class IntersectionIterator implements Iterator<Integer> {
    private Integer nextVal = null;
    Iterator it1;
    Iterator it2;
    
    
    public IntersectionIterator(Iterator it1, Iterator it2) {
        this.it1 = it1;
        this.it2 = it2;
        adjust();
    }
    
     /**
     * Returns the next element in the iteration (common element in the two iterators).
     */
    public boolean hasNext() {
        if(nextVal == null) return false;
        return true;
    }
    
    /**
     * Returns true if the iteration has more elements (common elements in the two interators).
     */
    public Integer next() {
        Integer toRet = nextVal;
        adjust();
        return toRet;
    }
    
    private void adjust() {
        nextVal = null;
        Integer val1 = it1.hasNext() ? (Integer) it1.next() : null;
        Integer val2 = it2.hasNext() ? (Integer) it2.next() : null;
        while(true) {
            if(val1 == null || val2 == null) break;
            if(val1 == val2) {
                nextVal = val1;
                break;
            }else if(val1 < val2) {
                if(it1.hasNext()) {
                    val1 = (Integer) it1.next();
                }else break;
            }else{
                if(it2.hasNext()) {
                    val2 = (Integer) it2.next();
                }else break;
            }
        }
    }
}


public class HelloWorld{

     public static void main(String []args){
         
         ArrayList<Integer> list1 = new ArrayList<>();
         list1.add(1);
         list1.add(2);
         list1.add(4);
         list1.add(5);
         list1.add(6);
         ArrayList<Integer> list2 = new ArrayList<>();
         list2.add(1);
         list2.add(3);
         list2.add(5);
        IntersectionIterator it = new IntersectionIterator(list1.iterator(), list2.iterator());
        
        System.out.println(it.hasNext());
        System.out.println(it.next());
     }
}

