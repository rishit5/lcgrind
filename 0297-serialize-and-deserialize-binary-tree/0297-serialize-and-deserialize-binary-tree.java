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

    private String rSerialize(TreeNode root, String str) {
        if (root == null) {
            return str + "null,";
        } else {
            str += root.val + ",";
            String lstr = rSerialize(root.left, str);
            String rstr = rSerialize(root.right, lstr);
            return rstr;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String rString = rSerialize(root, "");
        System.out.println(rString);
        return rString;
    }

    private int idx = 0;

    private TreeNode build(String[] values) {
        if (idx > values.length) {
            return null;
        }
        if (values[idx].equals("null")) {
            idx += 1;
            return null;
        } else {
            TreeNode treeNode = new TreeNode();
            treeNode.val = Integer.parseInt(values[idx]);
            idx += 1;
            treeNode.left = build(values);
            treeNode.right = build(values);
            return treeNode;
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        return build(values);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));