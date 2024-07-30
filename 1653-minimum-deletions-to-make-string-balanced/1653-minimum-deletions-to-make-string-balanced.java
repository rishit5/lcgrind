class Solution {
    public int minimumDeletions(String s) {
        int[][] counts_back = new int[s.length()][2];
        int[][] counts = new int[s.length()][2];
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                if (s.charAt(i) == 'a') {
                    counts[i][0] = 1;
                }
                if (s.charAt(i) == 'b') {
                    counts[i][1] = 1;
                }  
            } else {
                if (s.charAt(i) == 'a') {
                    counts[i][0] = counts[i-1][0] + 1;
                    counts[i][1] = counts[i-1][1];
                }
                if (s.charAt(i) == 'b') {
                    counts[i][1] = counts[i-1][1] + 1;
                    counts[i][0] = counts[i-1][0];
                }   
            }
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            if (i == s.length() - 1) {
                if (s.charAt(i) == 'a') {
                    counts_back[i][0] = 1;
                }
                if (s.charAt(i) == 'b') {
                    counts_back[i][1] = 1;
                }  
            } else {
                if (s.charAt(i) == 'a') {
                    counts_back[i][0] = counts_back[i+1][0] + 1;
                    counts_back[i][1] = counts_back[i+1][1];
                }
                if (s.charAt(i) == 'b') {
                    counts_back[i][1] = counts_back[i+1][1] + 1;
                    counts_back[i][0] = counts_back[i+1][0];
                }   
            }
        }
        int max = -1;
        for (int i = 0; i < s.length(); i++) {
            max = Math.max(counts[i][0] + counts_back[i][1], max);  
        }
        return s.length() - max;
    }
}