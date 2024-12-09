/*
Geek has an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith event and intervals is sorted in ascending order by starti. 
He wants to add a new interval newInterval= [newStart, newEnd] where newStart and newEnd represent the start and end of this interval.

Help Geek to insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
*/
//------------------- Method: 01 ----------------//
class Solution {
    static ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        // code here
        int n = intervals.length;
        
        int [][] arr = new int[n+1][2];
        for(int i=0; i<n; i++){
            arr[i][0] = intervals[i][0];
            arr[i][1] = intervals[i][1];
        }
        arr[n][0]  = newInterval[0];
        arr[n][1]  = newInterval[1];
        
        Arrays.sort(arr, (a, b)->Integer.compare(a[0], b[0]));
        
        ArrayList<int[]> lst = new ArrayList<>();
        lst.add(arr[0]);
        
        for(int i=1; i<n+1; i++){
            int[] curr = lst.get(lst.size()-1);
            
            if(curr[1] >= arr[i][0]){
                curr[1] = Math.max(curr[1], arr[i][1]);
            }
            else{
                lst.add(arr[i]);
            }
        }
        
        return lst;
    }
}

//------------------- Method: 02 ----------------//
class Solution {
    static ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        // code here
        ArrayList<int[]> result = new ArrayList<>();
        
        int i = 0, n = intervals.length;
        
        // Add all intervals before the newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        
        // Merge the newInterval with overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        
        result.add(newInterval); // Add the merged interval
        
        // Add the remaining intervals
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }
        
        return result;
    }
}
