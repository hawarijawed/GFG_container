/*
Given a Circular Linked List. The task is to delete the given node, key in the circular linked list, and reverse the circular linked list.
Note:
You don't have to print anything, just return the head of the modified list in each function.
Nodes may consist of Duplicate values.
The key may or may not be present.
*/
class Solution {
    // Function to reverse a circular linked list
    Node reverse(Node head) {
        // code here
        Node prev = null;
        Node curr = head;
        Node frw = head.next;
        while(frw != head){
            curr.next = prev;
            prev = curr;
            curr = frw;
            frw = frw.next;
        }
        curr.next = prev;
        frw.next = curr;
        return curr;
    }

    // Function to delete a node from the circular linked list
    Node deleteNode(Node head, int key) {
        //code here
        Node temp = head;
        if(head.data == key){
            while(temp.next != head){
                temp = temp.next;
            }
            temp.next = temp.next.next;
            return head.next;
        }
        while(temp.next.data!=key && temp.next != head){
            temp = temp.next;
        }
        if(temp.next.data == key) temp.next = temp.next.next;
        return head;
        
    }
}
