/*
Given an array arr[]. Find the majority element in the array. If no majority element exists, return -1.

Note: A majority element in an array is an element that appears strictly more than arr.size()/2 times in the array.
*/

class Solution {
    static int majorityElement(int arr[]) {
        // code here
        int n = arr.length;
        
        if(n<=2){
            if(n==1) return arr[0];
            return -1;
        }
        int candidate = -1;
        int votes = 0;
        for(int i=0; i<n; i++){
            if(votes == 0){
                candidate = arr[i];
                votes++;
            }
            else{
                if(candidate == arr[i]){
                    votes++;
                }
                else{
                    votes--;
                }
            }
        }
        
        int count = 0;
        for(int i=0; i<n; i++){
            if(candidate == arr[i]){
                count++;
            }
        }
        
        if(count > n/2){
            return candidate;
        }
        
        return -1;
    }
}
