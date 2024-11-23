/*
Given a positive integer k and an array arr[] denoting heights of towers, you have to modify the height of each tower either by increasing or decreasing them by k only once.
Find out what could be the possible minimum difference of the height of shortest and longest towers after you have modified each tower.
*/
class Solution {
    public int getMinDiff(int k, int[] arr) {
        // code here
        Arrays.sort(arr);
        int n = arr.length;
        int smallest = arr[0];
        int largest  = arr[n-1];
        int diff = largest - smallest;
    
        // Loop through the array, considering adding or subtracting k
        for (int i = 1; i < n; i++) {
            // Calculate the potential smallest and largest values
            int currentSmallest = Math.min(smallest + k, arr[i] - k); 
            int currentLargest = Math.max(largest - k, arr[i - 1] + k);
        
            // Update the minimum difference
            diff = Math.min(diff, currentLargest - currentSmallest);
        }
        
        return diff;
    }
}
