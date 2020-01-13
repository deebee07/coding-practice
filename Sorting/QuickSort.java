import java.util.*;
public class Result {
    
    public static List<Integer> quicksort(List<Integer> arr) {
      int low = 0;
      int high = arr.size()-1;
      
      /*
      Call quickSort with parameters:
        Array<Integer>
        lowIndex
        highIndex
      */
      return quicksort(arr, low, high);
    }
    
    public static List<Integer> quicksort(List<Integer> Arr, int low, int high) {
        
        /*
        Call quickSort with parameters:
        Array<Integer>
        lowIndex
        highIndex
        
        pseudoCode:
        iterate until low<high:
            get pivot_index via partition(Arr,low,high)
            call quicksort(Arr, low, pivot_index-1)
            call quicksort(Arr, pivot_index+1, high)
        return Arr
      */
      if (low<high) {
        int pivot_index = partition(Arr, low, high);
        quicksort(Arr, low, pivot_index-1);
        quicksort(Arr, pivot_index+1, high);
      }
      return Arr;
    }
    public static int partition(List<Integer> Arr, int low, int high) {
        
        /*
        Call partition with parameters:
        Array<Integer>
        lowIndex
        highIndex
        
        pseudoCode:
        let pivot_value = Array.get(lowIndex) (Can also be made random here always low)
        start = low;
        end = high -1; //since high is pivot
        Make high as pivot_value so swap (pivot_index, high)
        Now iterate until start<=end:
            if (Array.get(start)<Array.get(high)/pivot_value)
                move startForward start++
            else
            swap(endIndex and startIndex)
            end --;
        swap(high, startIndex) this makes sure we put pivot at right place
        return start (Correct index of pivot)
      */
    int pivot_value = Arr.get(low);
    int start = low;
    int end = high - 1;
    Collections.swap(Arr, low, high);
    while (start <=end) {
      if (Arr.get(start)>pivot_value) {
        Collections.swap(Arr, start, end);
        end --;
      } else {
        start ++;
      }
    }
    Collections.swap(Arr, start, high);
    return start;
    }
    
    public static void main (String[] args) {
        List<Integer> outputList = quicksort(Arrays.asList(45,56,1,2,3,4,123,1241,67543));
        
        for (Integer i : outputList){
            System.out.print(i+" ");
        }
    }
}