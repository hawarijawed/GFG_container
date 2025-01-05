/*
Given an array arr[] and an integer target. You have to find the number of pairs in the array whose sum is strictly less than the target.
*/
class Solution {
    int countPairs(int arr[], int target) {
        // Your code here
        Arrays.sort(arr);
        int count = 0;
        int n = arr.length;
        
        int st = 0, en = n-1;
        while(st<en){
            int sum = arr[st] + arr[en];
            if(sum >= target) en--;
            if(sum < target){
                 count += en - st;
                 st++;
            }
        }
        
        return count;
    }
}
