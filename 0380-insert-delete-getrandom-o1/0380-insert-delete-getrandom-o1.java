class RandomizedSet {
    Set<Integer> randSet;

    public RandomizedSet() {
        randSet = new HashSet<>();
    }
    
    public boolean insert(int val) {
        if (randSet.contains(val)) {
            return false;    
        }
        randSet.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (randSet.contains(val)) {
            randSet.remove(val);
            return true;    
        }
        return false;
    }
    
    public int getRandom() {
        Random rand = new Random();
        int index = rand.nextInt(randSet.size());
        List<Integer> list = new LinkedList<>(randSet);
        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */