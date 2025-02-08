class NumberContainers {

    Map<Integer, Integer> indexMap;
    Map<Integer, TreeSet<Integer>> numMap;

    public NumberContainers() {
        this.indexMap = new HashMap<>();
        this.numMap = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if (indexMap.containsKey(index)) {
            int num = indexMap.get(index);
            numMap.get(num).remove(index);
        }
        indexMap.put(index, number);
        numMap.putIfAbsent(number, new TreeSet<>());
        numMap.get(number).add(index);
    }
    
    public int find(int number) {
        if (numMap.containsKey(number) == false || numMap.get(number).size() == 0) {
            return -1;
        }
        return numMap.get(number).first();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */