/*
Given a binary array arr[] containing only 0s and 1s and an integer k, you are allowed to flip at most k 0s to 1s. Find the maximum number of consecutive 1's that can be obtained in the array after performing the operation at most k times.
*/

class Solution {
    public int maxOnes(int arr[], int k) {
        // code here
        
        int n = arr.length;
        
        int left = 0;
        int right = 0;
        int zero = 0;
        int final_res = 0;
        for(right = 0; right <n; right++){
            if(arr[right] == 0){
                zero++;
            }
            while(zero > k){
                if(arr[left] == 0) zero--;
                left++;
            }
            
            final_res = Math.max(final_res, right - left +1);
        }
        return final_res;
    }
}
