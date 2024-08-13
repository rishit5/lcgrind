class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        Map<String, int[]> myMap = new HashMap<>();
        
        myMap.put("UP",    new int[] {-1, 0});
        myMap.put("DOWN",  new int[] {1,  0});
        myMap.put("LEFT",  new int[] {0, -1});
        myMap.put("RIGHT", new int[] {0,  1});
        
        int i = 0;
        int j = 0;
        
        for (String command : commands) {
            int[] moves = myMap.get(command);
            i += moves[0];
            j += moves[1];
        }
        
        return (i * n) + j;
    }
}