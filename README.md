ACE JAVA INTERVIEW:
https://www.educative.io/track/ace-java-coding-interview

# Brute-force approach: 
* Less logical errors
* Sacrifice Time complexity for simplicity
# Broad and Specific Techniques:
* Efficient solutions

  ## Broad techniques:
  1. [Divide and Conquer](Notes/divide-and-conquer.md)
  2. [Decrease and Conquer](Notes/decrease-and-conquer.md)
  3. [Recursion](Notes/helper-method-recursion.md)
  4. [Dynamic Programming](Notes/dynamic-programming.md)
  ## Specific techniques:
  1. [Multiple pointers](Notes/multiple-pointers.md)
  2. [Frequency Count](Notes/frequency-counting.md)

## Patterns
* [Patterns for Coding Questions](patterns-for-questions/README.md)

## ASCII Character
a-97
z-122
**a-z (97-122)**

A-65
Z-90
**A-Z (65-90)**

32 [space]

* MAKE SURE ASCII VALUE IS IN RANGE FOR UPPER(65-90)/FOR LOWER(97-122)
* To CONVERT FROM UPPERCASE TO LOWERCASE: ALWAYS ADD 32 to ASCII Value
* To CONVERT FROM LOWERCASE to UPPERCASE: ALWAYS SUBTRACT 32 to ASCII Value

![ASCII Code Cheat Sheet](https://catonmat.net/ftp/ascii-cheat-sheet.png)


Reference: http://www.gayle.com/blog/2016/3/coding-interviews-and-the-importance-of-perfectionconsider 

```Q:``` Below snippet is used to locate all instances of a string s within a string b

```
int countSubstrings(String s, String b) {
 int count = 0;
 for (int i = 0; i < b.length() — s.length(); i++) {
    String bSubstring = b.substring(i, i + s.length());
    if (bSubstring.equals(s)) {
     count++;
    }
 }
 return count;
}

```
Faulty Code: <br/>
1. Below code should have String s and String b check for null.
2. xyz and xyz will fail here as code wont go in loop, so loop must run from ```i = 0``` to ```b.length()-s.length() + 1```
