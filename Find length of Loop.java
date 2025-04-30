/*
Given the head of a linked list, determine whether the list contains a loop. If a loop is present, return the number of nodes in the loop, otherwise return 0.

Note: 'c' is the position of the node which is the next pointer of the last node of the linkedlist. If c is 0, then there is no loop.
*/


class Solution {
    // Function to find the length of a loop in the linked list.
    public int countNodesinLoop(Node head) {
        // code here.
        if(head == null && head.next == null){
           return 0;
        }
        
        Node fast = head;
        Node slow = head;
        boolean loop_present = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast){
                loop_present = true;
                break;
            }
        }
        
        if(!loop_present){
            return 0;
        }
        
        int count = 1;
        slow = slow.next;
        while(slow != fast){
            slow = slow.next;
            count++;
        }
        
        return count;
    }
}
