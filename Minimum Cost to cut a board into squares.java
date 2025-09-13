/*
Given a board of dimensions n × m that needs to be cut into n*m squares. The cost of making a cut along a horizontal or vertical edge is provided in two arrays:

x[]: Cutting costs along the vertical edges (length-wise).
y[]: Cutting costs along the horizontal edges (width-wise).
Find the minimum total cost required to cut the board into squares optimally.

*/

class Solution {
    public static int minCost(int n, int m, int[] x, int[] y) {
        // code here
        Arrays.sort(x);
        Arrays.sort(y);
        reverse(x);
        reverse(y);

        int i = 0, j = 0;
        int horizontalPieces = 1, verticalPieces = 1;
        int totalCost = 0;

       
        while (i < x.length && j < y.length) {
            if (x[i] >= y[j]) {
                
                totalCost += x[i] * horizontalPieces;
                verticalPieces++;
                i++;
            } else {
               
                totalCost += y[j] * verticalPieces;
                horizontalPieces++;
                j++;
            }
        }

        
        while (i < x.length) {
            totalCost += x[i] * horizontalPieces;
            verticalPieces++;
            i++;
        }

        
        while (j < y.length) {
            totalCost += y[j] * verticalPieces;
            horizontalPieces++;
            j++;
        }

        return totalCost;
    }
    
     private static void reverse(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
