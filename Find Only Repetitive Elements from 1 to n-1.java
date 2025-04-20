/*
Given an array arr[] of size n, filled with numbers from 1 to n-1 in random order. The array has only one repetitive element. Your task is to find the repetitive element.
*/
class Solution {
    public int findDuplicate(int[] arr) {
        // code here
        long sum = 0;
        int n = arr.length;
        for(int i=0; i<n; i++){
            sum += arr[i];
        }
        
        long full_sum = (long) (n-1)*(n)/2;
        
        return (int)Math.abs(full_sum - sum);
    }
}
