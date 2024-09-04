/*
There are n stairs, and a person standing at the bottom wants to reach the top. The person can climb either 1 stair or 2 stairs at a time. Count the number of ways, the person can reach the top (order does not matter).
Note: Order does not matter means for n = 4:- {1 2 1},{2 1 1},{1 1 2} are considered same.
*/
class Solution {
    public int nthStair(int n) {
        // Code here
        //For every positive integer, the step required = (n/2)+1
        return (n/2)+1;
    }
}
