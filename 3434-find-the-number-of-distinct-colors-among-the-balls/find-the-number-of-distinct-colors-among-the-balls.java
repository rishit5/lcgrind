class Solution {
    
    Map<Integer, Integer> colourFreqMap = new HashMap<>();
    Map<Integer, Integer> colourMap = new HashMap<>();

    public int[] queryResults(int limit, int[][] queries) {
        int[] result  = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (colourMap.containsKey(queries[i][0])) {
                int prevColour = colourMap.get(queries[i][0]);
                colourFreqMap.put(prevColour, colourFreqMap.get(prevColour) - 1);
                if (colourFreqMap.get(prevColour) == 0) {
                    colourFreqMap.remove(prevColour);
                }
            }
            colourMap.put(queries[i][0], queries[i][1]);
            colourFreqMap.putIfAbsent(queries[i][1], 0);
            colourFreqMap.put(queries[i][1], colourFreqMap.get(queries[i][1]) + 1);
            result[i] = colourFreqMap.size();
        }
        return result;
    }
}