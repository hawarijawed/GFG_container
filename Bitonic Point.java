/*
Given an array of integers arr[] that is first strictly increasing and then maybe strictly decreasing, find the bitonic point, that is the maximum element in the array.
Bitonic Point is a point before which elements are strictly increasing and after which elements are strictly decreasing.

Note: It is guaranteed that the array contains exactly one bitonic point.
*/
class Solution {
    public int findMaximum(int[] arr) {
        // code here
        int left = 0;
    int right = arr.length - 1;
    
    while (left <= right) {  // Use <= to check the last element properly
        int mid = left + (right - left) / 2;
        
        // Ensure mid is not at the boundary before accessing neighbors
        if (mid > 0 && mid < arr.length - 1) {
            // Check if mid is the bitonic point (local maximum)
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return arr[mid];
            }
            // If the array is still increasing
            else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            }
            // If the array is decreasing
            else {
                right = mid - 1;
            }
        } 
        else {
            // Edge cases: when mid is at the boundary
            if (mid == 0) {
                return arr[0] > arr[1] ? arr[0] : arr[1];
            } else {
                return arr[arr.length - 1];
            }
        }
    }
    
    return -1;
    }
}
