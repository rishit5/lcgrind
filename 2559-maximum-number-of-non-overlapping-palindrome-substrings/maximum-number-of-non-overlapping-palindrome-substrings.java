class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        List<List<Integer>> intervals = new ArrayList<>();
        
        for (int i = 0; i < n * 2; i++) {
            int left = i / 2;
            int right = left + i % 2;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 >= k) {
                    intervals.add(new ArrayList<Integer>(Arrays.asList(left, right + 1)));
                }
                left -= 1;
                right += 1;
            }
        }

        int last = Integer.MIN_VALUE;
        int ans = 0;

        for (List<Integer> inter : intervals) {
            if (inter.get(0) >= last) {
                last = inter.get(1);
                ans += 1;
            } else {
                if (inter.get(1) < last) {
                    last = inter.get(1);
                }
            }
        }
        return ans;
    }
}