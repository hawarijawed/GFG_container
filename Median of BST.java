/*
You are given the root of a Binary Search Tree, find the median of it. 

Let the nodes of the BST, when written in ascending order (inorder traversal), be represented as V1, V2, V3, …, Vn, where n is the total number of nodes in the BST.

If number of nodes are even: return V(n/2)
If number of nodes are odd: return V((n+1)/2)
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
    public void traverse(Node root, List<Integer> lst){
        if(root == null){
            return;
        }
        
        traverse(root.left, lst);
        lst.add(root.data);
        traverse(root.right, lst);
    }
    public int findMedian(Node root) {
        // Code here
        List<Integer> lst = new ArrayList<>();
        traverse(root, lst);
        int n = lst.size();
        if(n%2 != 0){
            return lst.get(((n+1)/2)-1);
        }
        
        return lst.get((n/2)-1);
    }
}
