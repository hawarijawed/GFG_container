/*
You are given an array arr[] of size n - 1 that contains distinct integers in the range from 1 to n (inclusive). This array represents a permutation of the integers from 1 to n with one element missing. 
Your task is to identify and return the missing element.
*/

class Solution {
    int missingNum(int arr[]) {
        // code here
        long sum = 0;
        int n = arr.length;
        for(int val: arr){
            sum += val;
        }
        
        long actual_sum = (long) (n+1)*(n+2)/2;
        
        return (int)(actual_sum - sum);
    }
}
