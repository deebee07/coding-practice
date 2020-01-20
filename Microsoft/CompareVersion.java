/*
compare-version-numbers
https://leetcode.com/problems/compare-version-numbers/
*/

/*
If version1 > version2 return 1; 
If version1 < version2 return -1;
Otherwise return 0
https://beginnersbook.com/2013/12/java-string-compareto-method-example/
compareTo() method is used for comparing two strings lexicographically.

*/
class Solution {
    
    public int compareVersion(String version1, String version2) {
    // Break String based on .
    String[] levels1 = version1.split("\\.");
    String[] levels2 = version2.split("\\.");

    System.out.println(Arrays.toString(levels1));
    System.out.println(Arrays.toString(levels2));
    
    int length = Math.max(levels1.length, levels2.length); //whichever is maximum length out of 2 numbers

    for (int i=0; i<length; i++) {
    	Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;

    	Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;

    	int compare = v1.compareTo(v2);
    	if (compare != 0) {
    		return compare;
    	}
    }
    
    return 0;
}
}



class Solution {
    
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int n = Math.max(v1.length,v2.length);
        for(int i=0; i<n; i++) {
            int k = i<v1.length ? Integer.parseInt(v1[i]) : 0;
            int j = i<v2.length ? Integer.parseInt(v2[i]) : 0;
            if(k > j) return 1;
            else if(k < j) return -1;
            else continue;
        }
        return 0;
    }
    }