/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int i = 0;
        int j = 0;
        
        int k = 0;
        
        int l = 0;
        int q = 1;
        
        int[][] result = new int[m][n];
        
        for (int p = 0; p < m; p++) {
            result[p] = new int[n];
            Arrays.fill(result[p], -1);
        }
        
        while (head != null) {
            result[i][j] = head.val;
            head = head.next;
            
            if (k == 0) {
                if (j == n-1) {
                    k = 1;
                    i += 1;
                    n -= 1;
                } else {
                    j++;
                }
            } else if (k == 1) {
                if (i == m-1) {
                    k = 2;
                    j -= 1;
                    m -= 1;
                } else {
                    i++;
                }
            } else if (k == 2) {
                if (j == l) {
                    k = 3;
                    i -= 1;
                    l += 1;
                } else {
                    j--;
                }
            } else if (k == 3) {
                if (i == q) {
                    k = 0;
                    j += 1;
                    q += 1;
                } else {
                    i--;
                }
            }
        }
        
        return result;
    }
}