/*

FIND MINIMUM IN SORTED ARRAY WITH DUPICATES
    int low = 0;
    int high = arr.length -1;

    while (low < high) {

        int mid = (low + high)/2;

        if (arr[mid] < arr[high]) {
            high = mid;
        } else if (arr[mid] > arr[high]) {
            low = mid+1;
        } else {
            high--;
        }
    }
    return arr[low];
*/


class Solution {
    public int findMin(int[] nums) {
      int low = 0, high = nums.length - 1;
  
      while (low < high) {
        int mid = (low + high)/ 2;
  
        if (nums[mid] < nums[high])
          high = mid;
        else if (nums[mid] > nums[high])
          low = mid + 1;
        else
          high -= 1;
      }
      return nums[low];
    }
  }