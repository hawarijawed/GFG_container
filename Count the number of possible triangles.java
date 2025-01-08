/*
Given an integer array arr[]. Find the number of triangles that can be formed with three different array elements as lengths of three sides of the triangle. 

A triangle with three given sides is only possible if sum of any two sides is always greater than the third side.
*/
class Solution {
    // Function to count the number of possible triangles.
    static int countTriangles(int arr[]) {
        // code here
        Arrays.sort(arr);
        int n = arr.length;
        int count = 0;
        
        for (int k = 2; k < n; k++) {
            int i = 0;
            int j = k - 1;
            
            // Use two pointers to check pairs (i, j) for valid triangles
            while (i < j) {
                // Check if arr[i] + arr[j] > arr[k]
                if (arr[i] + arr[j] > arr[k]) {
                    // All pairs (arr[i], arr[j], arr[k]), (arr[i], arr[j-1], arr[k]), ..., (arr[i], arr[i+1], arr[k]) are valid
                    count += (j - i);
                    j--;
                } else {
                    i++;
                }
            }
        }
        
        return count;
    }
}
