class CountIntervals {

    private TreeMap<Integer, Integer> treeMap;
    private int totalCount = 0;

    public CountIntervals() {
        this.treeMap = new TreeMap<>();
    }
    
    public void add(int left, int right) {
        Map.Entry<Integer, Integer> entry = this.treeMap.floorEntry(right);
        while (entry != null &&  entry.getValue() >= left) {
            int existingLeft = entry.getKey();
            int existingRight = entry.getValue();

            left = Math.min(existingLeft, left);
            right = Math.max(existingRight, right);

            totalCount -= existingRight - existingLeft + 1;

            this.treeMap.remove(existingLeft);

            entry = this.treeMap.floorEntry(right);
        }
        this.treeMap.put(left, right);
        totalCount += right - left + 1;
    }
    
    public int count() {
        return totalCount;
    }
}

/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */