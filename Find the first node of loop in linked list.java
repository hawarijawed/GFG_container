/*
Given a head of the singly linked list. If a loop is present in the list then return the first node of the loop else return NULL.

Custom Input format:
A head of a singly linked list and a pos (1-based index) which denotes the position of the node to which the last node points to. If pos = 0, it means the last node points to null, indicating there is no loop.
*/
/* class Node
{
    int data;
    Node next;

    Node(int x)
    {
        data = x;
        next = null;
    }
}*/

class Solution {
    public static Node findFirstNode(Node head) {
        // code here
        Node slow = head;
        Node fast = head;
        boolean isLoop = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                isLoop = true;
                break;
            }
        }
        if(!isLoop) return new Node(-1);
        slow = head;
        while(slow !=fast){
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
}
