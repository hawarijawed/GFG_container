/*
You are given an array arr[] of positive integers and a threshold value k. For each element in the array, 
divide it into the minimum number of small integers such that each divided integer is less than or equal to k. 
Compute the total number of these integer across all elements of the array
*/
class Solution {
    int totalCount(int k, int[] arr) {
        // code here
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] <= k){
                sum += 1;
            }
            else{
                int factor = arr[i]/k;
                if(arr[i]%k==0){
                    sum += factor;
                }
                else{
                    sum = sum + factor+1;
                }
            }
        }
        
        return sum;
    }
}
