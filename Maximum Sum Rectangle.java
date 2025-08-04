/*
Given a 2D matrix mat[][] with dimensions n×m. Find the maximum possible sum of any submatrix within the given matrix.
*/
class Solution {
     
    public int kadane(int[] temp) {
        int rows = temp.length;
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < rows; i++) {
            currSum += temp[i];

            // Update maxSum if the current sum is greater
            if (maxSum < currSum) {
                maxSum = currSum;
            }

            // If the current sum becomes negative, reset it
            // to 0
            if (currSum < 0) {
                currSum = 0;
            }
        }

        return maxSum;
    }
    
    public int maxRectSum(int mat[][]) {
        // code here
        int rows = mat.length;
        int cols = mat[0].length;

        int maxSum = Integer.MIN_VALUE;

        // Initialize a temporary array to store row-wise
        // sums between left and right boundaries
        int[] temp = new int[rows];

        // Check for all possible left and right boundaries
        for (int left = 0; left < cols; left++) {
          
            // Reset the temporary array for each new left
            // boundary
            for (int i = 0; i < rows; i++) {
                temp[i] = 0;
            }

            for (int right = left; right < cols; right++) {
              
                // Update the temporary array with the
                // current column's values
                for (int row = 0; row < rows; row++) {
                    temp[row] += mat[row][right];
                }

                // Find the maximum sum of the subarray for
                // the current column boundaries
                int sum = kadane(temp);

                // Update the maximum sum found so far
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
};
