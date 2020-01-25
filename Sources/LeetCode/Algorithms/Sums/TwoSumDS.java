// https://leetcode.com/problems/two-sum-iii-data-structure-design/
//SLOW 
// class TwoSum {
    
//     ArrayList<Integer> myList;

//     /** Initialize your data structure here. */
//     public TwoSum() {
//         this.myList = new ArrayList<Integer>();
//     }
    
//     /** Add the number to an internal data structure.. */
//     public void add(int number) {
//         myList.add(number);
//     }
    
//     /** Find if there exists any pair of numbers which sum is equal to the value. */
//     public boolean find(int value) {
//         Collections.sort(this.myList);
//         int i = 0;
//         int j = this.myList.size()-1;
        
//         while (i<j){
            
//             int curSum = this.myList.get(i) + this.myList.get(j);
//             if (curSum==value) {
//                 return true;
//             } else if (curSum>value){
//                 j--;
//             } else {
//                 i++;
//             }
//         }
//         return false;
//     }
// }

// /**
//  * Your TwoSum object will be instantiated and called as such:
//  * TwoSum obj = new TwoSum();
//  * obj.add(number);
//  * boolean param_2 = obj.find(value);
//  */



class TwoSum {
    
    HashMap<Integer, Integer> myMap;

    /** Initialize your data structure here. */
    public TwoSum() {
        this.myMap = new HashMap<Integer, Integer>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if (this.myMap.containsKey(number)){
            this.myMap.put(number, this.myMap.get(number)+1); //put frequency as key
        }else {
            this.myMap.put(number, 1);
        }
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        
        for (Integer i: this.myMap.keySet()) {
            int complement = value-i;
            if ((complement!=i && myMap.containsKey(complement)) || (complement==i && myMap.get(complement)>1) ) {//containsComplement or ifSameNumAndComplement have more frequency
                return true;
            }
        }
        return false;
    }
}


/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */