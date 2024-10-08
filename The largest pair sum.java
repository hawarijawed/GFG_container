/*
Find the largest pair sum in an array of distinct integers.
*/
class Solution {
    public static int pairsum(int[] arr) {
        // code here
        int size = arr.length;
        if(size == 2){
            return arr[0]+arr[1];
        }
        
        int large = Integer.MIN_VALUE;
        int secondLarge = Integer.MIN_VALUE;
        for(int i=0; i<size; i++){
            if(arr[i] > large){
                secondLarge = large;
                large = arr[i];
            }
            if(arr[i] > secondLarge && arr[i] < large){
                secondLarge = arr[i];
            }
        }
        
        return large+secondLarge;
    }
}
