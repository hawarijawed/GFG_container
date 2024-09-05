/*
Given an array arr of size n−1 that contains distinct integers in the range of 1 to n (inclusive), find the missing element. The array is a permutation of size n with one element missing.
Return the missing element.
*/
// User function Template for Java
class Solution {

    // Note that the size of the array is n-1
    int missingNumber(int n, int arr[]) {

        // Your Code Here
        int sum1 = 0;
        int sum2 = 0;
        for(int a : arr){
            sum1 += a;
        }
        
        for(int i=1; i<=n; i++){
            sum2 += i;
        }
        
        return sum2-sum1;
    }
}
