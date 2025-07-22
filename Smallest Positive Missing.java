/*
You are given an integer array arr[]. Your task is to find the smallest positive number missing from the array.

Note: Positive number starts from 1. The array can have negative integers too.
*/

class Solution {
    public int missingNumber(int[] arr) {
        // code here
        HashSet<Integer> set = new HashSet<>();
        for(int val: arr){
            set.add(val);
        }
        
        int missing = 1;
        while(true){
            if(!set.contains(missing)){
                break;
            }
            else{
                missing++;
            }
        }
        
        return missing;
    }
}
