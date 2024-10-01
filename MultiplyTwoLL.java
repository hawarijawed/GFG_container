/*
Given elements as nodes of the two singly linked lists. The task is to multiply these two linked lists, say L1 and L2.

Note: The output could be large take modulo 109+7.
*/

class Solution {
    private long linkedListToNumber(Node head) {
        long number = 0;
        Node current = head;
        long multiplier = 10; // Used for place value
        
        while (current != null) {
            number = number*multiplier + current.data;
            current = current.next;
        }
        
        return number;
    }
    
    public long multiplyTwoLists(Node first, Node second) {
        // Code here
        long num1 = linkedListToNumber(first);
        long num2 = linkedListToNumber(second);
        long product = (num1 * num2)%1000000007;
        return product;
    }
}
