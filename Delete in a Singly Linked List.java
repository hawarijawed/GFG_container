/*
Given a singly linked list and an integer, x. Delete the xth node (1-based indexing) from the singly linked list.
*/
class Solution {
    Node deleteNode(Node head, int x) {
        // code here
        if(head == null) return head;
        if(x==1) return head.next;
        Node temp = head;
        Node prev = null;
        int count = 1;
        while(count != x){
            prev = temp;
            temp = temp.next; 
            count++;
        }
        prev.next = temp.next;
        prev = prev.next;
        return head;
    }
}
