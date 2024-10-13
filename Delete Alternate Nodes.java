/*
Given a Singly Linked List, Delete all alternate nodes of the list ie delete all the nodes present in even positions.
*/
class Solution {
    public void deleteAlt(Node head) {
        // Code Here
        if(head.next == null){
            return;
        }
        if(head.next.next == null){
            head.next = null;
            return;
        }
        
        Node current = head;
        while(current !=null && current.next != null){
            current.next = current.next.next;
            current = current.next;
        }
        
    }
}
