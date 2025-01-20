/*
Given the head of two sorted linked lists consisting of nodes respectively. The task is to merge both lists and return the head of the sorted merged list.
*/
/*
  Node is defined as
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class Solution {
    Node sortedMerge(Node head1, Node head2) {
        // code here
        ArrayList<Integer> lst = new ArrayList<>();
        
        Node temp = head1;
        while(temp != null){
            lst.add(temp.data);
            temp = temp.next;
        }
        temp = head2;
        while(temp != null){
            lst.add(temp.data);
            temp = temp.next;
        }
        
        Collections.sort(lst);
        
        Node dummy = new Node(-2);
        temp = dummy;
        for(int i=0; i<lst.size(); i++){
            temp.next = new Node(lst.get(i));
            temp = temp.next;
        }
        
        return dummy.next;
    }
}
