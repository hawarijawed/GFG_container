/*
Given a string s that contains only digits (0-9) and an integer target, return all possible strings by inserting the binary operator ' + ', ' - ', and/or ' * ' between the digits of s such that the resultant expression evaluates to the target value.

Note:

Operands in the returned expressions should not contain leading zeros. For example, 2 + 03 is not allowed whereas 20 + 3 is fine.
It is allowed to not insert any of the operators.
Driver code will print the final list of strings in lexicographically smallest order.
*/
class Solution {
    public ArrayList<String> findExpr(String s, int target) {
        ArrayList<String> result = new ArrayList<>();
        backtrack(s, target, 0, 0, 0, "", result);
        return result;
    }
    
    private void backtrack(String s, int target, int index, long currentVal, 
                          long prevOperand, String expression, ArrayList<String> result) {
     
        if (index == s.length()) {
            if (currentVal == target) {
                result.add(expression);
            }
            return;
        }
        
       
        for (int i = index; i < s.length(); i++) {
            
            if (i > index && s.charAt(index) == '0') {
                break;
            }
            
           
            long currentNum = Long.parseLong(s.substring(index, i + 1));
            
            
            if (index == 0) {
                backtrack(s, target, i + 1, currentNum, currentNum, 
                         expression + currentNum, result);
            } else {
                
                backtrack(s, target, i + 1, currentVal + currentNum, currentNum, 
                         expression + "+" + currentNum, result);
                
               
                backtrack(s, target, i + 1, currentVal - currentNum, -currentNum, 
                         expression + "-" + currentNum, result);
                
               
                long newVal = currentVal - prevOperand + (prevOperand * currentNum);
                backtrack(s, target, i + 1, newVal, prevOperand * currentNum, 
                         expression + "*" + currentNum, result);
            }
        }
    }
}
