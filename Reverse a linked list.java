/*
Given the head of a linked list, the task is to reverse this list and return the reversed head.
*/
class Solution {
    Node reverseList(Node head) {
        // code here
        
        Node curr = head;
        Node prev = null;
        while(curr != null ){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}
