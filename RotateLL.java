/******************************************************************************
Given the head of a singly linked list, the task is to rotate the linked list clockwise by k nodes, 
i.e., left-shift the linked list by k nodes, where k is a given positive integer smaller than or equal to length of the linked list.
*******************************************************************************/
//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

// } Driver Code Ends
/* node of linked list:

class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}

*/

class Solution {
    // Function to rotate a linked list.
    public Node rotate(Node head, int k) {
        // add code here
        //Function to count number of nodes
        int count = 0; 
        Node Count_node = head;
        while(Count_node != null){
            count++;
            Count_node = Count_node.next;
        }
        //if k == number of nodes in LL then return the whole list as it is
        if(count==k){
            return head;
        }
        
        
        Node first = head;
        Node temp1 = first;
        int i=1;
        while(i<k){
            temp1 = temp1.next;
            i++;
        }
        head = temp1.next;
        temp1.next = null;
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = first;
        
        return head;
    }
}
