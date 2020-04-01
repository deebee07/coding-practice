// https://leetcode.com/discuss/interview-question/525986/Microsoft-or-OA-2020-or-Return-strings-that-donot-contain-identical-neighbors

public static void main(String[] args) {
	int n1 = 2, k1 = 4;
	int n2 = 3, k2 = 20;
	int n3 = 5, k3 = 6;
	System.out.println(solve(n1, k1));
	System.out.println(solve(n2, k2));
	System.out.println(solve(n3, k3));
}

private static List<String> solve(int n, int k) {
	List<String> res = new ArrayList<>();
	String s = "abc";
	dfs(res, s, n, k, new StringBuilder());
	return res;
}

private static void dfs(List<String> res, String s, int n, int k, StringBuilder sb) {
	if(res.size() == k)
		return;
	if(sb.length() == n) {
		res.add(sb.toString());
		return;
	}
	for(int i=0;i<s.length();i++) {
		if(sb.length() == 0 || sb.charAt(sb.length() - 1) != s.charAt(i)) {
			sb.append(s.charAt(i));
			dfs(res, s, n, k, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}