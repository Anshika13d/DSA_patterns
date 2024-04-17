/* Structure of linkedlist node
class Node
{
	int data;
	Node next;
	Node prev;
	Node(int d)
	{
		data = d;
		next = prev = null;
	}
}
*/
class Solution
{
    // function returns the head of the linkedlist
    Node deleteNode(Node head,int x)
    {
            if(head == null){
                return null;
            }
            
            if(x == 1){
                return head.next;
            }
            
            Node prev = null;
            Node next = head;
            
	    	int i = 1;
	    	
	    	while(i < x){
	    	    prev = next;
	    	    next = next.next;
	    	    i++;
	    	}
	    	
	    	if(next.next != null){
	    	    prev.next = next.next;
	    	    prev.next.prev = prev;
	    	}
	    	else{
	    	    prev.next = null;
	    	}
	    	
	    	return head;
    }
}