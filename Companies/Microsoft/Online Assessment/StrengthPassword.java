//https://leetcode.com/discuss/interview-question/538445/Microsoft-or-OA-2020-or-Weight-of-string

// Strength of Password 

private static int solve(String s, int n) {
	int res = 0;
	for(char c : s.toCharArray())
		res += ((c - 'a') + n) % 26;
	return res;
}
