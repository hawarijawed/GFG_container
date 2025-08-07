/*
Given an array arr[] of time strings in 24-hour clock format "HH:MM:SS", return the minimum difference in seconds between any two time strings in the arr[].
The clock wraps around at midnight, so the time difference between "23:59:59" and "00:00:00" is 1 second.
*/

class Solution {
    public int minDifference(String[] arr) {
        // code here
        int n = arr.length;
        int [] val = new int[n];
        int Diff = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            String curr = arr[i];
            //hh:mm:ss
            int hour = Integer.parseInt(curr.substring(0,2));
            int min  = Integer.parseInt(curr.substring(3, 5));
            int sec  = Integer.parseInt(curr.substring(6, 8));
            
            val[i] = (hour*60*60 + min*60 + sec);
        
        }
        
        Arrays.sort(val);
        for(int i=1; i<n; i++){
            Diff = Math.min(Diff, val[i] - val[i-1]);
        }
        int wrapAroundDiff = (86400 + val[0] - val[n-1]) % 86400;
        Diff = Math.min(Diff, wrapAroundDiff);
        return Diff;
    }
}
