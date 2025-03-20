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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return new ArrayList<>();
        }

        queue.offer(root);

        while (!queue.isEmpty()) {
            int currentLength = queue.size();

            for (int i = 0; i < currentLength; i++) {
                TreeNode currentNode = queue.poll();


                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (i == 0) {
                    result.add(currentNode.val);
                }
            }
        }

        return result;
    }
}