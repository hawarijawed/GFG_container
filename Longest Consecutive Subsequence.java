/*
Given an array arr[] of non-negative integers. Find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.
*/
class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        // code here
       int n = arr.length;
       if(n==1) return 1;
       
       int [] res = new int[100001];
       Arrays.fill(res, -1);
       for(int i=0; i <n;i++){
           res[arr[i]] = 1;
       }
       
       int count = 0;
       int longestCount = 1;
       for(int i=0; i<res.length; i++){
           if(res[i] == 1){
               count++;
           }
           else{
               longestCount = Math.max(longestCount, count);
               count = 0;
           }
       }
       return longestCount;
       
    }
}
