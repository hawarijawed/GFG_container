/*
You are given a 2D matrix mat[][] of size n×m. The task is to modify the matrix such that if mat[i][j] is 0, all the elements in the i-th row and j-th column are set to 0 and do it in constant space complexity.
*/
// Step 5: Zero out the columns based on the first row
        for (int j = 1; j < col; j++) {
            if (mat[0][j] == 0) {
                for (int i = 1; i < row; i++) {
                    mat[i][j] = 0;
                }
            }
        }

        // Step 6: Zero out the first row if needed
        if (firstRowZero) {
            for (int j = 0; j < col; j++) {
                mat[0][j] = 0;
            }
        }

        // Step 7: Zero out the first column if needed
        if (firstColZero) {
            for (int i = 0; i < row; i++) {
                mat[i][0] = 0;
            }
        }
