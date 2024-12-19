/*
Given a sorted array of distinct positive integers arr[], we need to find the kth positive number that is missing from arr[].  
*/
class Solution {
    public int kthMissing(int[] arr, int k) {
        // code here
        int n = arr.length;
        int st = 0, en = n-1;
        while(st <= en){
            int mid = st + (en - st)/2;
            
            int missing = arr[mid] - mid -1;
            if(missing < k){
                st = mid+1;
            }
            else{
                en = mid-1;
            }
        }
        
        return st + k;
    }
}
