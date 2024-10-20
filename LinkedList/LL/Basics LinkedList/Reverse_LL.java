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

 //recursive approach
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        return helper(head);
    }

    public ListNode helper(ListNode node){
        if(node == null) return null;
        if(node.next == null) return node;

        ListNode head = helper(node.next);
        node.next.next = node;
        node.next = null;

        return head;
    }
}


//non recursvie

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;

        while(curr != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null){
                next = next.next;
            }
        }

        return prev;
    }
}
