class Solution {
    public int minOperations(String[] logs) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < logs.length; i++) {
            if (logs[i].equals("./")) {
                continue;
            } else if (logs[i].equals("../")) {
                if (!stack.isEmpty()) {
                    stack.pop();   
                }
            } else {
                stack.push(1);
            }
        }
        return stack.size();
    }
}