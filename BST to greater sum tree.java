/*
Given the root of a  BST with unique node values, transform it into greater sum tree where each node contains sum of all nodes greater than that node.
*/
/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
} */

class Solution {
    // public static void traverse(Node root, List<Integer> lst){
    //     if(root == null){
    //         return;
    //     }
        
    //     traverse(root.left, lst);
    //     lst.add(root.data);
    //     traverse(root.right, lst);
    // }
    // public static void transformTree(Node root) {
    //     // code here
    //     if(root == null){
    //         return;
    //     }
    
    //     List<Integer> lst = new ArrayList<>();
    //     traverse(root, lst);
        
        
        
    //     //Perform prefix sum 
    //     for(int i=1; i<lst.size(); i++){
    //         lst.add(i, lst.get(i-1) + lst.get(i));
    //     }
        
    //     //Map index with node value
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     map.put(lst.get(0), lst.get(0));
    //     for(int i=1; i<lst.size(); i++){
    //         map.put(lst.get(i)-lst.get(i-1), lst.get(i));
    //     }
    //     helperFun(root, map, lst.get(lst.size()-1));
        
    // }
    
    // public static void helperFun(Node root, HashMap<Integer, Integer>map, int preSum){
    //     if(root == null){
    //         return;
    //     }
        
    //     helperFun(root.left, map, preSum);
    //     root.data = preSum - map.get(root.data);
    //     helperFun(root.right, map, preSum);
    // }
    int val =0;
    public void transformTree(Node root) {
        // code here
        if(root==null) return ;
        int value = root.data;
        transformTree(root.right);
        root.data = val;
        val+=value;
        transformTree(root.left);
    }
}
