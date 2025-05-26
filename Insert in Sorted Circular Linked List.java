/*
Given a sorted circular linked list, the task is to insert a new node in this circular linked list so that it remains a sorted circular linked list.
*/
/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
} */

class Solution {
    public Node sortedInsert(Node head, int data) {
       
        Node newNode = new Node(data);

        // Case 1: Empty list
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        Node current = head;

        // Case 2: Insert before head (i.e., smallest element)
        if (data < head.data) {
            // Find last node to update its next pointer
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head;
            return newNode; // new node becomes the new head
        }

        // Case 3: Insert in correct sorted position
        Node temp = head;
        while (temp.next != head && temp.next.data < data) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        return head;
    }
}
