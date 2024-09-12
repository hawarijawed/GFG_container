/*
Given the head of a linked list, the task is to find the middle. 
For example, the middle of 1-> 2->3->4->5 is 3. If there are two middle nodes (even count), return the second middle. 
For example, middle of 1->2->3->4->5->6 is 4.

*/

class Solution {
    int getMiddle(Node head) {
        // Your code here.
        if(head == null){
            return -1;
        }
        
        if(head.next == null){
            return head.data;
        }
        
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow.data;
    }
}
