/*
Given an array arr[] containing only non-negative integers, your task is to find a continuous subarray (a contiguous sequence of elements) whose sum equals a specified value target. You need to return the 1-based indices of the leftmost and rightmost elements of this subarray. You need to find the first subarray whose sum is equal to the target.

Note: If no such array is possible then, return [-1].
*/
class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
        ArrayList<Integer> lst = new ArrayList<>();
        int n = arr.length;
        int st = 0, en = 1;
        int sum = 0;
       
        //Calculate prefix sum
        for(int i=0; i<n; i++){
            sum += arr[i];
            if(sum > target){
                en = i;
                while(st < en && sum > target){
                    sum -= arr[st];
                    st++;
                }
            }
            if(sum == target){
                en = i;
                lst.add(st+1);
                lst.add(en+1);
                return lst;
            }
        }
        
        lst.add(-1);
        return lst;
    }
}
