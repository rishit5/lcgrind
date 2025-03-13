class Solution {
    
    private ArrayList<String> answer;
    private String digits;
    private int target;

    private void recurse(
        int idx, 
        long previousOperand, 
        long currentOperand, 
        long value, 
        List<String> ops) {
        
        if (idx == this.digits.length()) {
            if (value == this.target && currentOperand == 0) {
                StringBuilder sb = new StringBuilder();
                ops.subList(1, ops.size()).forEach(v -> sb.append(v));
                this.answer.add(sb.toString());
            }
            return;
        }

        currentOperand = currentOperand * 10 + Character.getNumericValue(this.digits.charAt(idx));
        String currentVal = Long.toString(currentOperand);

        // No OP
        if (currentOperand > 0) {
            this.recurse(idx + 1, previousOperand, currentOperand, value, ops);
        }

        // Addition
        ops.add("+");
        ops.add(currentVal);
        this.recurse(idx + 1, currentOperand, 0, value + currentOperand, ops);
        ops.remove(ops.size() - 1);
        ops.remove(ops.size() - 1);

        // Subtraction
        if (ops.size() > 0) {
            ops.add("-");
            ops.add(currentVal);
            this.recurse(idx + 1, -currentOperand, 0, value - currentOperand, ops);
            ops.remove(ops.size() - 1);
            ops.remove(ops.size() - 1);

            // Multiplication
            ops.add("*");
            ops.add(currentVal);
            this.recurse(idx + 1, currentOperand * previousOperand, 0, value - previousOperand + (currentOperand * previousOperand), ops);
            ops.remove(ops.size() - 1);
            ops.remove(ops.size() - 1);
        }
    } 

    public List<String> addOperators(String num, int target) {
        this.answer = new ArrayList<>();
        this.digits = num;
        this.target = target;
        recurse(0, 0, 0, 0, new ArrayList<>());
        return this.answer;
    }
}