class Solution {
    private List<List<Integer>> result;

    private void backTrack(int[] candidates, int target, int curr, int sum, LinkedList<Integer> currRes) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new LinkedList<>(currRes));
            return;
        }
        currRes.addLast(candidates[curr]);
        backTrack(candidates, target, curr, sum + candidates[curr], currRes);
        currRes.removeLast();
        if (curr < candidates.length - 1) {
            backTrack(candidates, target, curr+1, sum, currRes);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.result = new LinkedList<>();
        this.backTrack(candidates, target, 0, 0, new LinkedList<>());
        return this.result;
    }
}