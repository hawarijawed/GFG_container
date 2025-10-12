/*
You are given the root of a binary tree with n nodes, where each node contains a certain number of candies, and the total number of candies across all nodes is n. In one move, you can select any two adjacent nodes and transfer one candy from one node to the other. The transfer can occur between a parent and child in either direction.

The task is to determine the minimum number of moves required to ensure that every node in the tree has exactly one candy.

Note: The testcases are framed such that it is always possible to achieve a configuration in which every node has exactly one candy, after some moves.
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
    public int distCandy(Node root) {
        // code here
        int moves[] = new int[1];
        int balance = dfs(root, moves);
        return moves[0];
    }
    
    public int dfs(Node root, int[] move){
        if(root == null){
            return 0;
        }
        
        int leftBalance = dfs(root.left, move);
        int rightBalance = dfs(root.right, move);
        
        move[0] += Math.abs(leftBalance) + Math.abs(rightBalance);
        int balance = root.data + (leftBalance) + (rightBalance) -1;
        
        return balance;
    }
}
