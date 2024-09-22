/*You are given a special linked list where each node has a next pointer pointing to its next node. You are also given some random pointers, where you will be given some pairs denoting two nodes a and b i.e. a->random = b (random is a pointer to a random node).
Construct a copy of the given list. The copy should consist of the same number of new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the original and copied list pointers represent the same list state. None of the pointers in the new list should point to nodes in the original list.
For example, if there are two nodes x and y in the original list, where x->random = y, then for the corresponding two nodes xnew and ynew in the copied list, xnew->random = ynew.
Return the head of the copied linked list.

NOTE : 
1. If there is any node whose arbitrary pointer is not given then it's by default NULL. 
2. Don't make any changes to the original linked list.
*/
//---------------------------- Solution with O(n) space ----------------------------//
class Solution {
    // Function to clone a linked list with next and random pointer.
    Node copyList(Node head) {
        // your code here
        if(head == null){
            return head;
        }
        
        HashMap<Node, Node> map = new HashMap<>();
        Node temp = head;
        
        while(temp != null){
            Node n1 = new Node(temp.data);
            map.put(temp, n1);
            temp = temp.next;
        }
        
        temp = head;
        while(temp != null){
            Node copy = map.get(temp);
            copy.next = map.get(temp.next);
            copy.random = map.get(temp.random);
            temp = temp.next;
        }
        
        return map.get(head);
    }
}

//---------------------------- Solution with O(1) space ----------------------------//
class Solution {
    // Function to clone a linked list with next and random pointer.
    Node copyList(Node head) {
        // your code here
        if (head == null) {
        return null;
    }

    // Step 1: Interleave the original and copied nodes
    Node temp = head;
    while (temp != null) {
        Node copy = new Node(temp.data);
        copy.next = temp.next;
        temp.next = copy;
        temp = copy.next; // Move to the next original node
    }

    // Step 2: Assign random pointers to the copied nodes
    temp = head;
    while (temp != null) {
        Node copy = temp.next; // This is the copied node
        copy.random = (temp.random != null) ? temp.random.next : null; // Set the random pointer
        temp = copy.next; // Move to the next original node
    }

    // Step 3: Separate the original and copied lists
    Node original = head;
    Node copyHead = head.next; // The head of the copied list
    while (original != null) {
        Node copy = original.next; // Get the copied node
        original.next = copy.next; // Restore the original list
        original = original.next; // Move to the next original node
        if (copy.next != null) {
            copy.next = copy.next.next; // Set the next pointer for copied node
        }
    }
    return copyHead; // Return the head of the copied list
    }
}