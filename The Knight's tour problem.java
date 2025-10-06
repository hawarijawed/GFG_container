/*
You are given an integer n, there is a n × n chessboard with a Knight starting at the top-left corner (0, 0). Your task is to determine a valid Knight's Tour, where the Knight visits every square exactly once, following the standard movement rules of a chess Knight (two steps in one direction and one step perpendicular), for example if a Knight is placed at cell (2, 2), in one move it can move to any of the following cells: (4, 3), (4, 1), (0, 3), (0, 1), (3, 4), (3, 0), (1, 4) and (1, 0).

You have to return the order in which each cell is visited. If a solution exists, return the sequence of numbers (starting from 0) representing the order of visited squares. If no solution is possible, return an empty list.

Note: You can return any valid ordering, if it is correct the driver code will print true else it will print false.
*/
class Solution {
    int dr[] = {2, 1, -1, -2, -2, -1, 1, 2};
    int dc[] = {1, 2, 2, 1, -1, -2, -2, -1};
    
    boolean helper(ArrayList<ArrayList<Integer>> board, int n, int r, int c, boolean isV[][] , int s) {
        if(r < 0 || c<0 || r>=n ||c>=n || isV[r][c] ) return false;
        board.get(r).set(c,s);
        isV[r][c]= true;
        if(s == (n*n)-1) return true;
        for(int i =0 ; i < 8 ; i++)
            if(helper(board, n, r+dr[i], c+dc[i] ,isV, s+1))
                return true;
        isV[r][c]= false;
        return false;
    }
    
    public ArrayList<ArrayList<Integer>> knightTour(int n) {
        ArrayList<ArrayList<Integer>> board = new ArrayList<>(n);
        for(int i = 0; i < n; ++i)
            board.add(new ArrayList<>(n));
        for(int i = 0; i < n; ++i)
            for(int j = 0; j < n; ++j)
                board.get(i).add(-1);
        if(!helper(board, n, 0, 0, new boolean[n][n] ,0))
            board = new ArrayList<>();
        return board;
    }
}

/*

1  2  3  4  5 
6  7  8  9  10
11 12 13 14 15
16 17 18 19 20
21 22 23 24 25

*/
