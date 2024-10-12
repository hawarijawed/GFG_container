/*
The equilibrium index of an array is an index such that the sum of elements at the left indexes is equal to the sum of elements at the right indexes. 
Given an array arr, your task is to find the index of the first Equilibrium point in the array. If there is no equilibrium point then return -1.
*/
class Solution {
    int findEquilibrium(int[] arr) {
        // code
        long totalSum = 0;
        for(int i=0; i<arr.length; i++){
            totalSum += arr[i];
        }
        long leftSum = 0;
        for(int i=0; i<arr.length; i++){
            long rightSum = totalSum - leftSum - arr[i];
            
            if(leftSum == rightSum){
                return i;
            }
            
            leftSum += arr[i];
        }
        
        return -1;
    }
}
