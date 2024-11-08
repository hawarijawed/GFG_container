/*
Given two strings s1 and s2. Return a minimum number of times s1 has to be repeated such that s2 is a substring of it. If s2 can never be a substring then return -1.

Note: Both the strings contain only lowercase letters.
*/
//----------------------------------- Brute Force -----------------------------//
class Solution {
    static int minRepeats(String s1, String s2) {
        // code here
        int repeatCount = (int) Math.ceil((double) s2.length() / s1.length());

        // Try repeating s1 a few times to ensure st is long enough
        String st = s1.repeat(repeatCount);
    
        // If st already contains s2, return the number of repeats
        if (st.contains(s2)) {
            return repeatCount;
        }

        // Otherwise, try one more repeat of s1
        st = st + s1;
    
        // Check again
        if (st.contains(s2)) {
            return repeatCount + 1;
        }

        // If s2 is not found even after one extra repetition, return -1
        return -1;
    }
};


class Solution {
  public:
    int minRepeats(string& s1, string& s2) {
        // code here
        int ans = 1 , n1 = s1.size() ;string s = s1;
        while(n1<s2.size()){
            ans++;
            n1+=s1.size();
            s+=s1;
        }
        if(s.find(s2)!=string::npos)return ans;
        ans++;
        s+=s1;
        if(s.find(s2)!=string::npos)return ans;
        return -1;
    }
};
