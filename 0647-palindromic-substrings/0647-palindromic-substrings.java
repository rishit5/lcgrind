class Solution {
    public int countSubstrings(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans += expandAroundCorners(s, i, i);
            ans += expandAroundCorners(s, i, i+1);
        }
        return ans;
    }
    
    private int expandAroundCorners(String s, int lo, int high) {
        int ans = 0;
        
        while (lo >= 0 && high < s.length()) {
            if (s.charAt(lo) != s.charAt(high)) break;
            lo--;
            high++;
            ans++;
        }
        
        return ans;
    }
}