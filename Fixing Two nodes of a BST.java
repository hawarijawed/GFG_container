/*
Given the root of a Binary search tree(BST), where exactly two nodes were swapped by mistake. Your task is to fix (or correct) the BST by swapping them back. Do not change the structure of the tree.
Note: It is guaranteed that the given input will form BST, except for 2 nodes that will be wrong. All changes must be reflected in the original Binary search tree(BST).
*/
/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    ArrayList<Node> list;
    void correctBST(Node root) {
        // code here.
        list = new ArrayList<>();
        inorder(root);
        int size = list.size();
        Node start = null, mid = null, last = null;
        for(int i=1; i<size; i++){
            if(list.get(i-1).data > list.get(i).data){
                if(start==null) {
                    start = list.get(i-1);
                    mid = list.get(i);
                } else {
                    last = list.get(i);
                }
            }
        }

        if(last!= null){
            int i = start.data, j = last.data;
            findAndSwap(root, start, -1);
            findAndSwap(root, last, i);
            findAndSwap(root, start, j);
        }
        else {
            int i = start.data, j = mid.data;
            findAndSwap(root, start, -1); 
            findAndSwap(root, mid, i);
            findAndSwap(root, start, j);
        }
    }
    
    void findAndSwap(Node root, Node find, int swap){
        if(root == null){
            return;
        }
        if(root.data == find.data){
            root.data = swap;
            return;
        }
        findAndSwap(root.left, find, swap);
        findAndSwap(root.right, find, swap);
    }
    
    void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        list.add(root);
        inorder(root.right);
    }
}
