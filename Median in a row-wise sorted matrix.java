/*
Given a row-wise sorted matrix mat[][] of size n*m, where the number of rows and columns is always odd. Return the median of the matrix.
*/

class Solution {
    public int median(int[][] matrix) {
        // code here
        int n = matrix.length;
        int m = matrix[0].length;

        // Find the minimum and maximum elements in the matrix
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][m - 1]);
        }

        int desired = (n * m) / 2;

        // Binary search on value range
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;

            // Count how many elements are <= mid using upper_bound logic
            for (int i = 0; i < n; i++) {
                count += countLessThanOrEqual(matrix[i], mid);
            }

            if (count <= desired) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
    private static int countLessThanOrEqual(int[] row, int target) {
        int left = 0, right = row.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (row[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left; // Number of elements <= target
    }
}
