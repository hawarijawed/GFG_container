/*
Given an array arr[] of n sorted linked lists of different sizes. Your task is to merge all these lists into a single sorted linked list and return the head of the merged list.

*/
/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    Node mergeKLists(Node[] arr) {
        // code here
        ArrayList<Integer> lst = new ArrayList<>();
        for(Node temp: arr){
            while(temp != null){
                lst.add(temp.data);
                temp = temp.next;
            }
        }
        Collections.sort(lst);
        Node dummy = new Node(-1);
        Node temp = dummy;
        
        for(int i=0; i<lst.size(); i++){
            temp.next = new Node(lst.get(i));
            temp = temp.next;
        }
        
        return dummy.next;
    }
}
