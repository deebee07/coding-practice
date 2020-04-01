/*
Given an array A of N integers, return true if A contains at least two elements which differ by 1, and false otherwise.

Example,
A = [7] , return false
A = [4,3], return true (3,4)
A = [11, 1, 8, 12, 14] , return true (11,12)
A = [5, 5, 5, 5, 5], return false
A = [4, 10, 8, 5, 9], return true (4,5), (8,9), (9,10)

Second question was Max Possible Value
*/

private static boolean solve(int[] nums) {
	Set<Integer> set = new HashSet<>();
	for(int n : nums) {
		if(set.contains(n-1) || set.contains(n+1))
			return true;
		set.add(n);
	}
	return false;
}

