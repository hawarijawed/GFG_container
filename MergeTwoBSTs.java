/*
Given two BSTs, return elements of merged BSTs in sorted form.
*/
class Solution {
    // Function to return a list of integers denoting the node
    // values of both the BST in a sorted order.
    public void inorderT(Node root, List<Integer> arr){
        if(root == null){
            return;
        }
        
        inorderT(root.left, arr);
        arr.add(root.data);
        inorderT(root.right, arr);
    }
    public List<Integer> merge(Node root1, Node root2) {
        // Write your code here
        List<Integer> arr1 = new ArrayList<>();
        // List<Integer> arr2 = new ArrayList<>();
        inorderT(root1, arr1);
        inorderT(root2, arr1);
        Collections.sort(arr1);
        return arr1;
    }
}
