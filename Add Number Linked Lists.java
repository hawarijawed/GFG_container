/*
Given the head of two singly linked lists num1 and num2 representing two non-negative integers. The task is to return the head of the linked list representing the sum of these two numbers.

For example, num1 represented by the linked list : 1 -> 9 -> 0, similarly num2 represented by the linked list: 2 -> 5. Sum of these two numbers is represented by 2 -> 1 -> 5.

Note: There can be leading zeros in the input lists, but there should not be any leading zeros in the output list.
*/
class Solution {
    static Node reverse(Node head){
        if(head == null) return head;
        Node prev = null;
        Node curr = head;
        while(curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    static Node addTwoLists(Node num1, Node num2) {
        // code here
        num1 = reverse(num1);
        num2 = reverse(num2);
        
        int sum = 0, carry = 0;
        
        Node temp1 = num1;
        Node temp2 = num2;
        Node head = new Node(-1);
        Node temp = head;
        while(temp1 != null && temp2 != null){
            sum = temp1.data + temp2.data + carry;
            carry = sum/10;
            sum = sum%10;
            temp.next = new Node(sum);
            temp = temp.next;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        while(temp1 != null){
            sum = temp1.data + carry;
            carry = sum/10;
            sum = sum%10;
            temp.next = new Node(sum);
            temp = temp.next;
            temp1 = temp1.next;
        }
        while(temp2 != null){
            sum = temp2.data + carry;
            carry = sum/10;
            sum = sum%10;
            temp.next = new Node(sum);
            temp = temp.next;
            temp2 = temp2.next;
        }
        if(carry != 0){
            temp.next = new Node(carry);
            temp = temp.next;
        
        }
        head = reverse(head.next);
        while(head.data == 0){
            head = head.next;
        }
        return head;
       
    }
}
