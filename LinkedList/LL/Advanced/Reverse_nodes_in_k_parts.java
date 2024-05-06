class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution
{
    public static Node reverse(Node node, int k)
    {
        //Your code here
        if(node.next == null) return node;
        if(k == 1) return node;
        
        if (node == null)
            return null;

        Node current = node;
        Node next = null;
        Node prev = null;

        int count = 0;

        // Reverse first k nodes of the linked list
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        /* next is now a pointer to (k+1)th node 
           Recursively call for the list starting from current.
           And make rest of the list as next of first node */
        if (next != null)
            node.next = reverse(next, k);

        // prev is now head of input list
        return prev;
    }
    
}