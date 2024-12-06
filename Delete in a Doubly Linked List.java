/*
Given a Doubly Linked list and a position. The task is to delete a node from a given position (position starts from 1) in a doubly linked list and return the head of the doubly Linked list.
*/
class Solution {
    public Node deleteNode(Node head, int x) {
        // code here
        if(x==1){
            head = head.next;
            head.prev = null;
            return head;
        }
        
        Node temp = head;
        Node Prev = null;
        int count = 1;
        while(count != x){
            Prev = temp;
            temp = temp.next;
            count++;
        }
        if(temp.next == null){
            Prev.next = null;
            temp.prev = null;
            return head;
        }
        Prev.next = temp.next;
        temp.next.prev = Prev;
        temp.prev = null;
        temp.next = null;
        
        
        return head;
    }
}
