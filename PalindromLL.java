class Solution {
    // Function to check whether the list is palindrome.
    boolean isPalindrome(Node head) {
        // Your code here
        String str="";
        String reverse="";
        while(head!=null){
            str+=head.data;
            reverse=head.data+reverse;
            head=head.next;
        }
        return str.equals(reverse);        
    }
}
