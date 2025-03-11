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
    private TreeNode deleteNodeFrom(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.right == null && root.left == null) {
                return null;
            } else {
                if (root.right == null) {
                    return root.left;
                }
                if (root.left == null) {
                    return root.right;
                }
                TreeNode successor = root.right;
                while (successor != null) {
                    root.val = successor.val;
                    successor = successor.left;
                }
                root.right = deleteNodeFrom(root.right, root.val);
                return root;
            }
        } else {
            root.right = deleteNodeFrom(root.right, key);
            root.left = deleteNodeFrom(root.left, key);
            return root;
        }
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        return deleteNodeFrom(root, key);
    }
}