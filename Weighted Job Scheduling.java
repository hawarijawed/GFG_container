/*
Given a 2D array jobs[][] of size n × 3, where each row represents a single job with the following details:

jobs[i][0] : Start time of the job
jobs[i][1] : End time of the job
jobs[i][2] : Profit earned by completing the job
Find the maximum profit you can earn by scheduling non-overlapping jobs.

Note: Two jobs are said to be non-overlapping if the end time of one job is less than or equal to the start time of the next job. If a job ends at time X, another job can start exactly at time X.
*/
class Solution {
    static class Job {
        int start, end, profit;

        Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }
    public int maxProfit(int[][] jobsArr) {
        // code here
        int n = jobsArr.length;

        // Convert to Job objects
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(jobsArr[i][0], jobsArr[i][1], jobsArr[i][2]);
        }

        // Step 1: Sort jobs by end time
        Arrays.sort(jobs, Comparator.comparingInt(j -> j.end));

        // Step 2: DP array
        int[] dp = new int[n];
        dp[0] = jobs[0].profit;

        for (int i = 1; i < n; i++) {
            // Include current job's profit
            int profitIncl = jobs[i].profit;

            // Step 3: Find the last non-conflicting job using binary search
            int l = findLastNonConflicting(jobs, i);
            if (l != -1) {
                profitIncl += dp[l];
            }

            // Step 4: Choose max of including or excluding current job
            dp[i] = Math.max(dp[i - 1], profitIncl);
        }

        // Step 5: The last value is the result
        return dp[n - 1];
    }
    
    private static int findLastNonConflicting(Job[] jobs, int index) {
        int low = 0, high = index - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (jobs[mid].end <= jobs[index].start) {
                // check if the next job also does not conflict
                if (mid + 1 < index && jobs[mid + 1].end <= jobs[index].start)
                    low = mid + 1;
                else
                    return mid;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}

/*
1 -> 2 profit-50
3 -> 5 profit-20
6 ->19 profit-100
2 ->100 profit-200

*/
