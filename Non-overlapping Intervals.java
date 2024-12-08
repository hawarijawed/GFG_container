/*
Given a 2D array intervals[][] of representing intervals where intervals [i] = [starti, endi ]. Return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
*/
class Solution {
    static int minRemoval(int intervals[][]) {
        // code here
        
        //Sort the intevals based on starting time
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[1],b[1]));
        
        // int[] curr = intervals[0];
        
        int n = intervals.length;
        int count=1;
        int endTime = intervals[0][1];
        for(int i=1; i<n; i++){
            if(endTime <= intervals[i][0]){
                count++;
                endTime = intervals[i][1];
            }
            
        }
        
        return n-count;
    }
}
