/*
Given an array of elements arr[] with indices ranging from 0 to arr.size() - 1, your task is to write a program that rearranges the elements of the array such that arr[i] = i. 
If an element i is not present in the array, -1 should be placed at the corresponding index.
*/
class Solution {
    public List<Integer> rearrange(List<Integer> arr) {
        // Code here
        List<Integer> list = new ArrayList<>(0);
        int size = arr.size();
        for(int i=0; i<size; i++){
            list.add(-1);
        }
        for(int i=0; i<size; i++){
            
            if(arr.get(i) != -1){
                list.set(arr.get(i),arr.get(i));
            }
        }
        
        return list;
    }
}
