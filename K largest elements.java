/*
Given an array arr[] of positive integers and an integer k, Your task is to return k largest elements in decreasing order. 
*/
class Solution {
    public ArrayList<Integer> kLargest(int[] arr, int k) {
        // Your code here
        ArrayList<Integer> lst = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length;
        for(int i=0; i<k; i++){
            lst.add(arr[n-1-i]);
        }
        
        return lst;
    }
}
