/*
Given a sorted doubly linked list and an element x, you need to insert the element x into the correct position in the sorted Doubly linked list(DLL).

Note: The DLL is sorted in ascending order
*/
class Solution {
    public Node sortedInsert(Node head, int x) {
        // add your code here
        // First edge case: if head is empty
        if(head == null){
            head = new Node(x);
            return head;
        }
        
        //If there is only one element
        if(head.next == null){
            Node newNode = new Node(x);
            //Determining position of new node
            if(head.data < x){
                //head -> newNode
                head.next = newNode;
                newNode.prev = head;
                return head;
            }
            else{
                //newNode -> head;
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
                return head;
            }
        }
        
        //Insertion at head
        //if x < head.data
        if(head.data > x ){
            Node newNode = new Node(x);
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            return head;
        }
        
        Node Next = null;
        Node Curr = head;
        
        int count = 0;
        while(Curr.next != null){
            if(Curr.next != null && Curr.data <= x && Curr.next.data > x){
                break;
            }
            Curr = Curr.next;
            count++;
        }
        //Insertion at tail
        if(Curr.next == null){
            Node newNode = new Node(x);
            Curr.next = newNode;
            newNode.prev = Curr;
            return head;
        }
        //Insertion between head and tail
        Curr = head;
        for(int i=0; i<count; i++){
            Curr = Curr.next;
        }
        
        Next = Curr.next;
        Node newNode = new Node(x);
        Curr.next = newNode;
        newNode.prev = Curr;
        newNode.next = Next;
        Next.prev = newNode;
        
        return head;
        
    }
}
