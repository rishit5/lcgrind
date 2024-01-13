class Solution {
    public int minSteps(String s, String t) {
        int[] counts = new int[27];
        for (char c : s.toCharArray()) {
            counts[c - 96] += 1;
        }
        int extras = 0;
        for (char c : t.toCharArray()) {
            if (counts[c - 96] > 0) {
                counts[c - 96] -= 1;
            } else {
                extras++;
            }
        }
        return extras;
    }
}