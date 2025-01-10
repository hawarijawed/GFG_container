/*
Given an integer array arr[] and a number k. Find the count of distinct elements in every window of size k in the array.
*/
class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> lst = new ArrayList<>();
        int st = 0, en = k;
        int n = arr.length;
        while(en <= n){
            for(int i=st; i<en; i++){
                set.add(arr[i]);
            }
            
            lst.add(set.size());
            set.clear();
            st++;
            en++;
        }
        
        return lst;
    }
}
