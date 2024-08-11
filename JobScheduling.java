/*
Given a set of n jobs where each jobi has a deadline and profit associated with it.

Each job takes 1 unit of time to complete and only one job can be scheduled at a time. We earn the profit associated with a job if and only if the job is completed by its deadline.

Find the number of jobs done and the maximum profit.
*/
class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Sorting jobs based on their profit
        Arrays.sort(arr,(a,b)-> b.profit - a.profit);
        
        //Finding max deadline
        int maxDeadline = -1;
        for(Job jobs: arr){
            maxDeadline = Math.max(maxDeadline, jobs.deadline);
        }
        
        //Building a slot availability array
        boolean [] slot = new boolean[maxDeadline+1];
        int totalJobsDone = 0;
        int totalProfit = 0;
        
        //Iterating over jobs
        for(Job job:arr){
            
            for(int j= Math.min(maxDeadline,job.deadline); j>0; j--){
                if(!slot[j]){
                    slot[j] = true;
                    totalJobsDone++;
                    totalProfit += job.profit;
                    break;
                }
            }
        }
        
        return  new int[]{totalJobsDone,totalProfit};
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/
