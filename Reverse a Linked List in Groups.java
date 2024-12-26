/*
Given a linked list, the task is to reverse every k node (where k is an input to the function) in the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should be considered as a group and must be reversed
*/
class Solution {
    public static Node reverse(Node head, int k) {
        // Your code 
        if(head == null || k <=1){
            return head;
        }
        
        Node curr = head;
        Node prevTail = null;
        Node newHead = null;
        
        while(curr != null){
            Node grpHead = curr;
            Node prev = null;
            Node next = null;
            
            //Reversing the k nodes
            int count = 0;
            while(curr != null && count < k){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }
            
            if(newHead == null){
                newHead = prev;
            }
            
            if(prevTail != null){
                prevTail.next = prev;
            }
            
            prevTail = grpHead;
        }
        
        return newHead;
    }
}
