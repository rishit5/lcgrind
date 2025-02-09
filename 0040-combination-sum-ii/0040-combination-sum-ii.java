class Solution {
    private List<List<Integer>> result;

    private void backTrack(int[] candidates, int target, int curr, int currSum, LinkedList<Integer> currRes) {
        if (currSum > target) {
            return;
        }
        if (currSum == target) {
            this.result.add(new LinkedList<>(currRes));
            return;
        }
        for (int i = curr; i < candidates.length; i++) {
            if (i > curr && candidates[i] == candidates[i-1]) {
                continue;
            }
            currRes.addLast(candidates[i]);
            this.backTrack(candidates, target, i+1, currSum + candidates[i], currRes);
            currRes.removeLast();
        }
    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.result = new LinkedList<>();
        Arrays.sort(candidates);
        this.backTrack(candidates, target, 0, 0, new LinkedList<>());
        return this.result;
    }
}