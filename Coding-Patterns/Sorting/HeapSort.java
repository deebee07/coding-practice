import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;




class MinHeap {
  int[] heap;
  int size;
  int maxSize;
  
  MinHeap(int maxSize) {
    this.heap = new int[maxSize];
    this.maxSize = maxSize;
    size = 0;
  }
  public int rightChild(int index) {
        return (2 * index);
  }
  public int leftChild(int index) {
      return (2*index + 1);
  }
  
  public boolean isLeaf(int index) {
        if (index >= (size / 2) && index <= size) {
            return true;
        }
        return false; 
    }
  
  public void heapify(int index) {
    //check the node comapring with left and right child
    //child1 = 2p+1;
    //child2 = 2p+2;
    
    if (!LeafNode(heap)) {
      if (heap[index]>heap[leftChild(index)]){
            swap(heap, index, leftChild(index));
            heapify(leftChild(index));
      }
      
      if (heap[index]>heap[rightChild(index)]){
            swap(heap, index, rightChild(index));
            heapify(rightChild(index));
      }
    }

    
    
  }


class Result {
    public void swap(List<Integer> list, int index_1, int index_2) {
            Collections.swap(list, index_1, index_2);      
    }
    /*
     * Complete the 'heapsort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> heapsort(List<Integer> arr) {
        int[] Heap;
        int size;
        int maxSize;
        size = arr.size();
        int[] Heap = arr.toArray();
        for (int pos = (size / 2); pos >= 1; pos--) { 
            MinHeap.heapify(pos); 
        }
    
    }

}

public class Solution {