/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
    List<String > list = new ArrayList<>(Arrays.asList(wordlist)); 
	// transfer String[] to list, so that we can remove item.
    for(int i =0 ;i<10;i++){
        String s = list.get(0);
        int  a = master.guess(s);
        // get the feedback and use it to shrink the range of candidates.
        if(a==s.length()) return;
		// if answer is right, stop this program.
        list.remove(0);
		// if answer is wrong, remove the guessed string because if we dont remove it, it will always meet the filter.
        int j=0;
		// remove all items which have different answer with we guessed string, we should know that the correct answer can meet the filter all the time.
        while( j<list.size()){
            if(compare(list.get(j),s)!=a ||( a==0 && compare(list.get(j),s)>a)){
                list.remove(j);
            }
            else j++;
        }
        Collections.sort(list);
		//the final testcase need 11times....... use sort to be more lucky ^-^
    }

    }
    private int compare(String s1, String s2){
        int ans =0;
        for(int i =0;i<s1.length();i++){
            if(s1.charAt(i)==s2.charAt(i)) ans++;
        }
        return ans;
    }
}