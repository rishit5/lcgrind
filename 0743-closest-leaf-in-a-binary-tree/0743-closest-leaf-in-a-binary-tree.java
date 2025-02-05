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
    Map<Integer, List<Integer>> adjList = new HashMap<>();

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        adjList.putIfAbsent(root.val, new LinkedList<>());
        if (root.right != null) {
            adjList.putIfAbsent(root.right.val, new LinkedList<>());
            adjList.get(root.val).add(root.right.val);
            adjList.get(root.right.val).add(root.val);
        }
        if (root.left != null) {
            adjList.putIfAbsent(root.left.val, new LinkedList<>());
            adjList.get(root.val).add(root.left.val);
            adjList.get(root.left.val).add(root.val);
        }
        dfs(root.right);
        dfs(root.left);
        return;
    }

    public int findClosestLeaf(TreeNode root, int k) {
        this.dfs(root);

        if (root.right == null && root.left == null) {
            return root.val;
        }

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        queue.offer(new Pair(k, 1));

        Set<Integer> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> curr = queue.poll();
            visited.add(curr.getKey());
            if (adjList.get(curr.getKey()).size() == 1 && curr.getKey() != root.val) {
                return curr.getKey();
            }
            for (Integer n : adjList.get(curr.getKey())) {
                if (visited.contains(n)) {
                    continue;
                }
                queue.offer(new Pair(n, curr.getValue() + 1));
            }
        }

        return -1;
    }
}