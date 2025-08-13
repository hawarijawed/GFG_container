/*
You are given an array arr[] of size n, where arr[i] represents the number of soldiers in the i-th troop. You are also given an integer k. 
A troop is considered "lucky" if its number of soldiers is a multiple of k. Find the minimum total number of soldiers to add across all troops so that at least ⌈n / 2⌉ troops become lucky.
*/
class Solution {
    public int minSoldiers(int[] arr, int k) {
        // code here
        int n = arr.length;
        int [] res = new int[n];
        for(int i=0; i<n; i++){
            res[i] = (k - (arr[i] % k)) % k;
        }
        
        Arrays.sort(res);
        int minSum = 0;
        int val = (int)Math.ceil((n/2.0));
        for(int i=0; i<val; i++){
            minSum += res[i];
        }
        
        return minSum;
    }
}

/*

[3, 5, 6, 7, 9, 10]
[1, 3, 2, 1, 3, 3] -> [1, 1, 2, 3, 3, 3]

*/
