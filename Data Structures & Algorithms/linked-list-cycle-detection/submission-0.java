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
    public boolean hasCycle(ListNode head) {
        ListNode hare = head;
        ListNode tortuise = head;

        while (hare != null && hare.next != null) {
            hare = hare.next.next;
            tortuise = tortuise.next;

            if (hare == tortuise) return true;
        }

        return false;
    }
}
