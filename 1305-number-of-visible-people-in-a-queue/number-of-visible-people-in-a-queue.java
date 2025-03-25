class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] < heights[i]) {
                int index = stack.pop();
                result[index] += 1;
            }
            if (!stack.isEmpty()) {
                result[stack.peek()] += 1;
            }
            stack.push(i);
        }
        return result;
    }
}