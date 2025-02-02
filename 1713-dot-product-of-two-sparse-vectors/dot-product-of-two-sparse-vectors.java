class SparseVector {

    public Map<Integer, Integer> myMap;
    
    SparseVector(int[] nums) {
        this.myMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                this.myMap.put(i, nums[i]);
            }
        }
        
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        Map<Integer, Integer> otherMap = vec.myMap;
        int result = 0;
        for (Integer i : otherMap.keySet()) {
            if (myMap.containsKey(i)) {
                result += myMap.get(i) * otherMap.get(i);
            }
        }
        return result;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);