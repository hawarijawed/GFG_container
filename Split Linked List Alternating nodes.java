// User function Template for Java
/*
struct Node
{
    int data;
    struct Node* next;

    Node(int x){
        data = x;
        next = NULL;
    }

};
*/
/*
Given a singly linked list's head. Your task is to complete the function alternatingSplitList() that splits the given linked list into two smaller lists. The sublists should be made from alternating elements from the original list.
Note: 

The sublist should be in the order with respect to the original list.
Your have to return an array containing the both sub-linked lists.
*/
class Solution {
    // Function to append a new node with newData at the end of a linked list
    Node[] alternatingSplitList(Node head) {
        // code here
        Node[] arr = new Node[2];
        if (head == null) {
            return arr; // Return two null references if the list is empty
        }

        Node oddHead = head; // First list starts with head (odd index)
        Node evenHead = head.next; // Second list starts with head.next (even index)
    
        Node odd = oddHead; // Pointer for the odd-indexed list
        Node even = evenHead; // Pointer for the even-indexed list

        // Traverse the list
        while (odd != null && even != null) {
            odd.next = even.next; // Link odd nodes
            odd = odd.next; // Move to the next odd node
            if (odd != null) { // Check if next odd node exists
                even.next = odd.next; // Link even nodes
                even = even.next; // Move to the next even node
            }
        }

        // Set the last nodes of both lists to null
        if (odd != null) {
            odd.next = null; // End of odd list
        }
        if (even != null) {
            even.next = null; // End of even list
        }

        arr[0] = oddHead; // First list head
        arr[1] = evenHead; // Second list head
    
        return arr;
    }
}
