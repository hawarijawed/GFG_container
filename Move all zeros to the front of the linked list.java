/*
Given a linked list, the task is to move all 0s to the front of the linked list. The order of all other elements except 0 should be the same after rearrangement.
*/
class Solution {
    public Node moveZeroes(Node head) {
        // Your Code here.
        ArrayList<Integer> lst = new ArrayList<>();
        int count0 = 0;
        if(head.next == null){
            return head;
        }
        
        Node curr = head;
        while(curr != null){
            if(curr.data == 0){
                count0++;
            }
            else{
                lst.add(curr.data);
            }
            curr = curr.next;
        }
        
        Node dummy = new Node(-1);
        curr = dummy;
        for(int i=0; i<count0; i++){
            Node newNode = new Node(0);
            curr.next = newNode;
            curr = curr.next;
        }
        
        for(int i=0; i<lst.size(); i++){
            Node newNode = new Node(lst.get(i));
            curr.next = newNode;
            curr = curr.next;
        }
        
        return dummy.next;
    }
}
