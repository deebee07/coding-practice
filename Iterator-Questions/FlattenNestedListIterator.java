import java.util.List;
import java.util.Queue;

/*
https://leetcode.com/problems/flatten-nested-list-iterator/
Flatten Nested List Iterator
Medium

1522

618

Add to List

Share
Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:

Input: [[1,1],2,[1,1]]
Output: [1,1,2,1,1]
Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,1,2,1,1].
Example 2:

Input: [1,[4,[6]]]
Output: [1,4,6]
Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,4,6].

*/

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    private Queue<Integer> queue = new LinkedList<Integer>();

    public NestedIterator(List<NestedInteger> nestedIntegerList) {
        helper(nestedIntegerList);
    }

    @Override
    public boolean hasNext() {
        if (queue.isEmpty()) {
            return false;
        } else {
            return true;
        } 
    }

    @Override
    public Integer next() {
        if (!queue.isEmpty()) {
            return queue.poll();
        } else {
            return null;
        }
    }


    private void helper(List<NestedInteger> nestedIntegerList) {
        if (nestedIntegerList == null) return;

        for (NestedInteger currentNesInteger: nestedIntegerList) {
            if (currentNesInteger.isInteger()) {
                queue.offer(currentNesInteger.getInteger());
            } else {
                helper(currentNesInteger.getList());
            }
        }

    }


}
/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */