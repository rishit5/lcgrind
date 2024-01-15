class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> result = new LinkedList<>();
        
        Set<Integer> players = new HashSet<>();   
        Set<Integer> loserSet = new HashSet<>();
        Set<Integer> morethanOnce = new HashSet<>();
        
        for (int i = 0; i < matches.length; i++) {
            players.add(matches[i][0]);
            players.add(matches[i][1]);
            if (morethanOnce.contains(matches[i][1])) {
        
            } else if (loserSet.contains(matches[i][1])) {
                morethanOnce.add(matches[i][1]);
                loserSet.remove(matches[i][1]);
            } else {
                loserSet.add(matches[i][1]);
            }
        }
        for (int i = 0; i < matches.length; i++) {
            if (players.contains(matches[i][1])) {
                players.remove(matches[i][1]);
            }
        }
        System.out.println("Loser set is " + loserSet);
        List<Integer> list_1 = new LinkedList<>(players);
        Collections.sort(list_1);
        result.add(list_1);
        
        List<Integer> list_2 = new LinkedList<>(loserSet);
        Collections.sort(list_2);
        result.add(list_2);
        
        return result;
    }
}