/* Structure of Doubly Linked List
class Node
{
	int data;
	Node next;
	Node prev;
	Node(int data)
	{
	    this.data = data;
	    next = prev = null;
	}
}*/

class GfG {
    // Function to insert a new node at given position in doubly linked list.
    void addNode(Node head_ref, int p, int data) {
        // Your code here
        if (head_ref == null) {
            return;
        }

        Node node = head_ref;

        Node newNode = new Node(data);

        int i = 0;
        while (node != null && i < p) {
            node = node.next;
            i++;
        }

        if (node.next == null) {
            node.next = newNode;
            newNode.prev = node;
        } else {
            newNode.next = node.next;
            node.next.prev = newNode;
            node.next = newNode;
            newNode.prev = node;
        }
    }
}