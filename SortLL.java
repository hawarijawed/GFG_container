class Solution {
    // Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
        // add your code here
        int n0 = 0, n1 = 0, n2 = 0;
        Node temp = head;
        while(temp != null){
            if(temp.data == 0){
                n0++;
            }
            else if(temp.data == 1){
                n1++;
            }
            else{
                n2++;
            }
            temp = temp.next;
        }
        
        Node dummy = new Node(-1);
        temp = dummy;
        for(int i=0; i<n0; i++){
            Node n = new Node(0);
            temp.next = n;
            temp = temp.next;
        }
        for(int i=0; i<n1; i++){
            Node n = new Node(1);
            temp.next = n;
            temp = temp.next;
        }
        for(int i=0; i<n2; i++){
            Node n = new Node(2);
            temp.next = n;
            temp = temp.next;
        }
        
        return dummy.next;
        
    }
}
