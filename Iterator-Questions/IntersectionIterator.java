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

