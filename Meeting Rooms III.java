/*
You are given an integer n representing the number of rooms numbered from 0 to n - 1. Additionally, you are given a 2D integer array meetings[][] where meetings[i] = [starti, endi] indicates that a meeting is scheduled during the half-closed time interval [starti, endi). All starti values are unique.

Meeting Allocation Rules:

When a meeting starts, assign it to the available room with the smallest number.
If no rooms are free, delay the meeting until the earliest room becomes available. The delayed meeting retains its original duration.
When a room becomes free, assign it to the delayed meeting with the earliest original start time.
Determine the room number that hosts the most meetings. If multiple rooms have the same highest number of meetings, return the smallest room number among them.
*/
class Solution {
    public int mostBooked(int n, int[][] meetings) {
        // code here
        Arrays.sort(meetings, (a, b) -> (a[0] - b[0]));
        PriorityQueue<Integer> available_rooms = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            available_rooms.offer(i);
        }
        PriorityQueue<long []> busyRooms = new PriorityQueue<>((a, b)->{
            if (a[0] == b[0]) return Long.compare(a[1], b[1]);
            return Long.compare(a[0], b[0]);
        });
        
        int meetingRooms[] = new int[n];
        
        for(int [] meeting: meetings){
            int start = meeting[0], end = meeting[1];
            int duration = end - start;
            
            while(!busyRooms.isEmpty() && busyRooms.peek()[0] <= start){
                int freedRoom = (int) busyRooms.poll()[1];
                available_rooms.offer(freedRoom);
            }
            
            if(!available_rooms.isEmpty()){
                int rooms = available_rooms.poll();
                meetingRooms[rooms]++;
                busyRooms.offer(new long[]{start+ duration, rooms});
            }
            else{
                long[] earliest =  busyRooms.poll();
                long newStart = earliest[0];
                int room = (int) earliest[1];
                meetingRooms[room]++;
                busyRooms.offer(new long[]{newStart + duration, room});
            }
        }
        
        int maxMeetings = 0;
        int resultRooms = 0;
        for(int i=0; i<n; i++){
            if((meetingRooms[i] > maxMeetings) ||
                (meetingRooms[i] == maxMeetings && i < resultRooms)
            ){
                maxMeetings = meetingRooms[i];
                resultRooms = i;
            }
        }
        
        return resultRooms;
    }
}
