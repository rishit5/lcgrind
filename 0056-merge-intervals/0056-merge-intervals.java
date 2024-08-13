class Solution {
    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] < b[0]) {
                return -1;
            } else if (a[0] > b[0]) {
                return 1;
            } else {
                if (a[1] < b[1]) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        
        for (int[] interval : intervals) {
            pq.add(interval);
        }
        
        List<int[]> resultList = new LinkedList<>();
        
        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            if (pq.isEmpty()) {
                resultList.add(first);
                break;
            } else {
                int[] second = pq.poll();
                if (second[0] >= first[0] && second[0] <= first[1]) {
                    int[] toBePushed = {first[0], Math.max(second[1], first[1])};
                    pq.add(toBePushed);
                } else {
                    resultList.add(first);
                    pq.add(second);
                }
            }
        }
        
        int[][] result = new int[resultList.size()][2];
        int i = 0;
        for (int[] results : resultList) {
            result[i++] = results;
        }
        
        return result;
        
    }
}