/*
Given a binary tree and the task is to find the spiral order traversal of the tree and return the list containing the elements.
Spiral order Traversal mean: Starting from level 0 for root node, for all the even levels we print the node's value from right to left and for all the odd levels we print the node's value from left to right.
For below tree, function should return [1, 2, 3, 4, 5, 6, 7]
*/

class Solution {
    public ArrayList<Integer> findSpiral(Node root) {
        // code here
        Queue<Node> pq = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        if(root.left == null && root.right == null){
            res.add(root.data);
            return res;
        }
        
        pq.offer(root);
        boolean leftToRight = false;
        while(!pq.isEmpty()){
            int levelSize = pq.size();
            Deque<Integer> q = new LinkedList<>();
            for(int i=0; i<levelSize; i++){
                Node temp = pq.poll();
                if(leftToRight){
                    q.addLast(temp.data);
                }
                else{
                    q.addFirst(temp.data);   
                }
                
                if(temp.left != null){
                    pq.offer(temp.left);
                }
                
                if(temp.right != null){
                    pq.offer(temp.right);
                }
            }
            
            res.addAll(q);
            leftToRight = !leftToRight;
        }
        
        return res;
    }
}
