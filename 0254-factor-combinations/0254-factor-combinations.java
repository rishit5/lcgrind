class Solution {
    private List<List<Integer>> result;

    private void breakDown(LinkedList<Integer> currList) {
        if (currList.size() > 1) {
            this.result.add(new LinkedList<>(currList));
        }
        int lastElement = currList.removeLast();
        for (int i = currList.size() == 0 ? 2 : currList.peekLast(); i <= lastElement / i; i++) {
            if (lastElement % i == 0) {
                currList.addLast(i);
                currList.addLast(lastElement / i);
                this.breakDown(currList);
                currList.removeLast();
                currList.removeLast();
            }
        }
        currList.addLast(lastElement);
    }

    public List<List<Integer>> getFactors(int n) {
        this.result = new LinkedList<>();
        this.breakDown(new LinkedList<Integer>(Arrays.asList(n)));  
        return this.result;  
    }
}