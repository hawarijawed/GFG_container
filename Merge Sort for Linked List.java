/*
You are given the head of a linked list. You have to sort the given linked list using Merge Sort.
*/

/*
class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}
*/

class Solution {
    public Node mergeSort(Node head) {
        // code here
        if(head == null || head.next == null) return head;
        
        //Splitting the linked list into halfs
        Node midHead = getMiddle(head);
        Node nextToMid = midHead.next;
        midHead.next = null;
        
        Node left = mergeSort(head);
        Node right = mergeSort(nextToMid);
        
        return merge(left, right);
    }
    
    public Node getMiddle(Node head){
        Node fast = head.next;
        Node slow = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public Node merge(Node left, Node right){
        Node dummy = new Node(-1);
        Node tail = dummy;
        while(left != null && right != null){
            if(left.data <= right.data){
                tail.next = left;
                left = left.next;
            }
            else{
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        
        if(left != null) tail.next = left;
        if(right != null) tail.next = right;
        
        return dummy.next;
    }
}
