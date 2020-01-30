## Useful Methods in Java to solver Programming questions

1.
```
/*
    * Method is used to add the element ‘element’ to this collection.
    * @param element Object to be added.
    * @return boolean value depicting the successfulness of the operation
*/
Collection.add(E element)
```
2.
Basic heap operations: (MaxHeap here)
```
// Creating empty priority queue (maxHeap)
PriorityQueue<Integer> pQueue =  new PriorityQueue<Integer>(Collections.reverseOrder()); 
pQueue.add(10); 
pQueue.add(30); 
pQueue.add(20); 
pQueue.add(400);
pQueue.peek(); //Head value; the most priority element HERE IT WILL BE 400

// Printing all elements 
Iterator itr = pQueue.iterator();
while (itr.hasNext())
    System.out.println(itr.next()); // 400 30, 20, 10

pQueue.poll(); //Removing the top priority element // Remove 400

pQueue.remove(30); // Removing 30 using remove() 

boolean b = pQueue.contains(20); // Check if an element is present using contains()

Object[] arr = pQueue.toArray();  // Convert to Array
  
```

3. ```offer()``` vs ```add()```
```
Queue.add

Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions, returning true upon success

Queue.offer

Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions. When using a capacity-restricted queue, this method is generally preferable to add(E), which can fail to insert an element only by throwing an exception...
```
4. 
```
java.util.LinkedList.offer(E e) method adds the specified element as the tail (last element) of this list.

java.util.LinkedList.poll() method retrieves and removes the head (first element) of this list.

java.util.ArrayList.add(int index, E elemen) method inserts the specified element E at the specified position in this list.It shifts the element currently at that position (if any) and any subsequent elements to the right.
```

5.
```
peek() method retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
poll() method retrieves and removes the head of this queue, or returns null if this queue is empty.
```

6.
```
Collections.swap(List, index1, index2)
```

```
```

```
String.valueOf()
```

**Reference help:** 
https://www.tutorialspoint.com/java/util/arraylist_add_index.htm

https://www.geeksforgeeks.org/arraylist-in-java/



Character.isDigit(str.charAt(i))
Character.getNumericValue(digits.charAt(i));
Character.isLetterOrDigit
Character.toLowerCase()
str.charAt()
 System.arraycopy(nums2, 0, nums1, 0, p2 + 1);

char[] ca = s.toCharArray();
String back = String.valueOf(ca);


String.indexOf


Integer.compare(a.start, b.start)
Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));


List<Interval> intervals
intervals.size()

Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
Iterator<Interval> intervalItr = intervals.iterator();

intervals.get(i)