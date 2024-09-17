/*
Given an array arr[] denoting heights of N towers and a positive integer K.
For each tower, you must perform exactly one of the following operations exactly once.
Increase the height of the tower by K
Decrease the height of the tower by K
Find out the minimum possible difference between the height of the shortest and tallest towers after you have modified each tower.

You can find a slight modification of the problem here.
Note: It is compulsory to increase or decrease the height by K for each tower. After the operation, the resultant array should not contain any negative integers
*/

// User function Template for Java

class Solution {
    int getMinDiff(int[] arr, int k) {
        // code here
        int n = arr.length;
        //Edge case
        if(n==1){
            return 0;
        }
        
        Arrays.sort(arr);
        //Initial difference between largest and lowest element
        int ans = arr[n-1] - arr[0];
        
        //Initial smallest and largest value after adding and subtracting k
        int smallest = arr[0] + k;
        int largest = arr[n-1] - k;
        
        for(int i=0; i<n-1; i++){
            int minHeight = Math.min(smallest, arr[i+1]-k);
            int maxHeight = Math.max(largest, arr[i] + k);
            
            if(minHeight<0){
                continue; //Skip negative values;
            }
            
            ans = Math.min(ans, maxHeight - minHeight);
        }
        
        return ans;
    }
}
