class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, List<int[]>> pairs = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                pairs.putIfAbsent(nums[i] * nums[j], new LinkedList<>());
                pairs.get(nums[i] * nums[j]).add(new int[]{nums[i], nums[j]});
            }
        }
        int result = 0;
        for (Integer n : pairs.keySet()) {
            if (pairs.get(n).size() >= 2) {
                int totalPairs = (pairs.get(n).size() * (pairs.get(n).size() - 1)) / 2;
                result += (totalPairs * 8);
            }
        }
        // System.out.println(pairs);
        return result;
    }
}