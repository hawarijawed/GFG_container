/*
The n-queens puzzle is the problem of placing n queens on a (n×n) chessboard such that no two queens can attack each other.
Given an integer n, find all distinct solutions to the n-queens puzzle. Each solution contains distinct board configurations of the n-queens placement, 
where the solutions are a permutation of [1,2,3..n] in increasing order, here the number in the ith place denotes that the ith-column queen is placed in the row with that number. 
For eg below figure represents a chessboard [3 1 4 2].
*/


class Solution {
    public void backtrack(ArrayList<ArrayList<Integer>> lst, int []board, int col, int n){
        if(col == n){
            ArrayList<Integer> lst1 = new ArrayList<>();
            for(int row:board){
                lst1.add(row+1);
            }
            lst.add(lst1);
            return;
        }
        
        for(int row=0; row<n; row++){
            if(isValid(board, row, col, n)){
                board[col] = row;
                backtrack(lst, board, col+1, n);
                board[col]=-1;
            }
        }
    }
    
    public boolean isValid(int [] board, int row, int col, int n){
        for(int prevCol = 0; prevCol<col; prevCol++){
            if(board[prevCol] == row || 
                board[prevCol] - prevCol == row-col ||
                board[prevCol] + prevCol == row+col){
                    return false;
                }
        }
        
        return true;
    }
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        ArrayList<ArrayList<Integer>> lst = new ArrayList<>();
        int [] board = new int[n]; 
        backtrack(lst, board, 0, n);
        
        return lst;
        
    }
}
