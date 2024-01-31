class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        result[temperatures.length-1] = 0;
        stack.push(new Pair(temperatures[temperatures.length-1], temperatures.length-1));
        for (int i = temperatures.length - 2; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek().getKey() <= temperatures[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                stack.push(new Pair(temperatures[i], i));
                result[i] = 0;
            } else {
                result[i] = stack.peek().getValue() - i;
                stack.push(new Pair(temperatures[i], i));
            }
        }
        return result;
    }
}