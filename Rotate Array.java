/*
Given an unsorted array arr[]. Rotate the array to the left (counter-clockwise direction) by d steps, where d is a positive integer. Do the mentioned change in the array in place.

Note: Consider the array as circular.
*/
// User function Template for Java

class Solution {
    // Function to rotate an array by d elements in counter-clockwise direction.
    static void reverse(int [] arr, int st, int en){
        while(st < en){
            int temp = arr[st];
            arr[st] = arr[en];
            arr[en] = temp;
            st++;
            en--;
        }
    }
    static void rotateArr(int arr[], int k) {
        // add your code here
        int n = arr.length;
        k = k%n;
        
        if(k == 0) return;
        //Reverse firt k sub arrays
        reverse(arr, 0, k-1);
        
        //reverse subarray from k - n-1
        reverse(arr, k, n-1);
        
        //reverse whole array, 0 - n-1
        reverse(arr, 0, n-1);
    }
}
