class Node {
    int data;
    Node next, prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

}


public static Node reverseDLL(Node  head)
{
    if(head == null) return  null;
    
    Node prev = null;
    Node curr = head;
    Node next = head.next;
    
    curr.next = prev;
    curr.prev = next;
    prev = curr;
    curr = next;
    if(next != null){
        next = next.next;
    }
    
    while(curr != null){
        curr.next = prev;
        curr.prev = next;
        prev = curr;
        curr = next;
        if(next != null){
            next = next.next;
        }
    }
    
    return prev;
}