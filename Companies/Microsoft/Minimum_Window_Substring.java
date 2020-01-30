/*
https://leetcode.com/problems/minimum-window-substring/
*/

class Solution {
    public String minWindow(String s, String t) {
        
        if(s.isEmpty()) return "";
        
        int[] need = new int[128];
        
        for(char c : t.toCharArray()) need[c]++; // tArray is need Array
        
        char[] a = s.toCharArray(); // a toCharArray()
        
        int r = 0, l = 0, missing = t.length(), i = 0, j = 0;
        
        while(r < s.length()){
            if(need[a[r]] > 0) missing --;
            need[a[r]]--;
            r++;
            
            while(missing == 0){
                if(j == 0 || (r - l) < (j - i)){
                    j = r;
                    i = l;
                }
                need[a[l]]++;
                if(need[a[l]] > 0) missing++;
                l++;
            }
        }

        return s.substring(i, j);
    }
}



class Solution {
    public String minWindow(String S, String T) {
        if(S==null||S.isEmpty()||T==null||T.isEmpty()) return "";
        int i=0, j=0;
        int[] Tmap=new int[256];
        int[] Smap=new int[256];
        for(int k=0; k< T.length(); k++){
            Tmap[T.charAt(k)]++;
        }
        int found=0;
        int length=Integer.MAX_VALUE;
        String res="";
        while(j<S.length()){
            if(found<T.length()){
                if(Tmap[S.charAt(j)]>0){
                    Smap[S.charAt(j)]++;
                    if(Smap[S.charAt(j)]<=Tmap[S.charAt(j)]){
                        found++;
                    }
                }
                j++;
            }
            while(found==T.length()){
                if(j-i<length){
                    length=j-i; res=S.substring(i,j);
                }
                if(Tmap[S.charAt(i)]>0){
                    Smap[S.charAt(i)]--;
                    if(Smap[S.charAt(i)]<Tmap[S.charAt(i)]){
                        found--;
                    }
                }
                i++;
            }
        }
        return res;
    }
}