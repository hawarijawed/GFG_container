/*
Given a sorted array arr[] of positive integers, find the smallest positive integer such that it cannot be represented as the sum of elements of any subset of the given array set.
*/
class Solution {
    public long findSmallest(int[] arr) {
        // Your code goes here
        if(arr[0]>1){
            return 1;
        }
        long res = 1;
        for(int i=0; i<arr.length; i++){
            if(arr[i] > res){
                return res;
            }
            else{
                res += arr[i];
            }
        }
        return res;
    }
}
