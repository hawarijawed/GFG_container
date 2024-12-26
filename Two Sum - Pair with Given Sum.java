/*
Given an array arr[] of positive integers and another integer target. Determine if there exists two distinct indices such that the sum of there elements is equals to target.
*/
class Solution {
    boolean twoSum(int arr[], int target) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            int diff = (target - arr[i]);
            if(map.containsKey(diff)) return true;
            map.put(arr[i],i);
        }
        
        return false;
    }
}
