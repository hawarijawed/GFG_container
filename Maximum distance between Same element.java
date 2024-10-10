/*
Given an array arr[] with repeated elements, the task is to find the maximum distance between two occurrences of an element.
Note: You may assume that every input array has repetitions.
*/
class Solution {
    public int maxDistance(int[] arr) {
        // Code here
        HashMap<Integer, Integer> table = new HashMap<>();
        int max_dist = 0;
        for(int i=0; i<arr.length; i++){
            if(!table.containsKey(arr[i])){
                table.put(arr[i],i);
            }
            else{
                max_dist = Math.max(max_dist, i - table.get(arr[i]));
            }
        }
        
        return max_dist;
    }
}
