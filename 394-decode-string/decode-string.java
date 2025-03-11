class Solution {
    public String decodeString(String s) {
        Stack<Character> myStack = new Stack<>();
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                String toRepeat = "";
                while (myStack.peek() != '[') {
                    toRepeat = myStack.pop() + toRepeat;
                }
                myStack.pop();
                String times = "";
                while (!myStack.isEmpty() && myStack.peek() >= '0' && myStack.peek() <= '9') {
                    times = myStack.pop() + times;
                }
                Integer num = Integer.parseInt(times);
                for (int j = 0; j < num; j++) {
                    for (int k = 0; k < toRepeat.length(); k++) {
                        myStack.push(toRepeat.charAt(k));
                    }
                }
            } else {
                myStack.push(s.charAt(i));
            }
        }
        while (!myStack.isEmpty()) {
            result = myStack.pop() + result;
        }
        return result;
    }
}