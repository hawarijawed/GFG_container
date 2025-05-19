/*
You are given root node of the BST and an integer key. You need to find the in-order successor and predecessor of the given key. If either predecessor or successor is not found, then set it to NULL.

Note:- In an inorder traversal the number just smaller than the target is the predecessor and the number just greater than the target is the successor.
*/


class Solution {
    
    public ArrayList<Node> findPreSuc(Node root, int key) {
        // code here
        ArrayList<Node> res = new ArrayList<>();
        
        Node pred = null, succ = null;
        Node curr = root;
        //Finding predeccessor
        while(curr != null){
            if(curr.data < key){
                pred = curr;
                curr = curr.right;
            }
            else{
                curr = curr.left;
            }
        }
        
        curr = root;
        //Finding successor
        while(curr != null){
            if(curr.data > key){
                succ = curr;
                curr = curr.left;
            }
            else{
                curr = curr.right;
            }
        }
        
        res.add(pred);
        res.add(succ);
        return res;
    }
}
