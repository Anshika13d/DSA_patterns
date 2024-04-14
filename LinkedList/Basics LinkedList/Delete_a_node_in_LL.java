class GfG {
    Node deleteNode(Node head, int x) {
        // Your code here
        if (head == null) {
            return null;
        }

        if (x == 1) {
            return head.next;
        }

        Node prev = head;
        int i = 2;

        while (prev != null && i < x) {
            prev = prev.next;
            i++;
        }

        if (prev != null) {
            prev.next = prev.next.next;
        }

        return head;
    }
}
