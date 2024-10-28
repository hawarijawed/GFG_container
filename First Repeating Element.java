/*
Given an array arr[], find the first repeating element. The element should occur more than once and the index of its first occurrence should be the smallest.

Note:- The position you return should be according to 1-based indexing.
*/
class Solution {
    // Function to return the position of the first repeating element.
    public static int firstRepeated(int[] arr) {
        // Your code here
        int index = -1;
        int repeated = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int a: arr){
            map.put(a, map.getOrDefault(a, 0)+1);
            
        }
        for(int i=0; i<arr.length; i++){
            if(map.get(arr[i]) > 1){
                return i+1;
            }
        }
        
        return index;
    }
}
