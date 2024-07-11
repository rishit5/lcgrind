class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                Queue<Character> reverse = new LinkedList<>();
                while (!stack.isEmpty() && stack.peek() != '(') {
                    reverse.add(stack.pop());
                }
                if (stack.peek() == '(') {
                    stack.pop();
                }
                while (!reverse.isEmpty()) {
                    stack.push(reverse.remove());
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        System.out.println(stack);
        boolean reverse = false;
        if (stack.peek() == ')') {
            reverse = true;
        }
        String result = "";
        while (!stack.isEmpty()) {
            if (stack.peek() == '(' || stack.peek() == ')') {
                stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
            }
            if (reverse) {
                result = result + stack.pop();
            } else {
                result = stack.pop() + result;
            }
        }
        return result;
    }
}