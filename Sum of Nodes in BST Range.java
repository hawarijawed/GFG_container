/*
Given the root of a Binary Search Tree and two integers l and r, the task is to find the sum of all nodes that lie between l and r, including both l and r.
*/
/*
class Node {
    int data;
    Node left, right;
    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    int sum = 0;
    public int nodeSum(Node root, int l, int r) {
        // code here
        return traverse(root, l, r);
    }
    
    public int traverse(Node root, int l, int r){
        if(root == null){
            return sum;
        }
        
        if(root.data >= l && root.data <= r){
            sum += root.data;
        }
        
        int leftSum = traverse(root.left, l, r);
        int rightSum = traverse(root.right, l, r);
        return sum;
    }
}
/*
root = [8, 5, 11, 3, 6, N, 20], l = 11, r = 15  
root = [22, 12, 30, 8, 20], l = 10, r = 22
*/
