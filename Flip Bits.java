/*
Given an array A[] consisting of 0’s and 1’s. A flip operation is one in which you turn 1 into 0 and a 0 into 1. You have to do at most one “Flip” operation of any subarray. 
Formally, select a range (l, r) in the array A[], such that (0 ≤ l ≤ r < n) holds and flip the elements in this range to get the maximum ones in the final array. 
You can possibly make zero operations to get the answer. You are asked to return the maximum number of 1 you can get in the array after doing flip operation.
*/
class Solution {

    public static int maxOnes(int a[], int n) {
        // Your code goes here
        int count_1 = 0;
        for(int i=0; i<n; i++){
            if(a[i] == 0){
                a[i] = 1;
                
            }
            else{
                a[i] = -1;
                count_1++;
            }
        }
        
        int total_sum = Integer.MIN_VALUE;
        int curr_sum = 0;
        for(int i=0; i<n; i++){
            curr_sum += a[i];
            if(curr_sum < 0){
                curr_sum = 0;
            }
            total_sum = Math.max(total_sum, curr_sum);
            
        }
        
        return total_sum+count_1;
    }
}
