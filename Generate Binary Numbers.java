/*
Given a number n. The task is to generate all binary numbers with decimal values from 1 to n.
*/
class Solution {
    public ArrayList<String> generateBinary(int n) {
        // code here
        ArrayList<String> res = new ArrayList<>();
        for(int i=1; i<=n; i++){
            res.add(binary(i));
        }
        return res;
    }
    
    private String binary(int n){
        StringBuilder sb = new StringBuilder();
        
        while(n>0){
            int rem = n%2;
            sb.append( (char) (rem+'0'));
            n = n/2;
        }
        return sb.reverse().toString();
    }
}
