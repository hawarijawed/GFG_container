/*
Given an unsorted array arr[] and a 2D array queries[][] of size q, where each query is in the form of [a, b]. For each query, count how many elements in arr[] lie within the range [a, b], i.e., elements satisfying a ≤ x ≤ b.

Return the results for all queries as a list of integers, where each integer corresponds to the count of elements in the respective query range.
*/
class Solution {
    public ArrayList<Integer> cntInRange(int[] arr, int[][] queries) {
        // code here
        Arrays.sort(arr);
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i<queries.length; i++){
            int low = lowerBound(arr,queries[i][0]);
            int high= upperBound(arr,queries[i][1]);
            res.add(high - low);
        }
        return res;
    }
    
    private int lowerBound(int[] arr, int val) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < val)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    // First index where arr[i] > val
    private int upperBound(int[] arr, int val) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= val)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}
