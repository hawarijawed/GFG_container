/*
You are given the head of a linked list. You have to replace all the values of the nodes with the nearest prime number. 
If more than one prime number exists at an equal distance, choose the smallest one. Return the head of the modified linked list.

*/

class Solution {
    boolean isPrime(int n){
        if(n<2) return false;
        if(n<=3) return true;
        
        if(n%2==0 || n%3==0) return false;
        
        int i = 5;
        while(i*i <= n){
            if(n%i==0 || n%(i+2) == 0){
                return false;
            }
            
            i+=6;
        }
        
        return true;
        
    }
    
    int nearestPrime(int n){
        if(isPrime(n)){
            return n;
        }
        
        int offset = 1;
        while(true){
            int lower = n - offset;
            int upper = n + offset;
            
            if(lower >= 2 && isPrime(lower)){
                return lower;
            }
            if(isPrime(upper)){
                return upper;
            }
            
            offset++;
        }
    }
    Node primeList(Node head) {
        // code here
        Node current = head;
        while(current != null){
            current.val = nearestPrime(current.val);
            current = current.next;
        }
        
        return head;
    }
}
