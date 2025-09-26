/*
You are given a deque dq (double-ended queue) containing non-negative integers, along with two positive integer type and k. The task is to rotate the deque circularly by k positions.
There are two types of rotation operations:

Right Rotation (Clockwise): If type = 1, rotate the deque to the right. This means moving the last element to the front, and repeating the process k times.
Left Rotation (Anti-Clockwise): If type = 2, rotate the deque to the left. This means moving the first element to the back, and repeating the process k times.
*/
class Solution {
    public static void rotateDeque(Deque<Integer> dq, int type, int k) {
        // code here
        if(type == 1){
            while(k>0){
                int val = dq.removeLast();
                dq.offerFirst(val);
                k--;
            }
        }
        else{
            while(k>0){
                int val = dq.remove();
                dq.addLast(val);
                k--;
            }
        }
    }
}
