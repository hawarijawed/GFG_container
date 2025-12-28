/*
Geek is organizing a party at his house. For the party, he needs exactly n donuts for the guests. Geek decides to order the donuts from a nearby restaurant, which has m chefs and each chef has a rank r.
A chef with rank r can make 1 donut in the first r minutes, 1 more donut in the next 2r minutes, 1 more donut in the next 3r minutes, and so on.
For example, a chef with rank 2, can make one donut in 2 minutes, one more donut in the next 4 minutes, and one more in the next 6 minutes. So, it take 2 + 4 + 6 = 12 minutes to make 3 donuts. A chef can move on to making the next donut only after completing the previous one. All the chefs can work simultaneously.
Since, it's time for the party, Geek wants to know the minimum time required in completing n donuts. Return an integer denoting the minimum time.
*/
class Solution {
    public int minTime(int[] ranks, int n) {
        // code here
        int minRank = ranks[0];
        for(int i=1; i<ranks.length; i++){
            minRank = Math.min(minRank, ranks[i]);
        }
        
        long low = 0;
        long high = (long)minRank*n*(n+1)/2;
        long ans = high;
        
        while(low <= high){
            long mid = low + (high - low)/2;
            
            if(canMake(ranks, n, mid)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        
        return (int)ans;
    }
    
    public boolean canMake(int[] ranks, int n, long time){
        int totalDonuts = 0;
        for(int rank: ranks){
            long timeTaken = 0;
            int donuts = 0;
            while(true){
                long nextTime = (long)rank*(donuts + 1);
                if(timeTaken + nextTime > time) break;
                
                donuts++;
                timeTaken+= nextTime;
            }
            totalDonuts+= donuts;
            if(totalDonuts >= n) return true;
        }
        
        return totalDonuts >= n;
    }
}
