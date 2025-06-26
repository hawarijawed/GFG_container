/*
Given a string s consisting of lowercase alphabets and an integer k, your task is to find the minimum possible value of the string after removing exactly k characters.

The value of the string is defined as the sum of the squares of the frequencies of each distinct character present in the string.
*/

class Solution {
    public int minValue(String s, int k) {
        // code here
        int[] freq = new int[26];
        
        for(char ch: s.toCharArray()){
            freq[ch - 'a']++;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int count: freq){
            if(count > 0){
                pq.add(count);
            }
            
        }
        
        while(k>0 && !pq.isEmpty()){
            int top = pq.poll();
            top--;
            if(top > 0){
                pq.add(top);
            }
            
            k--;
        }
        
        int res = 0;
        while(!pq.isEmpty()){
            int top = pq.poll();
            res += top*top;
        }
        
        return res;
    }
}
