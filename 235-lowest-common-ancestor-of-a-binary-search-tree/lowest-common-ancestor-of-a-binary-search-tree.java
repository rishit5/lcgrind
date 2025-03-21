/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    
    private TreeNode lca(TreeNode root, int small, int large) {
        if (root == null) {
            return null;
        }
        if (root.val == small) {
            return root;
        } else if (root.val == large) {
            return root;
        } else if (root.val > small && root.val < large) {
            return root;
        } else {
            TreeNode left = lca(root.left, small, large);
            TreeNode right = lca(root.right, small, large);
            if (left != null) {
                return left;
            }
            if (right != null) {
                return right;
            }
            return null;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int large = p.val > q.val ? p.val : q.val;
        int small = p.val < q.val ? p.val : q.val;
        return lca(root, small, large);
    }
}