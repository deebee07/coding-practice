//https://leetcode.com/discuss/interview-question/547623/microsoft-online-assessment-questions-solutions-and-test-cases

//Largest M-aligned Subset
    public static int largestMAlignedSubset(int[] nums, int M) {
        if (M <= 1) return nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            int rem = n < 0 ? n % M + M : n % M;
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        int res  = 0;
        for (int rem : map.keySet()) {
            res = Math.max(res, map.get(rem));
        }
        return res;
    }



    //Crop words
    private static String cropWords(String s, int k){
        if(k >= s.length()){
            return s;
        }
        while(s.charAt(k) != ' '){
            k--;
        }
        while(k > 0 && s.charAt(k) == ' '){
            k--;
        }
        return s.substring(0, k + 1);
    }

    static class TreeNode {
        int val;

        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static ArrayList<Integer> visible = new ArrayList<>();
    //Count Visible Nodes in Binary Tree
    private static void dfs(TreeNode node, int max) {
        if (node == null) {
            return;
        }

        if (node.val >= max) {
            visible.add(node.val);
            max = Math.max(node.val, max);
        }

        dfs(node.left, max);
        dfs(node.right, max);
    }

    public static int numTimesAllShine(int[] A) {
        int rightMost = 0, res = 0;
        for (int i = 0; i < A.length; i++) {
            rightMost = Math.max(rightMost, A[i]);
            if (rightMost == i + 1) res++;
        }
        return res;
    }

    public static int minMeetingRooms(int[][] is) {
        //This is actually a sliding window question,
        //left is the last start,
        //right is the first end after start
        //room is the rooms in the sliding window,
        //since it is an expanding window, the room in current window is current max;
        int n = is.length, room = 0;
        int[] starts = new int[n], ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = is[i][0];
            ends[i] = is[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        for (int l = 0, r = 0; l < n; l++) {
            if (starts[l] < ends[r]) room++;
            else if (++r == n) break;
        }
        return room;
    }

    public static boolean jumpGameIII(int[] arr, int s) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> vs = new HashSet<>();
        q.add(s);
        while (!q.isEmpty()) {
            int curr = q.poll();

            int l = curr - arr[curr];
            int r = curr + arr[curr];
            if (!vs.contains(l) && l >= 0) {
                if (arr[l] == 0) return true;
                q.offer(l);
                vs.add(l);
            }

            if (!vs.contains(r) && r < arr.length) {
                if (arr[r] == 0) return true;
                q.offer(r);
                vs.add(r);
            }
        }

        return false;
    }

    private static int t, l;
    private static boolean[] vs;
    private static int[] arr;
    public static List<List<Integer>> canPartitionKSubsets(int[] nums, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int max =Integer.MIN_VALUE, sum = 0;
        for (int n : nums) {
            sum += n;
            max = Math.max(max, n);
        }
        if (k <= 0 || !(sum % k == 0)) return res;
        t = sum / k;
        if ( t < max) return res;
        arr = nums;
        l = arr.length;
        vs = new boolean[l];
        List<Integer> tmp = new ArrayList<>();
        if (dfs(0, 0, 0, k, tmp, res)) {
            res.add(tmp);
            return res;
        }
        return new ArrayList<>();
    }

    private static boolean dfs(int start, int sum, int curr, int rem, List<Integer> tmp, List<List<Integer>> res) {
        if (rem == 1) return true;
        if (sum == t && curr > 0) {
            boolean ret = dfs(0, 0, 0, rem - 1, new ArrayList<>(), res); // reset start to 0;
            if (ret) res.add(0, tmp);
            return ret;
        }
        for (int i = start; i < l; i++) {
            if (!vs[i]) {
                vs[i] = true;
                tmp.add(arr[i]);
                if (dfs(i+1, sum + arr[i], curr++, rem, tmp, res)) return true;
                tmp.remove(tmp.size() - 1);
                vs[i] = false;
            }
        }
        return false;
    }


    //Particle Velocity
    private static int particleVilocity(int[] vs) {
        int res = 0, i = 0;
        while (i < vs.length) {
            int cnt = 0;
            while (i + 2 < vs.length && vs[i + 1] - vs[i] == vs[i + 2] - vs[i + 1]) {
                cnt++;
                res += cnt;
                i++;
            }
            i++;
        }
        return res;
    }

    //Min Deletions To Obtain String in Right Format
    public static int minDelRightFormat(String s) {
        if (s == null || s.length() == 0) return 0;
        int ra = 0, lb = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') ra++;
        }
        int res = ra;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') ra--;
            else lb++;
            res = Math.min(res, ra + lb);
        }
        return res;
    }


    //Find N Unique Integers Sum up to Zero
    public static int[] sumZero(int n) {
        int[] res = new int[n];
        for (int i = 0; i + 1 < n; i += 2) {
            res[i] = i + 1;
            res[i + 1] = - i - 1;
        }
        return res;
    }

    //Min Adj Swaps to Group Red Balls
    public static int minAdjSwapRedBalls(String s) {
        List<Integer> redIndex = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') redIndex.add(i);
        }
        int res = 0, mid = redIndex.size() / 2;  // mid is the point to get minimum swaps; greedy.
        for (int i = 0; i < redIndex.size(); i++) {
            res += Math.abs(redIndex.get(mid) - redIndex.get(i)) - Math.abs(mid - i);
        }
        return res;
    }


    //Write a function that, given an array A of N integers,
    //returns the lagest integer K > 0 such that both values K and -K exisit in array A.
    //If there is no such integer, the function should return 0.
    public static int maxInteger(int[] nums) {
        Set<Integer> st = new HashSet<>();
        int res = 0;
        for (int n : nums) {
            st.add(n);
            if (st.contains(-n)) res = Math.max(res, Math.abs(n));
        }
        return res;
    }


    private static int res;
    public static int maxLength(List<String> l) {
        if (l == null || l.size() == 0) return 0;
        res = 0;
        dfs(l, 0, "");
        return res;
    }

    private static void dfs(List<String> l, int idx, String s) {
        if (unique(s)) res = Math.max(res, s.length());
        else return;
        for (int i = idx; i < l.size(); i++) {  // start with idx;
            if (unique(l.get(i))) dfs(l, i + 1, s + l.get(i));
        }
    }

    private static boolean unique(String s) {
        if (s == null) return false;
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            if (++cnt[c - 'a'] > 1) return false;
        }
        return true;
    }

    //Max Inserts to Obtain String Without 3 Consecutive 'a'
    public static int maxInsertAvoid3As(String s) {
        if (s == null || s.length() == 0) return s == null ? 0 : 2;
        int res = 0, cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') cnt++;
            else {
                res += 2 - cnt;
                cnt = 0;
            }
            if (cnt >= 3) return -1;
            if (i == s.length() - 1) res += 2 - cnt;
        }
        return res;
    }

    //Max Possible Value
    public static int maxIntegerByInsert(int N) {
        int flag = N < 0 ? -1 : 1;
        StringBuilder sb = new StringBuilder(String.valueOf(N < 0 ? -N : N));
        int i = 0, len = sb.length();
        for (; i < len; i++) {
            if (flag > 0) {
                if (5 > sb.charAt(i) - '0') {
                    sb.insert(i, 5);
                    break;
                }
            } else {
                if (5 < sb.charAt(i) - '0') {
                    sb.insert(i, 5);
                    break;
                }
            }
            if (i == len - 1) sb.append(5);
        }
        return flag * Integer.parseInt(sb.toString());
    }

    //Day of Week
    public static String daysOfWeek(String today, int k) {
        String[] days = new String[] {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < days.length; i++) {
            map.put(days[i], i);
        }
        return days[(map.get(today) + k) % days.length];
    }

    //Longest Semi-Alternating Substring
    public static int substringLenWo3Cons(String s) {
        String res = "";
        if (s == null || s.length() < 3) return s == null ? 0 : s.length();
        int max = 0, len = 0, consec = 1;
        for (int l = 0, r = 1; r < s.length(); r++) {
            if (s.charAt(r) == s.charAt(r - 1)) {
                consec++;
                if (consec > 2) {
                    if (r - l > max) {
                        max = r - l; // not include r, but ending with r - 1;
                    }
                    consec = 2;
                    l = r - 1;
                }
            } else {
                consec = 1;
            }
        }
        return max;
    }


    // String Without 3 Identical Consecutive Letters
    public static String stringWO3Consec(String s) {
        if (s == null || s.length() < 2) return s;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        int cnt = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) cnt++;
            else {
                cnt = 1;
            }
            if (cnt < 3) sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    //Min Deletions to Make Frequency of Each Letter Unique
    public static int minDeletionMakeLetterUnique(String s) {
        int res = 0;
        if (s == null || s.length() < 2) return 0;
        int[] freq = new int[26];
        Set<Integer> st = new HashSet<>();
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        Arrays.sort(freq);
        for (int n : freq) {
            while (st.contains(n)) {
                n--;
                res++;
            }
            if (n > 0) st.add(n);
        }
        return res;
    }

    //Lexicographically Smallest String
    public static String lexSmallestString(String s) {
        if (s == null || s.length() < 2) return "";
        StringBuilder sb = new StringBuilder(s);
        int i = 1;
        while(i < sb.length()) {
            if (sb.charAt(i - 1) > sb.charAt(i)) break;
            i++;
        }
        return sb.deleteCharAt(i - 1).toString();
    }


    //Longest Substring Without 3 Contiguous Occurrences of Letter
    public static String longestSubstringWo3Cons(String s) {
        String res = "";
        if (s == null || s.length() < 3) return s;
        int start = 0, max = 0, len = 0, consec = 1;
        for (int l = 0, r = 1; r < s.length(); r++) {
            if (s.charAt(r) == s.charAt(r - 1)) {
                consec++;
                if (consec > 2) {
                    if (r - l > max) {
                        max = r - l; // not include r, but ending with r - 1;
                        start = l;
                    }
                    consec = 2;
                    l = r - 1;
                }
            } else {
                consec = 1;
            }
        }
        return s.substring(start, start + max);
    }

    //Min Adj Swaps to Make Palindrome
    public static int minSwapsForPal(String s) {
        int res = 0, l = 0, n = s.length(), r = n - 1, k = r;
        char[] arr = s.toCharArray();
        if (!canBePal(s)) return -1;
        while (l < r) {
            k = r;
            while(k > l && arr[l] != arr[k]) k--;
            if (l != k && arr[l] == arr[k]) {  //must check l != k
                while (k < r) {
                    swap(arr, k, k + 1);
                    k++;
                    res++;
                }
                l++;
                r--;
            } else {
                swap(arr, l, l + 1);
                res++;
            }
        }
        return res;
    }

    private static boolean canBePal(String s) {
        Set<Character> st = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (st.contains(c)) st.remove(c);
            else st.add(c);
        }
        return st.size() < 2;
    }

    private static void swap(char[] arr, int i, int j) {
        if (i == j) return;
        char tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;

    }


    //Max Network Rank
    public static int maxNetworkRank(int[] A, int[] B, int N) {
        int[] cnt = new int[N + 1];
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            cnt[A[i]]++;
            cnt[B[i]]++;
        }
        for (int i = 0; i < A.length; i++) {
            res = Math.max(res, cnt[A[i]] + cnt[B[i]] - 1);
        }
        return res;
    }

    //Numbers With Equal Digit Sum
    public static int numEqualDigitSum(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = -1;    // default to -1;
        for (int a : A) {
            int sum = getSum(a);
            if (map.containsKey(sum)) {
                res = Math.max(map.get(sum) + a, res);
                map.put(sum, Math.max(a, map.get(sum)));
            } else {
                map.put(sum, a);
            }
        }
        return res;
    }

    private static int getSum(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }

    //Min Moves to Obtain String Without 3 Identical Consecutive Letters
    public static int minMovesWithout3Consective(String str) {
        int f = 0, len = 1, res = 0;
        while (f< str.length()){
            if (f + 1 < str.length() && str.charAt(f + 1) == str.charAt(f)) len++;
            else {
                while (len > 5) {
                    len -= 3;
                    res++;
                }
                if (len > 2) res++;
                len = 1;
            }
            f++;
        }
        return res;
    }

    public static void main(String[ ] args) {
        System.out.println("Expect: 93, output: " + numEqualDigitSum(new int[] {51,71,17,42}));  //93
        System.out.println("Expect: 102, output: " + numEqualDigitSum(new int[] {42,33,60}));  //102
        System.out.println("Expect: -1, output: " + numEqualDigitSum(new int[] {51, 32, 43})); // 0

        System.out.println("Expect: 3, output: " + minMovesWithout3Consective("aaabbbcccd")); // 0
        System.out.println("Expect: 2, output: " + minMovesWithout3Consective("baaabbaabbba")); // 0
        System.out.println("Expect: 4, output: " + minMovesWithout3Consective("aaaaaaaaaaaaa")); // 0
        System.out.println("Expect: 0, output: " + minMovesWithout3Consective("")); // 0

        System.out.println("Expect: 4, output: " + maxNetworkRank(new int[]{1,2,3,3}, new int[]{2,3,1,4}, 4));
        System.out.println("Expect: 2, output: " + maxNetworkRank(new int[]{1,2,4,5}, new int[]{2,3,5,6}, 6));

        System.out.println("Expect: 1, output: " + minSwapsForPal("admma"));
        System.out.println("Expect: 3, output: " + minSwapsForPal("adamm"));
        System.out.println("Expect: 4, output: " + minSwapsForPal("daamm"));
        System.out.println("Expect: 1, output: " + minSwapsForPal("admma"));
        System.out.println("Expect: 3, output: " + minSwapsForPal("mamad"));
        System.out.println("Expect: -1, output: " + minSwapsForPal("asflkj"));
        System.out.println("Expect: 2, output: " + minSwapsForPal("aabb"));

        System.out.println("Expect: aabbaabb, output: " + longestSubstringWo3Cons("aaaabbbbbbaaabbaabbbaaaa"));
        System.out.println("Expect: aa, output: " + longestSubstringWo3Cons("aaaa"));
        System.out.println("Expect: a, output: " + longestSubstringWo3Cons("a"));
        System.out.println("Expect: , output: " + longestSubstringWo3Cons(""));
        System.out.println("Expect: , output: " + longestSubstringWo3Cons("null"));

        System.out.println("Expect: abcd, output: " + lexSmallestString("abcde"));
        System.out.println("Expect: abcdab, output: " + lexSmallestString("abcdeab"));

        System.out.println("Expect: 4, output: " + minDeletionMakeLetterUnique("abcdeab"));
        System.out.println("Expect: 10, output: " + minDeletionMakeLetterUnique("abcdeabddfafwert"));
        System.out.println("Expect: 5, output: " + minDeletionMakeLetterUnique("abcdeabfffhhhhhu"));
        System.out.println("Expect: 0, output: " + minDeletionMakeLetterUnique("a"));
        System.out.println("Expect: 0, output: " + minDeletionMakeLetterUnique(null));
        System.out.println("Expect: 0, output: " + minDeletionMakeLetterUnique(""));

        System.out.println("Expect: a, output: " + stringWO3Consec("a"));
        System.out.println("Expect: , output: " + stringWO3Consec(""));
        System.out.println("Expect: null, output: " + stringWO3Consec(null));
        System.out.println("Expect: abcdeabffhhu, output: " + stringWO3Consec("abcdeabfffhhhhhu"));

        System.out.println("Expect: 8, output: " + substringLenWo3Cons("aaaabbbbbbaaabbaabbbaaaa"));
        System.out.println("Expect: 2, output: " + substringLenWo3Cons("aaaa"));
        System.out.println("Expect: 1, output: " + substringLenWo3Cons("a"));
        System.out.println("Expect: 0, output: " + substringLenWo3Cons(""));
        System.out.println("Expect: 0, output: " + substringLenWo3Cons("null"));

        System.out.println("Expect: Sun, output: " + daysOfWeek("Sun", 7));
        System.out.println("Expect: Thu, output: " + daysOfWeek("Fri", 6));
        System.out.println("Expect: Mon, output: " + daysOfWeek("Sat", 100));
        System.out.println("Expect: Mon, output: " + daysOfWeek("Mon", 1400));

        System.out.println("Expect: 51234, output: " + maxIntegerByInsert(1234));
        System.out.println("Expect: 6543, output: " + maxIntegerByInsert(6543));
        System.out.println("Expect: 98765, output: " + maxIntegerByInsert(9876));
        System.out.println("Expect: 51234, output: " + maxIntegerByInsert(1234));
        System.out.println("Expect: 9876, output: " + maxIntegerByInsert(-9876));
        System.out.println("Expect: -12345, output: " + maxIntegerByInsert(-1234));
        System.out.println("Expect: -34556, output: " + maxIntegerByInsert(-3456));
        System.out.println("Expect: 6543, output: " + maxIntegerByInsert(65643));
        System.out.println("Expect: -345656, output: " + maxIntegerByInsert(-34656));
        System.out.println("Expect: 50, output: " + maxIntegerByInsert(0));

        System.out.println("Expect: 9, output: " + maxInsertAvoid3As("abcde"));
        System.out.println("Expect: 1, output: " + maxInsertAvoid3As("a"));
        System.out.println("Expect: 0, output: " + maxInsertAvoid3As("aa"));
        System.out.println("Expect: 2, output: " + maxInsertAvoid3As(""));
        System.out.println("Expect: 2, output: " + maxInsertAvoid3As("aba"));
        System.out.println("Expect: 0, output: " + maxInsertAvoid3As(null));

        System.out.println("Expect: 3, output: " + maxLength(List.of("ab", "b", "c")));
        System.out.println("Expect: 4, output: " + maxLength(List.of("ab", "bc", "cd")));
        System.out.println("Expect: 2, output: " + maxLength(List.of("ad", "bd", "cd")));
        System.out.println("Expect: 0, output: " + maxLength(List.of("")));
        System.out.println("Expect: 0, output: " + maxLength(List.of(null)));
        System.out.println("Expect: 0, output: " + maxLength(null));

        System.out.println("Expect: 3, output: " + maxInteger(new int[]{ 2, 3, 4, 5, -3 }));
        System.out.println("Expect: 0, output: " + maxInteger(new int[]{}));
        System.out.println("Expect: 0, output: " + maxInteger(new int[]{ 3, 2, 1, 5, 6 }));


        System.out.println("Expect: 2, output: " + minAdjSwapRedBalls("WRRWWR"));
        System.out.println("Expect: 4, output: " + minAdjSwapRedBalls("WWRWWWRWR"));
        System.out.println("Expect: 0, output: " + minAdjSwapRedBalls("WWW"));
        System.out.println("Expect: 0, output: " + minAdjSwapRedBalls("RRR"));

        System.out.println("Expect: 0, output: " + Arrays.toString(sumZero(4)));
        System.out.println("Expect: 0, output: " + Arrays.toString(sumZero(3)));
        System.out.println("Expect: 0, output: " + Arrays.toString(sumZero(0)));
        System.out.println("Expect: 0, output: " + Arrays.toString(sumZero(1)));

        System.out.println("Expect: 3, output: " + minDelRightFormat("ABABABAB"));
        System.out.println("Expect: 0, output: " + minDelRightFormat("AAABBB"));
        System.out.println("Expect: 3, output: " + minDelRightFormat("BBBAAA"));
        System.out.println("Expect: 0, output: " + minDelRightFormat(null));
        System.out.println("Expect: 0, output: " + minDelRightFormat(""));

        System.out.println("Expect: 5, output: " + particleVilocity(new int[]{-1,1,3,3,3,2,3,2,1,0}));
        System.out.println("Expect: 8, output: " + particleVilocity(new int[]{-1,1,3,3,3,2,3,2,1,0,-1}));
        System.out.println("Expect: 0, output: " + particleVilocity(new int[]{}));

        System.out.println("Expect: [[1, 1, 1, 1], [1, 1, 1, 1]], output: " + canPartitionKSubsets(new int[]{1,1,1,1,1,1,1,1}, 2));
        System.out.println("Expect: [], output: " + canPartitionKSubsets(new int[]{1,1,1,1,1,1,1}, 2));
        System.out.println("Expect: [], output: " + canPartitionKSubsets(new int[]{1,1,1,1,1,1,1}, 0));

        System.out.println("Expect: [], output: " + jumpGameIII(new int[]{4,2,3,0,3,1,2}, 5));
        System.out.println("Expect: [], output: " + jumpGameIII(new int[]{4,2,3,0,3,1,2}, 0));
        System.out.println("Expect: [], output: " + jumpGameIII(new int[]{3,0,2,1,2}, 2));

        System.out.println("Expect: 2, output: " + numTimesAllShine(new int[]{3,2,4,1,5}));
        System.out.println("Expect: 1, output: " + numTimesAllShine(new int[]{4,1,2,3}));
        System.out.println("Expect: 3, output: " + numTimesAllShine(new int[]{2,1,4,3,6,5}));

        System.out.println("Expect: 2, output: " + minMeetingRooms(new int[][]{{0, 30},{5, 10},{15, 20}}));

        System.out.println("Expect: Codility, output: " + cropWords("Codility Me test coders", 10));

        System.out.println("Expect: 4, output: " + largestMAlignedSubset(new int[]{-3, -2, 1, 0, 8, 7, 1}, 3));
    }