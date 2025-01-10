/*
Given an array arr[]  and a positive integer k, find the first negative integer for each and every window(contiguous subarray) of size k.

Note: If a window does not contain a negative integer, then return 0 for that window.
*/
class Solution {

    // Function to find the first negative integer in every window of size k
    static List<Integer> FirstNegativeInteger(int arr[], int k) {
        // write code here
        List<Integer> lst = new ArrayList<>();
        int n = arr.length, st = 0, en = k;
        
        while(en <= n){
            int count = 0;
            
            for(int i=st; i<en; i++){
                if(arr[i] < count){
                    count = arr[i];
                    break;
                }
            }
            
            lst.add(count);
            st++;
            en++;
        }
        
        return lst;
    }
}
