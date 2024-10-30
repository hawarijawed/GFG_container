/*
Given an array arr[] of positive integers. Find the number of pairs of integers whose difference equals a given number k.
Note: (a, b) and (b, a) are considered the same. Also, the same numbers at different indices are considered different.
*/
class Solution {
    int countPairsWithDiffK(int[] arr, int k) {
        // code here
         int cnt = 0;
       Map<Integer, Integer> map = new HashMap<>();
       for(int i: arr){
           map.put(i, map.getOrDefault(i, 0)+1);
       }
       for(int i: arr){
           if(map.containsKey(i-k)){
               cnt += map.get(i-k);
           }
       }
       return cnt;
    }
}
