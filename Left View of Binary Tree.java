/*
You are given the root of a binary tree. Your task is to return the left view of the binary tree. The left view of a binary tree is the set of nodes visible when the tree is viewed from the left side.

If the tree is empty, return an empty list.
*/
class Solution {
    // Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root) {
        
        ArrayList<Integer> res = new ArrayList<>();
        // code here
        if(root == null){
            return res; 
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> lst = new ArrayList<>();
            for(int i=0; i<size; i++){
                Node node = queue.poll();
                lst.add(node.data);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }            
            res.add(lst.get(0));    
        }
        return res;
    }
}
