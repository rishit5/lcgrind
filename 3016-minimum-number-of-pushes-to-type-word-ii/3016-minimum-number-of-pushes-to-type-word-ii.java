class Solution {
    public int minimumPushes(String word) {
        Integer[] frequency = new Integer[26];
        Arrays.fill(frequency, 0);
        for (Character c : word.toCharArray()) {
            frequency[c - 'a'] += 1;
        }
        Arrays.sort(frequency, Collections.reverseOrder());
        int result = 0;
        int count = 1;
        int presses = 1;
        for (int i : frequency) {
            if (i == 0) {
                break;
            }
            if (count >= 1 && count <=8) {
                presses = 1;
            } else if (count >= 9 && count <= 16) {
                presses = 2;
            } else if (count >= 17 && count <= 24) {
                presses = 3;
            } else if (count >= 25) {
                presses = 4;
            }
            result += i * presses;
            count++;
        }
        return result;
    }
}