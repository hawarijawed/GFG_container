/*
Given a linked list, the task is to move all 0s to the front of the linked list. The order of all other elements except 0 should be the same after rearrangement.
*/
class Solution {
    Node sortedInsert(Node head, int x) {
        // Add your code here.
        Node newNode = new Node(x);
        if(head.next == null){
            if(head.data > x){
                newNode.next = head;
                head = newNode;
                return head;
            }
            else{
                head.next = newNode;
                return head;
            }
        }
        
        if(head.data > x){
            newNode.next = head;
            head = newNode;
            return head;
        }
        
        Node temp = head;
        boolean flag = false;
        while(temp.next != null){
            if(temp.next != null && temp.data <= x && temp.next.data > x){
                newNode.next = temp.next;
                temp.next = newNode;
                temp = newNode.next;
                flag = true;
            }
            else{
                temp = temp.next;
            }
        }
        
        if(flag){
            return head;
        }
        temp.next = newNode;
        temp = temp.next;
        return head;
    }
}
