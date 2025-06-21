/*
Given an array arr[], where each element contains either a 'P' for policeman or a 'T' for thief. Find the maximum number of thieves that can be caught by the police. 
Keep in mind the following conditions :

1. Each policeman can catch only one thief.
2. A policeman cannot catch a thief who is more than k units away from him.
*/
class Solution {
    public int catchThieves(char[] arr, int k) {
        // code here
        int n = arr.length;
        int p = 0, t = 0;
        while(p<n && arr[p] != 'P'){
            p++;
        }
        
        while(t<n && arr[t] != 'T'){
            t++;
        }
        
        int count = 0;
        while(p<n && t <n){
            if(Math.abs(p - t)<=k){
                count++;
                p++;
                t++;
            }
            else if(p<n && p<t){
                p++;
            }
            else if(t<n && t < p){
                t++;
            }
            
            while(p<n && arr[p] != 'P'){
                p++;
            }
        
            while(t<n && arr[t] != 'T'){
                t++;
            }
        }
        
        return count;
    }
}
