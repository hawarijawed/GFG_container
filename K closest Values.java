/*
Given the root of a Binary Search Tree, a target value, and an integer k. Your task is to find the k values in the BST that are closest to the target.

The closest value is taken by choosing the one that gives minimum absolute difference from target.

Note: In case two values have same absolute difference from target, choose the smaller one. The target may or may not be present in BST.
You can return the values in any order the driver code will print them in sorted order only.
*/
/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public void traverse(Node root, ArrayList<Integer> lst){
        if(root == null) return;
        traverse(root.left, lst);
        lst.add(root.data);
        traverse(root.right, lst);
    }
    public ArrayList<Integer> getKClosest(Node root, int target, int k) {
        // code here
         
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) ->{
                int diffA = Math.abs(a - target);
                int diffB = Math.abs(b - target);
                
                if(diffA == diffB) return b - a;
                return diffB - diffA;
            }
        );
        
        ArrayList<Integer> lst = new ArrayList<>();
        traverse(root, lst);
        
        for(int i=0; i<lst.size(); i++){
            pq.add(lst.get(i));
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        while(!pq.isEmpty()){
            res.add(pq.poll());
        }
        
        return res;
    }
}

/*
4 8 10 12 14 20 22

13 9 7 5 3 3 5
*/
