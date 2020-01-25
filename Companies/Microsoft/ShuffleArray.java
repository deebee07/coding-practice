/*

Given a bag of 100 balls, generate a sequence of draws from the bag. (Basicallty, shuffle an array 1..100).
Reference: https://www.geeksforgeeks.org/shuffle-a-given-array-using-fisher-yates-shuffle-algorithm/

Fisher–Yates shuffle Algorithm works in O(n) time complexity
    Assumption here is, we are given a function rand() that generates random number in O(1) time.
*/

import java.util.*;

public class ShuffleArray {
// Fisher Yates Shuffle O(N)
// FISHER YATES ALGORITHM
 public static void randomize(int[] arrayToRandom, int n) {
     Random r = new Random();
     for (int i=n-1; i>0; i--) {
        int j = r.nextInt(i+1); // Gives random num between 0 to i
        
        //swap based on randomIndex we got
        int temp = arrayToRandom[i];
        arrayToRandom[i] = arrayToRandom[j];
        arrayToRandom[j] = temp;
     }
     
     System.out.println(Arrays.toString(arrayToRandom));
 }

  public static void main(String[] args) {
      int[] bagOfBalls = new int[100];
      
      for (int i=0; i<bagOfBalls.length; i++) {
          bagOfBalls[i] = i;
      }
      
      randomize(bagOfBalls, 100);
  }
}