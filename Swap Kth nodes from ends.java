/*
Given the head of a singly linked list and an integer k. Swap the kth node (1-based index) from the beginning and the kth node from the end of the linked list. 
Return the head of the final formed list and if it's not possible to swap the nodes return the original list.
*/

/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/
class Solution {
    public Node swapKth(Node head, int k) {
        // code here
        int size = 0;
        Node temp = head;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        
        if(k>size) return head;
        Node prev=head;
        for(int i=1; i<k; i++){
            prev = prev.next;
        }
        Node Next = head;
        for(int i=1;i<size-k+1; i++){
            Next = Next.next;
        }
        
        int temp_val = prev.data;
        prev.data = Next.data;
    
        Next.data = temp_val;
        return head;
    }
}
