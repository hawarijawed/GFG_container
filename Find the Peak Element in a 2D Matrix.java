/*
Given a 2D matrix mat[][], identify any peak element within the matrix.

An element is considered a peak if it is greater than or equal to its four immediate neighbors: top, bottom, left, and right. For corner and edge elements, any missing neighbors are treated as having a value of negative infinity.

Note: A peak element is not necessarily the global maximum, it only needs to satisfy the condition relative to its adjacent elements. Multiple peak elements may exist, return any one of them.
Note that the driver code will print true if you return the correct position of peak element, else it will print false.
*/
class Solution {
    public ArrayList<Integer> findPeakGrid(int[][] mat) {
        // code here
        int rows = mat.length;
        int cols = mat[0].length;

        int left = 0, right = cols - 1;
        ArrayList<Integer> res = new ArrayList<>();

        while (left <= right) {
            int midCol = left + (right - left) / 2;

            // Find the row index of the maximum element in mid column
            int maxRow = 0;
            for (int i = 0; i < rows; i++) {
                if (mat[i][midCol] > mat[maxRow][midCol]) {
                    maxRow = i;
                }
            }

            int leftVal = (midCol - 1 >= 0)
                    ? mat[maxRow][midCol - 1]
                    : Integer.MIN_VALUE;

            int rightVal = (midCol + 1 < cols)
                    ? mat[maxRow][midCol + 1]
                    : Integer.MIN_VALUE;

            // Check peak condition
            if (mat[maxRow][midCol] >= leftVal &&
                mat[maxRow][midCol] >= rightVal) {

                res.add(maxRow);
                res.add(midCol);
                return res; // IMPORTANT: stop once peak is found
            }
            // Move search space
            else if (leftVal > mat[maxRow][midCol]) {
                right = midCol - 1;
            } else {
                left = midCol + 1;
            }
        }

        return res;
    }
}
