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
    private int[] helper(TreeNode root) {
        if (root == null) {
            return new int[] {0, 0};
        }
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int robVal = root.val + left[1] + right[1];
        int doNotrobVal = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[] {robVal, doNotrobVal};
    }
    public int rob(TreeNode root) {
        int[] result = helper(root);
        // result[0] - include root
        // result[1] - do not include root
        return Math.max(result[0], result[1]);
    }
}