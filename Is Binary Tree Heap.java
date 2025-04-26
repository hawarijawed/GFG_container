/*
You are given a binary tree, and the task is to determine whether it satisfies the properties of a max-heap.

A binary tree is considered a max-heap if it satisfies the following conditions:

Completeness: Every level of the tree, except possibly the last, is completely filled, and all nodes are as far left as possible.
Max-Heap Property: The value of each node is greater than or equal to the values of its children.
*/
class Solution {
    int countNodes(Node tree){
        if(tree==null) return 0;
        
        return 1 + countNodes(tree.left) + countNodes(tree.right);
    }
    boolean isHeapUtil(Node root, int index, int totalNodes) {
        // Empty tree is a heap
        if (root == null) return true;
        
        // If index assigned to current node is more than total nodes, it's not complete
        if (index >= totalNodes) return false;
        
        // Check heap property: parent >= left and right child
        if (root.left != null && root.data < root.left.data) return false;
        if (root.right != null && root.data < root.right.data) return false;
        
        // Recursively check left and right subtrees
        return isHeapUtil(root.left, 2 * index + 1, totalNodes) &&
               isHeapUtil(root.right, 2 * index + 2, totalNodes);
    }
    boolean isHeap(Node tree) {
        // code here
        int totalNodes = countNodes(tree);
        
        return isHeapUtil(tree, 0, totalNodes);
    }
}
