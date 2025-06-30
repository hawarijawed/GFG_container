/*
Given a garden with n flowers planted in a row, that is represented by an array arr[], where arr[i] denotes the height of the ith flower.You will water them for k days. In one day you can water w continuous flowers. 
Whenever you water a flower its height increases by 1 unit. You have to maximize the minimum height of all flowers after  k days of watering.
*/

class Solution {
    public int maxMinHeight(int[] arr, int k, int w) {
        // code here
        int low = arr[0];
        int high = arr[0];
        int n = arr.length;
        for(int i=0; i<n; i++){
            if(arr[i] <= low){
                low = arr[i];
            }
            if(arr[i] >= high){
                high = arr[i];
            }
        }
        
        high += k;
        
        int ans = low;
        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(canAchieve(arr, k, w, mid)){
                ans = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        
        return ans;
    }
    
    public boolean canAchieve(int [] arr, int k, int w, int target){
        int waterUsed = 0;
        int n = arr.length;
        int [] diff = new int[n+1];
        int currAdd = 0;
        
        for(int i=0; i<n; i++){
            currAdd += diff[i];
            int currHeight = currAdd + arr[i];
            
            if(currHeight < target){
                int toAdd = target - currHeight;
                waterUsed += toAdd;
                if(waterUsed > k){
                    return false;
                }
                
                currAdd += toAdd;
                if(i + w < n){
                    diff[i + w] -= toAdd;
                }
                
            }
        }
        
        return true;
    }
}
