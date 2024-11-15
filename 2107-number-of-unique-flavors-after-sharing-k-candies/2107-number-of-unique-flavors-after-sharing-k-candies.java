class Solution {
    public int shareCandies(int[] candies, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i = 0; i < candies.length; i++) {
            counter.put(candies[i], counter.getOrDefault(candies[i], 0) + 1);
        }
        for (int i = 0; i < k; i++) {
            counter.put(candies[i], counter.get(candies[i]) - 1);
            if (counter.get(candies[i]) == 0) {
                counter.remove(candies[i]);
            }
        }
        int res = counter.keySet().size();
        int j = 0;
        for (int i = k; i < candies.length; i++) {
            counter.put(candies[j], counter.getOrDefault(candies[j], 0) + 1);
            j++;
            counter.put(candies[i], counter.get(candies[i]) - 1);
            if (counter.get(candies[i]) == 0) {
                counter.remove(candies[i]);
            }
            if (counter.keySet().size() > res) {
                res = counter.keySet().size();
            }
        }
        return res;
    }
}