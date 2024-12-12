/*
Given a sorted array, arr[] and a number target, you need to find the number of occurrences of target in arr[]. 
*/
class Solution {
    int countFreq(int[] arr, int target) {
        // code here
        int count = 0;
        int n = arr.length;
        if(n==1){
            return arr[0]==target?1:count;
        }
        
        int mid = n/2;
        if(arr[mid]<target){
            for(int i=mid+1; i<n; i++){
                if(arr[i] == target){
                    count++;
                }
            }
            return count;
        }
        
        if(arr[mid]>target){
            for(int i=mid-1; i>=0; i--){
                if(arr[i] == target){
                    count++;
                }
            }
            return count;
        }
        
        if(arr[mid] == target){
            //Left search
            int temp = mid;
            while(temp >= 0 && arr[temp]== target){
                count++;
                temp--;
            }
            
            //Right Search
            temp = mid+1;
            while(temp < n && arr[temp]== target){
                count++;
                temp++;
            }
            
        }
        
        return count;
    }
}
