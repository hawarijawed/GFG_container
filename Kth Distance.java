/*
Given an unsorted array arr and a number k which is smaller than the size of the array. Return true if the array contains any duplicate within k distance throughout the array else false.
*/
class Solution {
    public boolean checkDuplicatesWithinK(int[] arr, int k) {
        // your code
        if(arr.length == 1){
            if(arr[0] == k){
                return true;
            }
            else{
                return false;
            }
        }
        
        for(int i=0; i<arr.length; i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j=i; j<=i+k && j<arr.length;j++){
                if(set.contains(arr[j])){
                    return true;
                }
                set.add(arr[j]);
            }
        }
        
        return false;
    }
}
