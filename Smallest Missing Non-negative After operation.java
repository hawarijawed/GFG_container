/*
You are given a 0-indexed integer array nums and an integer value.

In one operation, you can add or subtract value from any element of nums.

For example, if nums = [1,2,3] and value = 2, you can choose to subtract value from nums[0] to make nums = [-1,2,3].
The MEX (minimum excluded) of an array is the smallest missing non-negative integer in it.

For example, the MEX of [-1,2,3] is 0 while the MEX of [1,0,3] is 2.
Return the maximum MEX of nums after applying the mentioned operation any number of times.
*/
/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
    Node removekeys(Node root, int l, int r) {
        // code here
        if(root == null) {
            return null;
        }
        
        root.left = removekeys(root.left, l, r);
        root.right = removekeys(root.right, l, r);
        
        if(root.data >= l && root.data <= r) {
            return root;
        }
        
        if(root.left != null) {
            return root.left;
        } else {
            return root.right;
        }
        
    }
}
