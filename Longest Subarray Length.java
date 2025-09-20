/*
You are given an array of integers arr[]. Your task is to find the length of the longest subarray such that all the elements of the subarray are smaller than or equal to the length of the subarray.
*/

class Solution {
    public static int longestSubarray(int[] arr) {
        // code here
         int n = arr.length;
        int maxLen = 0;

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i <= n; i++) {
            int nge = (i == n ? Integer.MAX_VALUE : arr[i]);

            while (!st.isEmpty() && arr[st.peek()] < nge) {
                int curr = arr[st.pop()];
                int len = st.isEmpty() ? i : i - st.peek() - 1;

                if (len >= curr) {
                    maxLen = Math.max(maxLen, len);
                }
            }

            st.push(i);
        }

        return maxLen;
    }
}
