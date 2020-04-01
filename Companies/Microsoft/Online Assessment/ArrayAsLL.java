// Finding the lengths of the array -> an array represents a linked list where index 0 represents the head. Example [1,4,-1,3,2], result will be 4 where:
// - Head has value of 1
// - 1 has value of 4
// - 4 has value of 2
// - 2 has value of -1 which ends the LL
// https://leetcode.com/discuss/interview-question/546683/OA-Microsoft-2020

public int findLength(int[] input) {
    if (input == null || input.length == 0 || input[0] == -1)
        return 0;

    int length = 0;
    int index = 0;
    while (true) {
        index = input[index];
        length++;
        if (index == -1)
            break;
    }
    return length;
}

