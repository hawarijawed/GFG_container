/*
Given a string s in Roman number format, your task is to convert it to an integer. Various symbols and their values are given below.
Note: I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1000
*/
class Solution {
    public int romanToDecimal(String s) {
        // code here
        HashMap<Character, Integer> map = new HashMap<>();
        //I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1000
        map.put('I',1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int ans = 0;
        int prev = 0;
        //ix
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            int val = map.get(ch);
            if(i>0 && prev < map.get(ch)){
                val = val - prev;
                ans = ans - prev;
            }
            
            prev = map.get(ch);
            ans += val;
        }
        
        return ans;
    }
}
