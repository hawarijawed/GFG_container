/*
Given a singly linked list and a key, count the number of occurrences of the given key in the linked list.
*/
// complete the below function
class Solution {
    public static int count(Node head, int key) {
        // code here
        Node temp = head;
        int count = 0;
        while(temp != null){
            if(temp.data == key){
                count++;
            }
            temp = temp.next;
        }
        
        return count;
    }
}
