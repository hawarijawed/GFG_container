/*
Given an array arr[] of positive integers where every element appears even times except for one. Find that number occurring an odd number of times.
*/
class Solution {
    int getSingle(int arr[]) {
        // code here
        int num = 0;
        for(int i=0; i<arr.length; i++){
            num = num ^ arr[i];
        }
        
        return num;
    }
}
