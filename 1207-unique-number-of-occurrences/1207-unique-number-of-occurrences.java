class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> myMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            myMap.putIfAbsent(arr[i], 0);
            myMap.put(arr[i], myMap.get(arr[i])+1);
        }
        Set<Integer> counts = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : myMap.entrySet()) {
            if (counts.contains(entry.getValue())) {
                return false;
            } else {
                counts.add(entry.getValue());
            }
        }
        return true;
    }
}