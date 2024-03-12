class Solution {
    HashSet<List<Integer>> res = new HashSet<>();
    int[] candidates; 
    int target;

    public void subset(int i, int sumSoFar, List<Integer> path) {
        if (sumSoFar == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (i >= candidates.length || sumSoFar > target) {
            return;
        }

        path.add(candidates[i]);
        subset(i, sumSoFar + candidates[i], path);
        path.remove(path.size() - 1);

        subset(i + 1, sumSoFar, path);
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        this.target = target;
        this.candidates = candidates;

        subset(0, 0, path);
        return new ArrayList<>(res);
    }
}