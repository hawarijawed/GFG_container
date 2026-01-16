/*
You are given an array arr[], where arr[i] denotes the range of working hours a person at position i can cover.

If arr[i] ≠ -1, the person at index i can work and cover the time interval [i - arr[i], i + arr[i]].
If arr[i] = -1, the person is unavailable and cannot cover any time.
The task is to find the minimum number of people required to cover the entire working day from 0 to n - 1. If it is not possible to fully cover the day, return -1.
*/
class Solution {
    public int minMen(int arr[]) {
        // code here
        
        List<int[]> intervals = new ArrayList<>();
        int n = arr.length;
        for(int i=0; i<n; i++){
            if(arr[i] == -1) continue;
            int st = i - arr[i];
            if(st < 0) st = 0;
            
            int en = i + arr[i];
            if(en > n-1) en = n-1;
            
            intervals.add(new int[]{st, en});
        }
        
        intervals.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return b[1] - a[1];
        });
        
        int count = 0;
        int idx = 0;
        int currentEnd = 0;

        // Step 3: Greedy interval covering
        while (currentEnd < n) {
            int farthest = currentEnd;

            while (idx < intervals.size() && intervals.get(idx)[0] <= currentEnd) {
                farthest = Math.max(farthest, intervals.get(idx)[1] + 1);
                idx++;
            }

            // If we cannot extend coverage
            if (farthest == currentEnd) {
                return -1;
            }

            count++;
            currentEnd = farthest;
        }

        return count;
    }
}
