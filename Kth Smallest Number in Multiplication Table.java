/*
Given three integers m, n and k. Consider a grid of m * n, where mat[i][j] = i * j (1 based index). The task is to return the kth smallest element in the m * n multiplication table.

*/

class Solution {
    public int kthSmallest(int m, int n, int k) {
        // code here
        int low = 1, high = n*m;
        while(low < high){
            int mid = low + (high - low)/2;
            int count = countLessEqual(mid, m, n);
            
            if(count < k){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        
        return low;
    }
    
    public int countLessEqual(int mid, int m, int n){
        int count=0;
        for(int i=1; i<=m; i++){
            count += Math.min(mid/i, n);
        }
        
        return count;
    }
}
