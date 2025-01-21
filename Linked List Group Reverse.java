/*
Given the head a linked list, the task is to reverse every k node in the linked list. If the number of nodes is not a multiple of k then the left-out nodes in the end, should be considered as a group and must be reversed.
*/
/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution {
    public static Node reverseKGroup(Node head, int k) {
        // code here
        if(head == null) return head;
        Node curr = head;
        Node prev = null;
        Node next = curr.next;
        int count=0;
        while(curr != null && count < k){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        
        if(next != null) head.next = reverseKGroup(next, k);
        return prev;
    }
}
