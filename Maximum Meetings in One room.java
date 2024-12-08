/*
There is one meeting room in a firm. There are N meetings in the form of (S[i], F[i]) where S[i] is the start time of meeting i and F[i] is the finish time of meeting i. The task is to find the maximum number of meetings that can be accommodated in the meeting room. You can accommodate a meeting if the start time of the meeting is strictly greater than the finish time of the previous meeting. 
Print all meeting numbers.

Note: If two meetings can be chosen for the same slot then choose meeting that finishes earlier.
*/
class Solution {
    public static ArrayList<Integer> maxMeetings(int N, int[] S, int[] F) {
        // code here
        int[][] meeting = new int[N][3];
  
        for (int i = 0; i < N; i++) {
            meeting[i][0] = S[i];  // Start time
            meeting[i][1] = F[i];  // Finish time
            meeting[i][2] = i + 1; // 1-based index of the meeting
        }
        
        Arrays.sort(meeting, (a, b)-> Integer.compare(a[1], b[1]));
        
        ArrayList<Integer> lst = new ArrayList<>();
        int endTime = meeting[0][1];
        lst.add(meeting[0][2]);
        
        for(int i=1; i<N; i++){
            if(endTime < meeting[i][0]){
                lst.add(meeting[i][2]);
                endTime = meeting[i][1];
            }
        }
        Collections.sort(lst);
        return lst;
    }
}
