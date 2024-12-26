/*
Given an unsorted linked list. The task is to remove duplicate elements from this unsorted Linked List. When a value appears in multiple nodes, the node which appeared first should be kept, all other duplicates are to be removed.
*/
class Solution {
    // Function to remove duplicates from unsorted linked list.
    public Node removeDuplicates(Node head) {
        // Your code here
        HashSet<Integer> set = new HashSet<>();
        if(head == null ) return head;
        if(head.next == null) return head;
        
        Node temp = head;
        Node dummy = new Node(-1);
        Node node = dummy;
        while(temp != null){
            if(set.isEmpty() || !set.contains(temp.data))
            {
                set.add(temp.data);
                node.next = new Node(temp.data);
                node = node.next;
            }
            temp = temp.next;
        }
        
        return dummy.next;
        
    }
}
