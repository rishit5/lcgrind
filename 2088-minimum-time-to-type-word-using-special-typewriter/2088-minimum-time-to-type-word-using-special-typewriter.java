class Solution {
    
    private int countClockWise(int from, int to) {
        if (to >= from) {
            return to - from;
        } else {
            return (26 - from) + to;
        }
    }

    private int countAntiClockWise(int from, int to) {
        if (to <= from) {
            return from - to;
        } else {
            return (26 - to) + from;
        }
    }

    public int minTimeToType(String word) {
        int currentPosition = 0;
        int result = 0;
        for (int i = 0; i < word.length(); i++) {
            int clockWise = this.countClockWise(currentPosition, word.charAt(i) - 'a');
            int antiClockWise = this.countAntiClockWise(currentPosition, word.charAt(i) - 'a');
            result += Math.min(clockWise, antiClockWise) + 1;
            currentPosition = word.charAt(i) - 'a';
        }
        return result;
    }
}