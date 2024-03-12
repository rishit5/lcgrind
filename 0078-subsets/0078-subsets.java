class Solution {
    List<List<Integer>> results = new LinkedList<>();
    
    public void function(int[] nums, int index, List<Integer> path) {
        if (index == nums.length) {
            results.add(new LinkedList<>(path));
            return;
        }
        List<Integer> newPath = new LinkedList<>(path);
        newPath.add(nums[index]);
        function(nums, index+1, newPath);
        function(nums, index+1, path);
    }
    
    
    public List<List<Integer>> subsets(int[] nums) {
        function(nums, 0, new LinkedList<>());
        return results;    
    }
}