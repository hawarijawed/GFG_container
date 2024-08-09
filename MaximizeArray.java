/******************************************************************************
Given an array arr of n integers. Your task is to write a program to find the maximum value of ∑arr[i]*i, where i = 0, 1, 2,., n-1.
You are allowed to rearrange the elements of the array.

Note: Since the output could be large, print the answer modulo 10^9+7.

*******************************************************************************/

class Solution {
    int Maximize(int arr[]) {
        // Complete the function
        Arrays.sort(arr);
        int mod=1000000007;
        long i=0;
        long sum=0L;
        for(int j:arr){
            sum=(sum+(long)(j)*i)%mod;
            i++;
        }
        return (int)sum%mod;
    }
}