/*
Given an array arr[] of integers, for each element, find the closest (distance wise) to its right that has a higher frequency than the current element.
If no such element exists, return -1 for that position.
*/
class Solution {
    public ArrayList<Integer> findGreater(int[] arr) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;

        // Step 1: Count frequency of each element
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Initialize result list with -1s
        for (int i = 0; i < n; i++) {
            result.add(-1);
        }

        // Step 3: Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Maintain only elements with higher frequency in stack
            while (!stack.isEmpty() && freqMap.get(arr[stack.peek()]) <= freqMap.get(arr[i])) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result.set(i, arr[stack.peek()]);
            }

            // Push current index to stack
            stack.push(i);
        }

        return result;
        
    }
}
