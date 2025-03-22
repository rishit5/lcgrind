/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    private String serialized = ""; 

    private void rSerialize(TreeNode root) {
        if (root == null) {
            this.serialized += "null,";
            return;
        }
        this.serialized += "" + root.val + ",";
        this.rSerialize(root.left);
        this.rSerialize(root.right);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        this.serialized = "";
        this.rSerialize(root);
        return this.serialized;
    }

    private int counter;

    private TreeNode rDeserialize(String[] splitData) {
        if (splitData[this.counter].equals("null")) {
            this.counter += 1;
            return null;
        } else {
            Integer curr = Integer.parseInt(splitData[this.counter]);
            this.counter += 1;
            TreeNode currNode = new TreeNode(curr);
            currNode.left = rDeserialize(splitData);
            currNode.right = rDeserialize(splitData);
            return currNode;
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] splitData = data.substring(0, data.length() - 1).split(",");
        this.counter = 0;
        return rDeserialize(splitData);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));