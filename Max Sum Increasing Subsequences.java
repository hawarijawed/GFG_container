/*
Given an array of positive integers arr[], find the maximum sum of a subsequence such that the elements of the subsequence form a strictly increasing sequence.
In other words, among all strictly increasing subsequences of the array, return the one with the largest possible sum.
*/

//Brute force approach
class Solution {
    public int maxSumIS(int arr[]) {
        // code here
        int n = arr.length;
        int res[] = new int[n];
        
        for(int i=0; i<n; i++){
          res[i] = arr[i];
        }
        for(int i=1; i<n; i++){
          for(int j=0; j<i; j++){
            if(arr[j] < arr[i]){
              res[i] = Math.max(res[i], res[j] + arr[i]);
            }
          }
        } 
        int maxVal = 0;
        for(int val: res){
            maxVal = Math.max(maxVal, val);
        }
        
        return maxVal;
    }
    
}
// Optimized approach
import java.util.*;

class Solution {

    // Fenwick tree supporting range max queries
    static class Fenwick {
        int[] tree;

        Fenwick(int n) {
            tree = new int[n + 1];
        }

        void update(int index, int value) {
            while (index < tree.length) {
                tree[index] = Math.max(tree[index], value);
                index += index & -index;
            }
        }

        int query(int index) {
            int result = 0;
            while (index > 0) {
                result = Math.max(result, tree[index]);
                index -= index & -index;
            }
            return result;
        }
    }

    public int maxSumIS(int[] arr) {
        int n = arr.length;

        // Step 1: Coordinate Compression
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> rank = new HashMap<>();
        int r = 1;
        for (int val : sorted) {
            if (!rank.containsKey(val)) {
                rank.put(val, r++);
            }
        }

        // Step 2: Fenwick Tree to track max DP values
        Fenwick fenwick = new Fenwick(r);

        int maxSum = 0;

        // Step 3: Process each element
        for (int num : arr) {
            int idx = rank.get(num);

            // Best sum for numbers < num
            int bestPrev = fenwick.query(idx - 1);

            int currSum = bestPrev + num;

            // Update Fenwick Tree at compressed index
            fenwick.update(idx, currSum);

            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}

