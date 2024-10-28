/*
You are given an array arr[] containing positive integers. These integers can be from 1 to p, and some numbers may be repeated or absent. Your task is to count the frequency of all numbers that lie in the range 1 to n.

Note:
Do modify the array in-place changes in arr[], such that arr[i] = frequency(i) and assume 1-based indexing.
The elements greater than n in the array can be ignored when counting.
*/
class Solution {
    // Function to count the frequency of all elements from 1 to N in the array.
    public static void frequencyCount(int arr[], int N, int P) {
        // do modify in the given array
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int a: arr){
            if(a > N){
                continue;
            }
            map.put(a, map.getOrDefault(a, 0)+1);
        }
        
        for(int i=1; i<=N; i++){
            if(map.containsKey(i)){
                arr[i-1] = map.get(i);
            }
            else if(!map.containsKey(i)){
                arr[i-1] = 0;
            }
        
        }
    }
}
