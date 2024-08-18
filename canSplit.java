/*
Given an array of integers arr, return true if it is possible to split it in two subarrays (without reordering the elements), such that the sum of the two subarrays are equal. If it is not possible then return false.
*/

class Solution {
    public boolean canSplit(int arr[]) {
        // code here
        long sum = 0;
        int size = arr.length;
        for(int i=0;i<size;i++){
            sum += arr[i];
        }
        long total = sum;
        //If total sum is odd then array can not be split into two sub arrays
        if(total%2==1){
            return false;
        }
        for(int i=0; i<size;i++){
            sum -= arr[i];
            if(sum == total/2 && i<size-1){
                return true;
            }
        }
        
        return true;
    }
}
