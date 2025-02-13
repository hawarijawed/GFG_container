/*
Given a Binary Search Tree(BST) and a target. Check whether there's a pair of Nodes in the BST with value summing up to the target. 
*/
class Solution {
    void inorder(Node root, ArrayList<Integer> lst){
        if(root == null){
            return;
        }
        inorder(root.left, lst);
        lst.add(root.data);
        inorder(root.right, lst);
    }
    boolean findTarget(Node root, int target) {
        // Write your code here
        ArrayList<Integer> lst = new ArrayList<>();
        inorder(root, lst);
        int left = 0, right = lst.size()-1;
        while(left < right){
            int sum = lst.get(left) + lst.get(right);
            if(sum == target){
                return true;
            }
            else if(sum > target){
                right--;
            }
            else{
                left++;
            }
        }
        
        return false;
    }
}
