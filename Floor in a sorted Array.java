/*
Given a sorted array arr[] of size n without duplicates, and given a value x. Floor of x is defined as the largest element k in arr[] such that k is smaller than or equal to x. Find the index of k(0-based indexing).
*/
class Solution {

    // Function to find floor of x
    // arr: input array
    // n is the size of array
    static int binarySearch(long arr[], int st, int en, long x){
        int floorIndex = -1;
        while(st <= en){
            int mid = st + (en - st)/2;
            if(arr[mid] == x){
                return mid;
            }
            else if(arr[mid] > x){
                en = mid-1;
            }
            else{
                floorIndex = mid;
                st = mid+1;
            }
        }
        return floorIndex;
    }
    static int findFloor(long arr[], int n, long x) {
        if(arr[0]>x){
            return -1;
        }
        
        return binarySearch(arr, 0, n-1, x);
    }
}
