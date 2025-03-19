class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushed.length; i++) {
            if (stack.isEmpty()) {
                stack.push(pushed[i]);
            } else {
                if (stack.peek() == popped[j]) {
                    while (!stack.isEmpty() && stack.peek() == popped[j]) {
                        stack.pop();
                        j += 1;
                    }
                }
                stack.push(pushed[i]);
            }
        }
        while (!stack.isEmpty() && stack.peek() == popped[j]) {
            stack.pop();
            j += 1;
        }
        System.out.println(j);
        if (j == popped.length) {
            return true;
        } else {
            return false;
        }
    }
}