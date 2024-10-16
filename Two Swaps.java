/*
Given a permutation of some of the first natural numbers in an array arr[], determine if the array can be sorted in exactly two swaps. A swap can involve the same pair of indices twice.

Return true if it is possible to sort the array with exactly two swaps, otherwise return false
*/
class Solution {
    public void swapOne(List<Integer> arr){
        for (int i = 0; i < arr.size(); i++) {
        if (arr.get(i) != i + 1) {
            int correctPosition = arr.get(i) - 1; // where this element should go
            // Swap only if the position is valid and different
            if (correctPosition < arr.size() && arr.get(correctPosition) != arr.get(i)) {
                Collections.swap(arr, i, correctPosition);
            }
            break; // Only one swap
        }
    }
    }
    
    public int unsortedCount(List<Integer> arr){
        int count = 0; 
        for(int i=0; i<arr.size(); i++){
            if(arr.get(i) != i+1){
                count++;
            }
        }
        
        return count;
    }
    public boolean checkSorted(List<Integer> arr) {
        // code here
        
        int unsorted = unsortedCount(arr);
        if(unsorted == 0 || unsorted == 3){
            return true;
        }
        
        if(unsorted == 4){
            swapOne(arr);
            swapOne(arr);
            
            return unsortedCount(arr) == 0;
        }
        
        return false;
    }
}
