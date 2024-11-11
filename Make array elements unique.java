/*
Given an array arr[ ], your task is to find the minimum number of increment operations required to make all the elements of the array unique. i.e.- no value in the array should occur more than once. 
In one operation, a value can be incremented by 1 only.
*/
class Solution {
    public int minIncrements(int[] arr) {
        // Code here
        Arrays.sort(arr);
        int count = 0;
        for(int i=1; i<arr.length; i++){
            if (arr[i] <= arr[i - 1]) {
                // If the current element is not greater than the previous one,
                // increment it to make it unique
                int increment = arr[i - 1] - arr[i] + 1;
                arr[i] += increment;
                count += increment;
            }
            
        }
        
        return count;
    }
}
