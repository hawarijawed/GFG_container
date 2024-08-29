/*
Given the head of a linked list, determine whether the list contains a loop. If a loop is present, return the number of nodes in the loop, otherwise return 0.

*/
class Solution {
    // Function to find the length of a loop in the linked list.
    public int countNodesinLoop(Node head) {
        // Add your code here.
        if(head == null || head.next == null){
            return 0;
        }
        Node fast = head;
        Node slow = head;
        int count = 0;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                count++;
                break;
            }
            
        }
        
        if(slow == fast){
            Node temp = slow.next;
            while(temp != slow){
                temp = temp.next;
                count++;
            }
        }
        return count;
    }
}
