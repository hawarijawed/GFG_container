/*
You are given the head of a doubly linked list. You have to reverse the doubly linked list and return its head.
*/
/*
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
*/
class Solution {
    public Node reverse(Node head) {
        // code here
        Node curr = head;
        Node newHead = null;
        
        while(curr != null){
            Node temp = curr.next;

            // Swap next and prev
            curr.next = curr.prev;
            curr.prev = temp;
            // Save the current node — it might be the new head
            newHead = curr;
    
            curr = temp;
        }
        
        return newHead;
    }
}
