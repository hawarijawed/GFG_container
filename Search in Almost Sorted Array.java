/*
Given a sorted integer array arr[] consisting of distinct elements, where some elements of the array are moved to either of the adjacent positions, i.e. arr[i] may be present at arr[i-1] or arr[i+1].
Given an integer target.  You have to return the index ( 0-based ) of the target in the array. If target is not present return -1
*/

// User function Template for Java
class Solution {
    public int findTarget(int arr[], int target) {
        // code here
        int n = arr.length;
        if(n==1){
            return arr[0] == target?0:-1;
        }
        
        int left = 0, right = n-1;
        while(left <= right){
            int mid = right - (right - left)/2;
            if(arr[mid] == target){
                return mid;
            }
            
            else if(mid >0 && arr[mid-1] == target){
                return mid-1;
            }
            else if(mid<n-1 && arr[mid+1] == target){
                return mid+1;
            }
            
            else if(arr[mid]> target){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        
        return -1;
    }
}
