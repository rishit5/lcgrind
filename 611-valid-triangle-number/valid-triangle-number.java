class Solution {
    private int binarySearch(int target, int start, int end, int[] nums) {
        if (start > end) {
            return -1;
        }
        int mid = start + ((end - start) / 2);
        if (mid == nums.length - 1 && nums[mid] < target) {
            return mid;
        }
        if (nums[mid] < target && nums[mid+1] >= target) {
            return mid;
        } else if (nums[mid] >= target) {
            return binarySearch(target, start, mid-1, nums);
        } else {
            return binarySearch(target, mid+1, end, nums);
        }
    }
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        Map<String, Integer> visited = new HashMap<>();
        int result = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                // if (visited.containsKey("" + i + "_" + j)) {
                //     result += visited.get("" + i + "_" + j);
                // }
                int currResult = 0;
                int finalIndex = this.binarySearch(nums[i]+nums[j], j+1, nums.length - 1, nums);
                if (finalIndex != -1) {
                    currResult = finalIndex - j;
                }
                // System.out.println("For: " + nums[i] + " " + nums[j] + " the ans is: " + currResult);
                result += currResult; 
                // visited.put("" + i + "_" + j, currResult);
            }
        }
        return result;
    }
}