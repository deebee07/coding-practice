/*
https://leetcode.com/problems/remove-vowels-from-a-string/
*/

class Solution {
    public String removeVowels(String S) {
        return S.replaceAll("[aeiou]", "");
    }

}

/*
Declare StringBuilder as output
Declare a String with vowels (AEIOUaeious)

getCharArray of inputString

iterate over charArray of inputString
    if(stringWithVowels.indexOf(eachChar)==-1){
        append to declared output StringBuilder variable (as char is not vowel)
    }
return toString() of StringBuilder
*/
class Solution {
    public String removeVowels(String S) {
        String v ="oeiuaAEIUO";
    
        StringBuilder sb = new StringBuilder();
        for(char c : S.toCharArray())
        {
            if(v.indexOf(c)==-1)
                sb.append(c);
        }
        
        return sb.toString();
    }
    }