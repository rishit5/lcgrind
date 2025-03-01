class TwoSum {

    private HashMap<Integer, Integer> treeMap;

    public TwoSum() {
        this.treeMap = new HashMap<>();
    }
    
    public void add(int number) {
        this.treeMap.putIfAbsent(number, 0);
        this.treeMap.put(number, treeMap.get(number) + 1);
    }
    
    public boolean find(int value) {
        for (Integer key : this.treeMap.keySet()) {
            this.treeMap.put(key, this.treeMap.get(key) - 1);
            if (this.treeMap.containsKey(value - key) && this.treeMap.get(value - key) > 0) {
                this.treeMap.put(key, this.treeMap.get(key) + 1);
                return true;
            }
            this.treeMap.put(key, this.treeMap.get(key) + 1);
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */