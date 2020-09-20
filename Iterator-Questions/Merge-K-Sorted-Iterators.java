import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Given a list of k sorted iterators. Implement MergingIterator to merge them. If you are not familiar with Iterators check similar questions.
 * MergingIterators
 * 
 * Google Onsite
 * 
 * 
*/



public class MergingIterator implements Iterator<Integer> {
    PriorityQueue<Integer> pq;

    public MergingIterator(List<Iterator<Integer>> iterators) {
        pq = new PriorityQueue<>(iterators.size(), (i1, i2)-> Integer.compare(i1.peek(), i2.peek()));

        for (Iterator<Integer> i: iterators) {
            if (i.hasNext()){
                pq.offer(new PeekingIterator(iterator));
            }
        }

    }

    @Override
    public boolean hasNext() {
        return !pq.isEmpty();
    }

    @Override
    public Integer next() {
        PeekingIterator nextIter = pq.remove();
        Integer next = nextIter.next();

        if(nextIter.hasNext()) {
            pq.add(nextIter);
        }

        return next;

    }


}

class PeekingIterator implements Iterator<Integer> {
    Integer next = null;
    Iterator<Integer> curr;
    boolean done = false;
	public PeekingIterator(Iterator<Integer> iterator) {
	    curr = iterator;
        moveIterator();
	}
	
	public Integer peek() {
        return next;
	}
	
	@Override
	public Integer next() {
        if(done){
            throw new NoSuchElementException();
        }
        Integer res = next;
        moveIterator();
        
        return res;
	}
	
	@Override
	public boolean hasNext() {
	    return next!=null;
	}
    
    public void moveIterator(){
        if(curr.hasNext()){
            next = curr.next();
        }
        else{
            done = true;
            next = null;
        }
    }
}