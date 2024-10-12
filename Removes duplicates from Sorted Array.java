/*
Given a sorted array arr. Return the size of the modified array which contains only distinct elements.
Note:
1. Don't use set or HashMap to solve the problem.
2. You must return the modified array size only where distinct elements are present and modify the original array such that all the distinct elements come at the beginning of the original array.
*/
class Solution {
    // Function to remove duplicates from the given array
    public int remove_duplicate(List<Integer> arr) {
        int size = arr.size();
        int i=0; 
        for(int j = 1; j<size; j++){
            if(!arr.get(i).equals(arr.get(j))){
                i++;
                arr.set(i, arr.get(j));
            }
        }
        
        return i+1;
    }
}
