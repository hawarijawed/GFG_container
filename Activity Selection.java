/*
You are given a set of activities, each with a start time and a finish time, represented by the arrays start[] and finish[], respectively. A single person can perform only one activity at a time, meaning no two activities can overlap. 
Your task is to determine the maximum number of activities that a person can complete in a day.
*/
class Solution {
    public int activitySelection(int[] start, int[] finish) {
        // code here.
        int n = start.length;
        int [][] activity = new int[n][2];
        for(int i=0; i<n; i++){
            activity[i][0] = start[i];
            activity[i][1] = finish[i];
        }
        
        Arrays.sort(activity, (a, b) -> (a[1] - b[1]));
        
        int count = 1;
        int end = activity[0][1];
        for(int i=1; i<n; i++){
            if(activity[i][0] > end){
                count++;
                end = activity[i][1];
            }
            
        }
        
        return count;
    }
}
