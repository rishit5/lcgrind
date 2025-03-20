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
class BSTIterator {

    List<Integer> inorderList;
    Integer currentCounter;

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        } else {
            inOrder(root.left);
            inorderList.add(root.val);
            inOrder(root.right);
        }
    }

    public BSTIterator(TreeNode root) {
        this.inorderList = new ArrayList<>();
        this.currentCounter = 0;
        this.inOrder(root);

    }
    
    public int next() {
        Integer next = this.inorderList.get(this.currentCounter);
        this.currentCounter += 1;
        return next;
    }
    
    public boolean hasNext() {
        return this.currentCounter != this.inorderList.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */