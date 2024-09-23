class Solution {
    int isPalindrome(String S) {
        // code here
        int size = S.length();
        int left = 0;
        int right = size-1;
        int flag = 1;
        while(left < right){
            if(S.charAt(left) == S.charAt(right)){
                left++;
                right--;
            }
            else{
                flag = 0;
                break;
            }
        }
        
        return flag;
    }
}
