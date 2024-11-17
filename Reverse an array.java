/*
You are given an array of integers arr[]. Your task is to reverse the given array.
*/
class Solution {
    public void reverseArray(int arr[]) {
        // code here
        int n = arr.length;
        for(int i=0; i<n/2; i++){
            int temp = arr[i];
            arr[i] = arr[n-i-1];
            arr[n-i-1] = temp;
        }
    }
}
