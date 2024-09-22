/*
Given the head of a linked list and the number k, Your task is to find the kth node from the end. If k is more than the number of nodes, then the output should be -1.
*/
class Solution {

    // Function to find the data of kth node from
    // the end of a linked list.
    int getKthFromLast(Node head, int k) {
        // Your code here
        int size = 0;
        Node temp = head;
        //Calculating size
        while(temp != null){
            size++;
            temp = temp.next;
        }
        
        if(size < k){
            return -1;
        }
        temp = head;
        int i = 0;
        while(i<size-k){
            temp = temp.next;
            i++;
        }
        return temp.data;
    }
}
