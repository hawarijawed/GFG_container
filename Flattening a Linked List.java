/*
Given a linked list containing n head nodes where every node in the linked list contains two pointers:
(i) next points to the next node in the list.
(ii) bottom points to a sub-linked list where the current node is the head.
Each of the sub-linked lists nodes and the head nodes are sorted in ascending order based on their data. Flatten the linked list such that all the nodes appear in a single level while maintaining the sorted order.

Note:
1. ↓ represents the bottom pointer and → represents the next pointer.
2. The flattened list will be printed using the bottom pointer instead of the next pointer.
*/
/*
class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}
*/
class Solution {
    public Node flatten(Node root) {
        // code here
        List<Integer> res = new ArrayList<>();
        Node temp = root;
        while(temp != null){
            res.add(temp.data);
            if(temp.bottom != null){
                extractBottom(temp.bottom, res);   
            }
            
            temp = temp.next;
            
        }
        
        Collections.sort(res);
        
        Node dummy = new Node(-1);
        temp = dummy;
        for(int i=0; i<res.size(); i++){
            temp.bottom = new Node(res.get(i));
            temp = temp.bottom;
            temp.next = null;
        }
        
        return dummy.bottom;
    }
    
    public void extractBottom(Node root, List<Integer> res){
        if(root == null){
            return;
        }
        res.add(root.data);
        extractBottom(root.bottom, res);
    }
}
