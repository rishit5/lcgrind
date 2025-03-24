/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    
    private Node dfs(Node head) {
        if (head == null) {
            return null;
        }
        Node tempNode = head;
        Node returnedNode = head;
        while (tempNode != null) {
            returnedNode = tempNode;
            Node lastNode = dfs(tempNode.child);
            if (lastNode == null) {
                tempNode = tempNode.next;
            } else {
                Node tempNextNode = tempNode.next;
                tempNode.next = tempNode.child;
                tempNode.child.prev = tempNode;
                if (tempNextNode != null) {
                    tempNextNode.prev = lastNode;
                    lastNode.next = tempNextNode;
                }
                returnedNode = lastNode;
                tempNode.child = null;
                tempNode = tempNextNode;
            }
        }
        return returnedNode;
    }

    public Node flatten(Node head) {
        Node lastNode = dfs(head);
        return head;
    }
}