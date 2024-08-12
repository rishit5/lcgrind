class KthLargest {
    
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>((a, b) -> {
            if (a < b) {
                return -1;
            } else {
                return 1;
            }
        });
        
        for (int num : nums) {
            this.pq.add(num);
        }
        
        while (this.pq.size() > k) {
            this.pq.poll();
        }
        
        
    }
    
    public int add(int val) {
        this.pq.add(val);
        
        while (this.pq.size() > this.k) {
            this.pq.poll();
        }
        
        return this.pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */