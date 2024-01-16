class RandomizedSet {
    List<Integer> randList;
    Map<Integer, Integer> randMap;
    Random rand;

    public RandomizedSet() {
        randList = new LinkedList<>();
        randMap = new HashMap<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if (randMap.containsKey(val)) {
            return false;    
        }
        randList.add(val);
        randMap.put(val, randList.size() - 1);
        return true;
    }
    
    public boolean remove(int val) {
        if (randMap.containsKey(val)) {
            randList.remove(randMap.get(val));
            randMap.remove(val);
            return true;    
        }
        return false;
    }
    
    public int getRandom() {
        return randList.get(rand.nextInt(randList.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */