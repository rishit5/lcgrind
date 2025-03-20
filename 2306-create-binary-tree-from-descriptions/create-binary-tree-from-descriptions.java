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
    
    private void processParent(int parent, Map<Integer, TreeNode> myMap, Set<Integer> onlyParentSet) {
        if (!myMap.containsKey(parent)) {
            myMap.put(parent, new TreeNode(parent));
            onlyParentSet.add(parent);
        }
    }

    private void processChild(int parent, int child, int isLeft, Map<Integer, TreeNode> myMap, Set<Integer> onlyParentSet, Set<Integer> childSet) {
        if (!myMap.containsKey(child)) {
            myMap.put(child, new TreeNode(child));
        }
        if (isLeft == 1) {
            myMap.get(parent).left = myMap.get(child);
        } else {
            myMap.get(parent).right = myMap.get(child);
        }
        if (onlyParentSet.contains(child)) {
            onlyParentSet.remove(child);
        }
        childSet.add(child);
    }

    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> myMap = new HashMap<>();
        Set<Integer> onlyParentSet = new HashSet<>();
        Set<Integer> childSet = new HashSet<>();

        for (int i = 0; i < descriptions.length; i++) {
            int parent = descriptions[i][0];
            int child = descriptions[i][1];
            int isLeft = descriptions[i][2];

            processParent(parent, myMap, onlyParentSet);
            processChild(parent, child, isLeft, myMap, onlyParentSet, childSet);
        }

        return myMap.get(onlyParentSet.iterator().next());
    }
}