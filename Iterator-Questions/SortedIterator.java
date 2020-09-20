import java.util.ArrayList;
import java.util.Queue;

// Implement a sorted java iterator that returns a sorted list over k sorted lists.

public class SortedIterator implements Iterator<Integer> {

    private PriorityQueue<Integer> queue;

    SortedIterator(List<List<Integer>> listsToSort) {
        helper(listsToSort);
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public Integer next() {
        return queue.isEmpty() ? null : queue.poll();
    }

    private void helper(List<List<Integer>> listsToSort) {
        if (listsToSort == null) return;

        queue = new PriorityQueue<>();

        for (List<Integer> currentList: listsToSort) {
            for (Integer i : currentList) {
                queue.add(i);
            }
        }
    }

    private List<Integer> sortedList() {

        List<Integer> list = new ArrayList<>();
        while(hasNext()) {
            list.add(next());
        }
        return list;
    }

}