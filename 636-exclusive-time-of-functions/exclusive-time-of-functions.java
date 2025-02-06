class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        // xstart -> ystart: x = ystart - xstart | + push
        // ystart -> yend:   y = yend - xstart + 1
        // xend -> ystart:   stacktop = ystart - xend - 1
        // xend -> yend : stacktop + pop = yend - xend

        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        int[] result = new int[n];

        String[] split = logs.get(0).split(":");
        stack.push(new Pair(Integer.parseInt(split[0]), Integer.parseInt(split[2])));
        for (int i = 1; i < logs.size(); i++) {
            String[] currSplit = logs.get(i).split(":");
            if (currSplit[1].equals("start")) {
                if (!stack.isEmpty()) {
                    String[] prevSplit = logs.get(i-1).split(":");
                    if (prevSplit[1].equals("end")) {
                        result[stack.peek().getKey()] += Integer.parseInt(currSplit[2]) - Integer.parseInt(prevSplit[2]) - 1;
                    } else {
                        result[stack.peek().getKey()] += Integer.parseInt(currSplit[2]) - Integer.parseInt(prevSplit[2]);
                    }
                    // System.out.println("Added to proc" + stack.peek().getKey() + " And result is: " + result[stack.peek().getKey()]);
                }   
                stack.push(new Pair(Integer.parseInt(currSplit[0]), Integer.parseInt(currSplit[2])));
            } else {
                String[] prevSplit = logs.get(i-1).split(":");
                if (prevSplit[1].equals("end")) {
                    Pair<Integer, Integer> topPro = stack.pop();
                    result[topPro.getKey()] += Integer.parseInt(currSplit[2]) - Integer.parseInt(prevSplit[2]);
                    System.out.println("Added to proc" + topPro.getKey() + " And result is: " + result[topPro.getKey()]);
                } else {
                    Pair<Integer, Integer> topPro = stack.pop();
                    result[topPro.getKey()] += Integer.parseInt(currSplit[2]) - topPro.getValue() + 1;
                    System.out.println("Added to proc" + topPro.getKey() + " And result is: " + result[topPro.getKey()]);
                }
            }
        }
        return result;
    }
}