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
    private long min = Long.MAX_VALUE;
    private long result = Long.MAX_VALUE;
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        } else {
            if (root.val > min && root.val < result) {
                result = root.val;
            }
            if (root.val == min) {
                this.dfs(root.left);
                this.dfs(root.right);
            }
        }
    }
    public int findSecondMinimumValue(TreeNode root) {
        min = root.val;
        this.dfs(root);
        return result < Long.MAX_VALUE ? (int) result : -1;
    }
}