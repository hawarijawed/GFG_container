/*
Given two singly linked lists, return the point where two linked lists intersect.

Note: If the linked lists do not merge at any point, return -1.
*/
class Intersect {
    // Function to find intersection point in Y shaped Linked Lists.
    int intersectPoint(Node head1, Node head2) {
        // code here
        int n1 = 0;
        int n2 = 0;
        Node temp1 = head1;
        Node temp2 = head2;
        
        while(temp1 != null){
            n1++;
            temp1 = temp1.next;
        }
        
        while(temp2 != null){
            n2++;
            temp2 = temp2.next;
        }
        
        temp1 = head1;
        temp2 = head2;
        
        int diff = Math.abs(n1 - n2);
        if(n1 > n2){
            while(diff > 0){
                temp1 = temp1.next;
                diff--;
            }
        }
        else{
            while(diff > 0){
                temp2 = temp2.next;
                diff--;
            }
        }
        
        while(temp1 != null && temp2 != null){
            if(temp1.next == temp2.next){
                return temp1.next.data;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        
        return -1;
    }
}
