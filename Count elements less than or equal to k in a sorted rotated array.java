/*
Given a sorted array arr[] containing distinct positive integers that has been rotated at some unknown pivot, and a value x. 
Your task is to count the number of elements in the array that are less than or equal to x.
*/
class Solution {
    public int countLessEqual(int[] arr, int x) {
        // code here
        int n = arr.length;
        int pivot = pivotIndx(arr);

        // Search in both sorted parts
        int count1 = countInSorted(arr, 0, pivot - 1, x);
        int count2 = countInSorted(arr, pivot, n - 1, x);

        return count1 + count2;
    }
    
    public int countInSorted(int[] arr, int left, int right, int x) {
        int l = left, r = right, res = left - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] <= x) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res - left + 1;
    }
    public int pivotIndx(int arr[]){
        int l = 0, r = arr.length - 1;
        
        while(l < r){
            int mid = l + (r - l)/2;
            
            if(arr[mid] > arr[r]){
                l = mid + 1;
            }
            else{
                r = mid;
            }
        }
        
        return l;
    }
}

