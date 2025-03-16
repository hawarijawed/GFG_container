/*
You are given an array arr[] of non-negative numbers. Each number tells you the maximum number of steps you can jump forward from that position.

For example:

If arr[i] = 3, you can jump to index i + 1, i + 2, or i + 3 from position i.
If arr[i] = 0, you cannot jump forward from that position.
Your task is to find the minimum number of jumps needed to move from the first position in the array to the last position.

Note:  Return -1 if you can't reach the end of the array.
*/
class Solution {
    static int minJumps(int[] arr) {
        // code here
        int jumps = 0;
        int farthest_pos = 0;
        int curr = 0;
        int n = arr.length;
        for(int i=0; i<arr.length-1; i++){
            farthest_pos = Math.max(farthest_pos, i + arr[i]);
            if(curr == i){
                if(farthest_pos == i){
                    return -1;
                }
                jumps++;
                curr = farthest_pos;
            }
        }
        
        return jumps;
    }
}
