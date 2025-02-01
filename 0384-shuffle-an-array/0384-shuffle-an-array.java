class Solution {

    private int[] original;
    private int[] copy;

    public Solution(int[] nums) {
        this.original = new int[nums.length];
        this.copy = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            this.original[i] = nums[i];
            this.copy[i] = nums[i];
        }
    }

    private int[] shuffle(int i, int[] copy) {
        if (i == copy.length) {
            return copy;
        } else {
            Random rand = new Random();
            Double probability = rand.nextDouble();
            int j = (int) Math.round((copy.length - 1) * probability);
            int temp = copy[j];
            copy[j] = copy[i];
            copy[i] = temp;
            return this.shuffle(i+1, copy);
        }
    }
    
    public int[] reset() {
        return this.original;
    }
    
    public int[] shuffle() {
        return this.shuffle(0, this.copy);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */