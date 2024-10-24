/*
Given an array of integers. Find the Inversion Count in the array.  Two elements arr[i] and arr[j] form an inversion if arr[i] > arr[j] and i < j.

Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If the array is already sorted then the inversion count is 0.
If an array is sorted in the reverse order then the inversion count is the maximum. 
*/
// User function Template for Java

class Solution {
    // arr[]: Input Array
    // N : Size of the Array arr[]
    // Function to count inversions in the array.
    static int merge(int []arr, int st, int mid, int en){
        int count = 0;
        int n1 = mid-st+1;
        int n2 = en-mid;
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        
        for(int i=0; i<n1; i++){
            arr1[i] = arr[st + i];
        }
        for(int i=0; i<n2; i++){
            arr2[i] = arr[mid+i+1];
        }
        
        int i=0, j=0, k=st;
        while(i<n1 && j<n2){
            if(arr1[i] <= arr2[j]){
                arr[k] = arr1[i];
                i++;
            }
            else{
                arr[k] = arr2[j];
                count+= n1-i;
                j++;
            }
            k++;
        }
        
        while(i<n1){
            arr[k] = arr1[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k] = arr2[j];
            j++;
            k++;
        }
        
        return count;
    }
    static int mergeSort(int [] arr, int st, int en){
        int res = 0;
        if(st < en){
            int mid = st + (en-st)/2;
            res += mergeSort(arr, st, mid);
            res += mergeSort(arr, mid+1, en);
            res += merge(arr, st, mid, en);
        }
        
        return res;
    }
    static int inversionCount(int arr[]) {
        // Your Code Here
        return mergeSort(arr, 0, arr.length-1);
    }
}
