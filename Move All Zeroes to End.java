/*
Given an array arr[]. Push all the zeros of the given array to the right end of the array while maintaining the order of non-zero elements. Do the mentioned change in the array in place.
*/
class Solution {
    void pushZerosToEnd(int[] arr) {
        // code here
        int left = 0;
        for(int right = 0; right < arr.length; right++){
            if(arr[right] != 0){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
            }
        }
    }
}
