/*
We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions.

If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

*/


class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        
        for (int n : asteroids) {
            boolean destroyed = false;
            
            // only move forward if we have a previously element going forward, and another element going back!
            while (!st.isEmpty() && n < 0 && st.peek() > 0) {                
                // explode both
                if (Math.abs(n) == Math.abs(st.peek())) {
                    st.pop();
                    destroyed = true;
                    break; // both were destroyed so exit
                } else if (Math.abs(n) > Math.abs(st.peek())) {
                    st.pop(); // simply pop and keep trying to destroy the asteroids
                } else {
                    n = st.pop();
                    break;
                }
            }
            
            // the asteroid hasn't been destroyed
            if (!destroyed)
                st.push(n);            
        }
        
        // create an array
        int[] sol = new int[st.size()];
        
        for (int i = st.size() - 1; i >= 0; i--) {
            sol[i] = st.pop();
        }
        
        return sol;
    }
}