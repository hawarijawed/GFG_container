/*
Given a string s consisting only lowercase alphabetic characters, check whether it is possible to remove at most one character such that the  frequency of each distinct character in the string becomes same. Return true if it is possible; otherwise, return false.
*/
class Solution {
    boolean sameFreq(String s) {
        // code here
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        
        HashMap<Integer, Integer> freqCount = new HashMap<>();
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            freqCount.put(entry.getValue(), freqCount.getOrDefault(entry.getValue(), 0)+1);
            
        }
        
        // Step 3: Analyze the frequency pattern
    if (freqCount.size() == 1) {
        // Case 1: All characters already have same frequency
        return true;
    }

    if (freqCount.size() == 2) {
        int f1 = 0, c1 = 0;
        int f2 = 0, c2 = 0;
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : freqCount.entrySet()) {
            if (i == 0) {
                f1 = entry.getKey();
                c1 = entry.getValue();
            } else {
                f2 = entry.getKey();
                c2 = entry.getValue();
            }
            i++;
        }

        // Case 2a: One frequency is 1 and occurs only once (e.g., {1=1, 2=4})
        if ((f1 == 1 && c1 == 1) || (f2 == 1 && c2 == 1)) {
            return true;
        }

        // Case 2b: One frequency is one more than the other and occurs once
        if ((Math.abs(f1 - f2) == 1) && ((f1 > f2 && c1 == 1) || (f2 > f1 && c2 == 1))) {
            return true;
        }
    }

    // All other cases: not possible
    return false;
    }
}
