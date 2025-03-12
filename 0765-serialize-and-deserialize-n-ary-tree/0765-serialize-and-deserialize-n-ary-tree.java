/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

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

    private String rSerialize(Node root, String str) {
        if (root == null) {
            return str + "null,";
        } else {
            str += root.val + ":" + root.children.size() + ",";
            for (Node n : root.children) {
                str = rSerialize(n, str);
            } 
            return str;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        String rString = rSerialize(root, "");
        // System.out.println(rString);
        return rString;
    }

    private int idx = 0;

    private Node build(String[] values) {
        if (idx > values.length) {
            return null;
        }
        if (values[idx].equals("null")) {
            idx += 1;
            return null;
        } else {
            Node treeNode = new Node();
            String[] vals = values[idx].split(":");
            treeNode.val = Integer.parseInt(vals[0]);
            int childern = Integer.parseInt(vals[1]);
            idx += 1;
            List<Node> childernNodes = new ArrayList<>();
            for (int i = 0; i < childern; i ++) {
                childernNodes.add(build(values));
            }
            treeNode.children = childernNodes;
            return treeNode;
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        String[] values = data.split(",");
        return build(values);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));