/*
Given an array arr[] of distinct positive integers. Your task is to find the largest subset such that for every pair of elements (x, y) in the subset, either x divides y or y divides x.
Note : If multiple subsets of the same maximum length exist, return the one that is lexicographically greatest, after sorting the subset in ascending order.
*/
class Solution {
    public ArrayList<Integer> largestSubset(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);  // Step 1: Sort the array

        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            dp.add(new ArrayList<>());
        }

        ArrayList<Integer> maxSubset = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> maxList = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    if (dp.get(j).size() > maxList.size() ||
                       (dp.get(j).size() == maxList.size() &&
                        isLexGreater(dp.get(j), maxList))) {
                        maxList = dp.get(j);
                    }
                }
            }
            dp.get(i).addAll(maxList);
            dp.get(i).add(arr[i]);

            if (dp.get(i).size() > maxSubset.size() ||
               (dp.get(i).size() == maxSubset.size() &&
                isLexGreater(dp.get(i), maxSubset))) {
                maxSubset = new ArrayList<>(dp.get(i));
            }
        }

        return maxSubset;
    }

    // Helper function to compare lexicographically
    private boolean isLexGreater(ArrayList<Integer> a, ArrayList<Integer> b) {
        for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) > b.get(i);
            }
        }
        return a.size() > b.size();
    }
}
