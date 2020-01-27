/*
https://leetcode.com/explore/interview/card/microsoft/30/array-and-strings/179/
*/
/*
    Initialize a stack S
        Process each bracket of the expression one at a time.
If we encounter an opening bracket, we simply push it onto the stack. This means we will process it later, let us simply move onto the sub-expression ahead.
If we encounter a closing bracket, then we check the element on top of the stack. If the element at the top of the stack is an opening bracket of the same type, then we pop it off the stack and continue processing. Else, this implies an invalid expression.
In the end, if we are left with a stack still having elements, then this implies an invalid expression.
*/
class Solution {

    // Hash table that takes care of the mappings.
    private HashMap<Character, Character> mappings;
  
    // Initialize hash map with mappings. This simply makes the code easier to read.
    public Solution() {
      this.mappings = new HashMap<Character, Character>();
      this.mappings.put(')', '(');
      this.mappings.put('}', '{');
      this.mappings.put(']', '[');
    }
  
    public boolean isValid(String s) {
  
      // Initialize a stack to be used in the algorithm.
      Stack<Character> stack = new Stack<Character>();
  
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
  
        // If the current character is a closing bracket.
        if (this.mappings.containsKey(c)) {
  
          // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
          char topElement = stack.empty() ? '#' : stack.pop();
  
          // If the mapping for this bracket doesn't match the stack's top element, return false.
          if (topElement != this.mappings.get(c)) {
            return false;
          }
        } else {
          // If it was an opening bracket, push to the stack.
          stack.push(c);
        }
      }
  
      // If the stack still contains elements, then it is an invalid expression.
      return stack.isEmpty();
    }
  }