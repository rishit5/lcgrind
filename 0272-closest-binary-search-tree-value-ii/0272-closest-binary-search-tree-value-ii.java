/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    LinkedList<Integer> inOrder;
    Double minDiff;
    Integer index;

    private void inOrderTrav(TreeNode root, double target) {
        if (root == null) {
            return;
        }
        this.inOrderTrav(root.left, target);
        this.inOrder.addLast(root.val);
        if (Math.abs((double) root.val - target) < minDiff) {
            this.minDiff = Math.abs(root.val - target);
            this.index = this.inOrder.size() - 1;
        }
        this.inOrderTrav(root.right, target);
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        this.inOrder = new LinkedList<>();
        this.minDiff = Double.MAX_VALUE;
        this.index = -1;
        this.inOrderTrav(root, target);
        int currLeft = this.index - 1; 
        int currRight = this.index + 1;
        List<Integer> result = new LinkedList<>();
        result.addLast(this.inOrder.get(this.index));
        // System.out.println(this.inOrder);
        // System.out.println(this.index);
        k -= 1;
        while (k > 0) {
            if (currLeft >= 0 && currRight < this.inOrder.size()) {
                if (Math.abs(inOrder.get(currLeft) - target) < Math.abs(inOrder.get(currRight) - target)) {
                    result.addLast(this.inOrder.get(currLeft));
                    currLeft -= 1;
                } else {
                    result.addLast(this.inOrder.get(currRight));
                    currRight += 1;
                }
            } else if (currLeft >= 0) {
                result.addLast(this.inOrder.get(currLeft));
                currLeft -= 1;
            } else {
                result.addLast(this.inOrder.get(currRight));
                currRight += 1;
            }
            k -= 1;
        }
        return result;
    }
}