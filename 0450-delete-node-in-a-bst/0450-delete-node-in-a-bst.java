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
                TreeNode successor = root.right;
                while (successor.left != null) {
                    successor = successor.left;
                }
                Integer value = successor.val;
                root.val = value;
                root.right = deleteNodeFrom(root.right, value);
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