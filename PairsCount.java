/*
Given two positive integer arrays arr and brr, find the number of pairs such that x^y > y^x (raised to power of) where x is an element from arr and y is an element from brr.
*/
//Back-end complete function Template for Java
class Solution {
    // Function to count number of pairs such that x^y is greater than y^x.
    public long countPairs(int x[], int y[], int M, int N) {
        // code here
         // code here
        Arrays.sort(x);
        Arrays.sort(y);
        
        int c0 = 0, c1 = 0, c2 = 0, c3 = 0, c4 = 0;
        for(int yElem : y){
            if(yElem == 0){
                ++c0;
            }
            else if(yElem == 1){
                ++c1;
            }
            else if(yElem == 2){
                ++c2;
            }
            else if(yElem == 3){
                ++c3;
            }
            else if(yElem == 4){
                ++c4;
            }
        }
        
        int j = 0;
        long ans = 0;
        for(int i = 0; i < M; ++i){
            if(x[i] == 0){
                continue;
            }
            
            if(x[i] == 1){
                ans += c0;
            }
            else{
                ans += c0 + c1;
                while(j < N && y[j] <= x[i]){
                    ++j;
                }
                
                if(j < N){
                    ans += N - j;
                }
                
                if(x[i] == 2){
                    ans-= c3;
                    ans -= c4;
                }
                
                if(x[i] == 3){
                    ans += c2;
                }
            }
        }
        return ans;
    }
}
