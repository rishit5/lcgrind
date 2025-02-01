/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        // if (p.parent == null) {
        //     return p;
        // }
        // if (q.parent == null) {
        //     return q;
        // }
        Set<Node> mySet = new HashSet<>();
        Node copyP = p;
        while (copyP != null) {
            if (copyP.val == q.val) {
                return copyP;
            }
            mySet.add(copyP);
            copyP = copyP.parent;
        }
        Node copyQ = q;
        while (copyQ != null) {
            if (copyQ.val == p.val) {
                return copyQ;
            }
            if (mySet.contains(copyQ)) {
                return copyQ;
            }
            mySet.add(copyP);
            copyQ = copyQ.parent;
        }
        return null;
    }
}