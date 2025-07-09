/*
Given an array arr[] of positive integers, find the total sum of the minimum elements of every possible subarrays.

Note: It is guaranteed that the total sum will fit within a 32-bit unsigned integer.
*/
class Solution {
    public int sumSubMins(int[] arr) {
        // code here
        int n = arr.length;
        int []left = new int[n];
        int []right = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        //Populating left[]
        for(int i=0; i<n; i++){
            int count = 1;
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                count = count + left[stack.pop()];
            }
            
            left[i] = count;
            stack.push(i);
        }
        
        stack.clear();
        
        for(int i = n-1; i>=0; i--){
            int count = 1;
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                count = count + right[stack.pop()];
            }
            right[i] = count;
            stack.push(i);
        }
        
        int res = 0;
        for(int i=0; i<n; i++){
            res += left[i]*right[i]*arr[i];
        }
        
        return res;
    }
}
