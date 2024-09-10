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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode headNext = head.next;
        ListNode result = head;
        while (headNext != null) {
            int a = headNext.val;
            int b = head.val;
            while (b != 0) {
            int temp = b;
                b = a % b;
                a = temp;
            }
            head.next = new ListNode(a, headNext);
            head = headNext;
            headNext = headNext.next;
        }
        return result;
    }
}