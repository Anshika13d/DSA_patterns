/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
}
*/
class Solution {
    // Function to insert a node at the beginning of the linked list.
    Node insertAtBeginning(Node head, int x) {
        // code here
        Node node = new Node(x);
        node.next = head;
        return node;
    }

    // Function to insert a node at the end of the linked list.
    Node insertAtEnd(Node head, int x) {
        if (head == null) {
            return new Node(x);
        }
        Node prev = null;
        Node next = head;

        while (next != null) {
            prev = next;
            next = next.next;
        }

        Node node = new Node(x);
        prev.next = node;
        return head;
    }
}