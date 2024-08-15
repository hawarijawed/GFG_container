
/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node reverse(Node head){
        Node prev = null;
        Node curr = head;
        Node next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    public Node addOne(Node head) {
        // code here.
        //If there is only one node
        if(head.next == null){
            head.data = head.data+1;
            return head;
        }
        
        //Collect all the node values and sums them up in the respective order
        head = reverse(head);
        Node curr = head;
        int carry = 1;
        Node prev = null;
        while(curr != null){
            int sum = curr.data + carry;
            carry = sum/10;
            curr.data = sum%10;
            prev = curr;
            curr = curr.next;
        }
        
        if(carry > 0){
            prev.next = new Node(carry);
        }
        head = reverse(head);
        return head;
        
    }
}
