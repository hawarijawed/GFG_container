/*
Given an array arr and target sum k, check whether there exists a subsequence such that the sum of all elements in the subsequence equals the given target sum(k).
*/
//Recursive Solution
class Solution {
  public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
    // code here
    return  Check(arr, K, 0);
  }
 
  public static boolean Check(int[] arr, int sum, int index){
      //Base Case
      if(sum ==0) return true;
      
      if(index == arr.length-1){
          if(arr[index] == sum) return true;
          return false;
      }
      
      //Apply Pick/Nopic Logic
      boolean pick = false;
      
      if(arr[index] <= sum){
          pick = Check(arr, sum - arr[index], index+1);
          if(pick) return true;
      }
      
      boolean no_pick = false;
      
      no_pick = Check(arr, sum, index+1);
      
      return no_pick;
  }
}
     

//Linear Solution with DP table
class Solution {
  public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
    // code here
    int[][] dp = new int[N][K+1];
    //Base case, for every index i dp[i][k=0] = 1;
    for(int i=0; i<N; i++){
        dp[i][0] = 1;
    }
    for(int t=1; t<=K; t++){
        if(t == arr[0]){
            dp[0][t] = 1;
        }
        else{
            dp[0][t] = 2;
        }
    }
    
    //Solving the dp for index i and target j
    for(int i=1; i<N;i++){
        for(int j=1; j<=K; j++){
            int pick = 2;
            if(arr[i] <= j){
                pick = dp[i-1][j-arr[i]];
                if(pick ==1){
                    dp[i][j] = 1;
                    continue;
                }
            }
            
            int no_pick = 2;
            no_pick = dp[i-1][j];
            dp[i][j] = no_pick;
        }
    }
    
    return dp[N-1][K]==1;
  }
  

}
    
//Space Optimized linear solution
class Solution {
  public static boolean checkSubsequenceSum(int N, int[] arr, int k) {
    // code here
    // DP array of size (k + 1), initially all values are false
        boolean[] dp = new boolean[k + 1];
        
        // Base case: A sum of 0 is always achievable (with an empty subsequence)
        dp[0] = true;
        
        // Traverse the array elements
        for (int num : arr) {
            // Traverse the DP array backwards to ensure we are using each element only once
            for (int i = k; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        
        // The answer will be in dp[k], if it's true, there's a subsequence with sum k
        return dp[k];
    }

}
    
