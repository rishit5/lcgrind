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
    private TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root;
        }
        if (root.left.left == null) {
            root.left.left = root.right;
            root.left.right = root;
            TreeNode temp = root.left;
            root.left = null;
            root.right = null;
            return temp;
        } else {
            TreeNode newLeft = dfs(root.left);
            root.left.left = root.right;
            root.left.right = root;
            root.right = null;
            root.left = null;
            return newLeft;
        }
    }
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        return dfs(root);
    }
}