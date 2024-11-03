/*
Given a linked list, your task is to complete the function isLengthEven() which contains the head of the linked list, and check whether the length of the linked list is even or not. Return true if it is even, otherwise false.
*/
// User function Template for Java
class Solution {
    public boolean isLengthEven(Node head) {
        // code here
        Node temp = head;
        int size = 0;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        
        return size%2==0?true:false;
    }
}
