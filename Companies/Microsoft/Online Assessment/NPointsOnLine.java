// https://www.geeksforgeeks.org/find-set-m-element-whose-difference-two-element-divisible-k/
//https://leetcode.com/discuss/interview-question/525894/Microsoft-or-OA-2020-or-Largest-M-aligned-Subset
// Largest M-aligned Subset
// N points located on a line




public class Main {
    public static void main(String[] args) {
        int[] array = {-3, -2, 1, 0, 8, 7, 1};
        int a = getLargestMAlignedSubset(array, 3);
        System.out.println(a);
    }
    
    private static int getLargestMAlignedSubset(int[] array, int M) {
        int result = 0;
        if (array == null || array.length == 0) return 0;
        
        int length = array.length;
        // aggregate numbers by the reminder
        int[] subsetSizeArray = new int[M];
        for (int num : array) {
            // get reminders, and convert non-positive reminders to non-negative
            int index = num < 0 ? (num % M + M) % M : num % M;
            result = Math.max(++subsetSizeArray[index], result);
        }
        return result;
    }
}
