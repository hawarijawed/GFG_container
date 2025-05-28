/*
Given an n x m binary matrix mat[][] containing only 0s and 1s, determine if there exists a rectangle within the matrix such that all four corners of the rectangle are 1. 
If such a rectangle exists, return true; otherwise, return false.
*/
class Solution {
    public boolean ValidCorner(int mat[][]) {
        int n = mat.length;
        if (n == 0) return false;
        int m = mat[0].length;

        // Map to store pairs of columns where both values are 1 in the same row
        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < n; i++) {
            // For each row, check all pairs of columns
            for (int c1 = 0; c1 < m - 1; c1++) {
                if (mat[i][c1] == 1) {
                    for (int c2 = c1 + 1; c2 < m; c2++) {
                        if (mat[i][c2] == 1) {
                            int hash = c1 * m + c2; // unique hash for column pair
                            if (seen.contains(hash)) {
                                return true; // Found a previous row with same column pair
                            }
                            seen.add(hash); // Mark this column pair seen in this row
                        }
                    }
                }
            }
        }

        return false; // No such rectangle found
    }
}
