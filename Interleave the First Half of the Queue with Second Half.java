/*
Given a queue q[] of even size. Your task is to rearrange the queue by interleaving its first half with the second half.

Interleaving is the process of mixing two sequences by alternating their elements while preserving their relative order.
In other words, Interleaving means place the first element from the first half and then first element from the 2nd half and again second element from the first half and then second element from the 2nd half and so on....
*/

class Solution {
    public void rearrangeQueue(Queue<Integer> q) {
        // code here
        int n = q.size();
        int [] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = q.poll();
        }
        
        int l = 0, r = n/2;
        while( r < n){
            q.offer(arr[l]);
            q.offer(arr[r]);
            l++;
            r++;
        }
        
        return;
    }
}
/*
1 2 3 4 5 6 7 8

1 5 2 6 3 7 4 8
*/
