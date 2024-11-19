/*
Given an array of integers arr[] representing a permutation, implement the next permutation that rearranges the numbers into the lexicographically next greater permutation. If no such permutation exists, rearrange the numbers into the lowest possible order (i.e., sorted in ascending order). 

Note - A permutation of an array of integers refers to a specific arrangement of its elements in a sequence or linear order.
*/
class Solution {
    public void reverse(int start , int end, int arr[]){
        while(start<end){
            int temp = arr[end];
            arr[end]  = arr[start];
            arr[start] = temp;
            start++;
            end--;
        }
    }
    public void swap(int start, int end,int arr[]){
        int temp = arr[end];
        arr[end] = arr[start];
        arr[start] = temp;
        
    }
    void nextPermutation(int[] arr) {
        // code here
        int n = arr.length;
        int index = -1;
        for(int i =n-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                index =i;
                break;
            }
        }
        
        if(index==-1){
            reverse(0, n-1,arr);
            return;
        }
        
        for(int i = n-1;i>index;i--){
            if(arr[i]>arr[index]){
                swap(i,index,arr);
                break;
            }
            
        }
        reverse(index+1,n-1,arr);
            
    }
}
