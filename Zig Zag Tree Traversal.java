/*
Given the root of a binary tree. You have to find the zig-zag level order traversal of the binary tree.
Note: In zig zag traversal we traverse the nodes from left to right for odd-numbered levels, and from right to left for even-numbered levels.
*/

/*
class Node {
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    ArrayList<Integer> zigZagTraversal(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int count=0;
        while(!q.isEmpty()){
            int levelSize = q.size();
            ArrayList<Integer> lst = new ArrayList<>();
            
            for(int i=0; i<levelSize; i++){
                Node temp = q.poll();
                lst.add(temp.data);
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
            
            if(count%2 == 0){
                res.add(new ArrayList<>(lst));
            }
            else{
                Collections.reverse(lst);
                res.add(new ArrayList<>(lst));
            }
            count++;
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(ArrayList<Integer> temp: res){
            for(int i=0; i<temp.size(); i++){
                ans.add(temp.get(i));
            }
        }
        
        return ans;
    }
}
