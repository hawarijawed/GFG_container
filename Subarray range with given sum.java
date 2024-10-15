/*
Given an unsorted array of integers arr[], and a target tar, determine the number of subarrays whose elements sum up to the target value.
*/
class Solution {
    // Function to count the number of subarrays which adds to the given sum.
    static int subArraySum(int arr[], int tar) {
        // add your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        int pre_sum = 0, count = 0;
        for(int i=0; i<arr.length; i++){
            pre_sum += arr[i];
            
            if(map.containsKey(pre_sum - tar)){
                count += map.get(pre_sum - tar);
            }
            
            if(map.containsKey(pre_sum)){
                map.put(pre_sum, map.getOrDefault(pre_sum, 0)+1);
            }
            else{
                map.put(pre_sum, 1);
            }
        }
        
        return count;
    }
}
