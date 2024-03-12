class Solution {
    List<List<Integer>> result = new LinkedList<>();
    
    public void calculate(int[] candidates, int target, List<Integer> path) {
        if (target == 0) {
            Collections.sort(path);
            if (!result.contains(path)) {
                result.add(new LinkedList<>(path));
            }
            return;
        } else if (target < 0) {
            return;
        } else {
            for (int i = 0; i < candidates.length; i++) {
                List<Integer> newPath = new LinkedList<>(path);
                newPath.add(candidates[i]);
                calculate(candidates, target - candidates[i], newPath);
            }
        }
        
        
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        calculate(candidates, target, new LinkedList<>());  
        return result;
    }
}