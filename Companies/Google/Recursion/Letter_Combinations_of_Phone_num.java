/*
Declare a map with key as number and value as string such as:
    2 - > abc
    3 - > def
Declare an outputList called output

call backtrackFunction with (output, "", digitsAsInput)


backtrackFunction voidType return:
    baseCase:
        if digitsAsInput.length()==0
            output.add(combination)
            return
    String curDigit = digitsAsInput.substring(0,1);
    String letters = map.get(curDigit);
    for loop iterate over all letters:
        curLetter = letters.substring(i,i+1)
        backtrackFunction(output, combination+curLetter, next_digits.substring(1))

*/

class Solution {
    Map<String, String> phone = new HashMap<String, String>() {{
      put("2", "abc");
      put("3", "def");
      put("4", "ghi");
      put("5", "jkl");
      put("6", "mno");
      put("7", "pqrs");
      put("8", "tuv");
      put("9", "wxyz");
    }};
  
    List<String> output = new ArrayList<String>();
  
    public void backtrack(String combination, String next_digits) {
      // if there is no more digits to check
      if (next_digits.length() == 0) {
        // the combination is done
        output.add(combination);
      }
      // if there are still digits to check
      else {
        // iterate over all letters which map 
        // the next available digit
        String digit = next_digits.substring(0, 1);
        String letters = phone.get(digit);
        for (int i = 0; i < letters.length(); i++) {
          String letter = letters.substring(i, i + 1);
          // append the current letter to the combination
          // and proceed to the next digits
          backtrack(combination + letter, next_digits.substring(1));
        }
      }
    }
  
    public List<String> letterCombinations(String digits) {
      if (digits.length() != 0)
        backtrack("", digits);
      return output;
    }
  }