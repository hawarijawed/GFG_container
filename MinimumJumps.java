/*
Given an array arr[] of non-negative integers. Each array element represents the maximum length of the jumps that can be made forward from that element. This means if arr[i] = x, then we can jump any distance y such that y ≤ x.
Find the minimum number of jumps to reach the end of the array starting from the first element. If an element is 0, then you cannot move through that element.
Note:  Return -1 if you can't reach the end of the array
*/
class Solution {
    static int minJumps(int[] arr) {
        // your code here
        int curr = 0;
        int farthest_pos = 0;
        int jumps = 0;
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
/*
Imagine you're trying to get to the other side of town, but there are obstacles in your way. You need to find the most efficient route, taking the fewest jumps to reach your destination.

That's exactly what this problem is about. Here's my approach:

Initialize three pointers: curr_pos (current position), farthest_pos (farthest reachable position), and jumps (number of jumps).

Iterate through the array, updating farthest_pos to be the maximum of its current value and the sum of the current index and the jump value at the current index.

If curr_pos equals the current index, check if farthest_pos equals the current index. If so, return -1 (cannot reach the end)

Increment jumps and update curr_pos to farthest_pos.

*/
/*
Initialize curr_pos = farthest_pos = jumps = 0

Iterate through the array:
    - i = 0: farthest_pos = max(0, 0 + 1) = 1

    - i = 1: farthest_pos = max(1, 1 + 2) = 3

    - i = 2: farthest_pos = max(3, 2 + 3) = 5

    - i = 3: farthest_pos = max(5, 3 + 4) = 7 (but we've reached the end, so we stop)

    - i = 4: (we've already reached the end, so we skip this step)

jumps = 3 (we jumped from index 0 to 1, then from index 1 to 2, and finally from index 2 to 4)

So, the minimum number of jumps required is 3.
*/
