class Solution {
    public int bulbSwitch(int n) {
        long nLong = n;
        int count = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            long res = (long) i * (long) i;
            if (res <= nLong) {
                count += 1;
            } else {
                break;
            }
        }
        return count;
    }
}