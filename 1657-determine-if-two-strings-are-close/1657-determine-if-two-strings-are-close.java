class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>((a, b) -> a - b);
        PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>((a, b) -> a - b);
        
        int[] countArr1 = new int[26];
        int[] countArr2 = new int[26];
        
        for (int i = 0; i < word1.length(); i++) {
            countArr1[word1.charAt(i) - 97]++;
            countArr2[word2.charAt(i) - 97]++;
        }
        
        for (int i = 0; i < 26; i++) {
            if ((countArr1[i] == 0 && countArr2[i] != 0) || (countArr1[i] != 0 && countArr2[i] == 0)) {
                return false;
            }
            pq1.add(countArr1[i]);
            pq2.add(countArr2[i]);
        }
        
        while (!pq1.isEmpty()) {
            Integer pq1Remove = pq1.poll();
            Integer pq2Remove = pq2.poll();
            if (!pq1Remove.equals(pq2Remove)) {
                return false;
            }
        }
        
        return true;
    }
}