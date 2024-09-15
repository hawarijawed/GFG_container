/*
Given a Binary Tree (BT), convert it to a Doubly Linked List (DLL) in place. 
The left and right pointers in nodes will be used as previous and next pointers respectively in converted DLL. 
The order of nodes in DLL must be the same as the order of the given Binary Tree. 
The first node of Inorder traversal (leftmost node in BT) must be the head node of the DLL.
*/

//This function should return head to the DLL
class Solution
{
    //Function to convert binary tree to doubly linked list and return it.
    Node prev = null;
    Node head = null;
    void helper(Node root){
        //edge case
	    if(root == null){
	        return;
	    }
	    
	    bToDLL(root.left);
	    if(prev == null){
	        head = root;
	    }
	    else{
	        root.left = prev;
	        prev.right = root;
	    }
	    
	    prev = root;
	    bToDLL(root.right);
	     
    }
    Node bToDLL(Node root)
    {
	    //  Your code here
	    helper(root);
	    return head;
	
    }
}
