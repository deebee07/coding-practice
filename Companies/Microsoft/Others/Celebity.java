
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

      public class Solution extends Relation {
        public int findCelebrity(int n) {
            int candidate = 0; // Assume element  0 is celebrity
    
            for (int i=1;i<n;i++){  //iterate over all candidates with know(candidate, i) by definition i can be a celebrity
                if (knows(candidate, i)) {
                    candidate = i;
                }
            }
            
            /*
                if (i!=candidate && (knows(candidate,i) || !knows(i, candidate)) return -1;
            */
            for (int i=0; i<n;i++) {
                if (i!=candidate && (knows(candidate, i)|| !knows(i, candidate))) return -1;
            }
            return candidate;
        }
    }