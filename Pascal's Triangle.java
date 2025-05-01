/*
Given a positive integer n, return the nth row of pascal's triangle.
Pascal's triangle is a triangular array of the binomial coefficients formed by summing up the elements of previous row.
*/

class Solution {

    ArrayList<Integer> nthRowOfPascalTriangle(int n) {
        // code here
        ArrayList<Integer> row = new ArrayList<>();
        row.add(1); // C(n, 0) = 1

        long prev = 1;
        for (int k = 1; k < n; k++) {
            // Compute C(n-1, k) based on C(n-1, k-1)
            prev = prev * (n - k) / k;
            row.add((int) prev); // Cast to int since ArrayList holds Integer
        }
        
        return row;
    }
}
