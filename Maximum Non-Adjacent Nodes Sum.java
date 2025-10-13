/*
Given the root of a binary tree with integer values. 
Your task is to select a subset of nodes such that the sum of their values is maximized, with the condition that no two selected nodes are directly connected that is, if a node is included in the subset, 
neither its parent nor its children can be included.

*/
/*
class Node {
    int data;
    Node left, right;

    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution {
    HashMap<Node, Integer> m = new HashMap<>();
    public int getMaxSum(Node root) {
        // code here
        if(root==null) return 0;
        
        if(m.containsKey(root)) return m.get(root);
        
        int withoutNode=root.data;
        
        if(root.left!=null){
        withoutNode+=getMaxSum(root.left.left);
        withoutNode+=getMaxSum(root.left.right);
        }
        
        if(root.right!=null){
        withoutNode+=getMaxSum(root.right.left);
        withoutNode+=getMaxSum(root.right.right);
        }
        
        int withNode =(getMaxSum(root.left)+getMaxSum(root.right));
        
        
        int res =Math.max(withoutNode, withNode);
        m.put(root, res);
        
        return res;
    }
}
