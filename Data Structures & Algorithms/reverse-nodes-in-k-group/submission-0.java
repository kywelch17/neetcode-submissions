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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode prevGroup = dummy;

        while (true) {
            ListNode kNode = getKNode(prevGroup, k);
            if (kNode == null) {
                break;
            }

            ListNode nextGroup = kNode.next;

            ListNode prevNode = kNode.next;
            ListNode currNode = prevGroup.next;
            while (currNode != nextGroup) {
                ListNode tmp = currNode.next;
                currNode.next = prevNode;
                prevNode = currNode;
                currNode = tmp;
            }

            ListNode tmp = prevGroup.next;
            prevGroup.next = kNode;
            prevGroup = tmp;
        }

        return dummy.next;
    }

    private ListNode getKNode(ListNode node, int k) {
        while (node != null && k-- > 0) {
            node = node.next;
        }

        return node;
    }
}
