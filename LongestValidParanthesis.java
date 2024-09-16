/*
Given a string str consisting of opening and closing parenthesis '(' and ')'. Find length of the longest valid parenthesis substring.

A parenthesis string is valid if:
    For every opening parenthesis, there is a closing parenthesis.
    Opening parenthesis must be closed in the correct order.
*/
//User function Template for Java
class Solution{
    static int maxLength(String S){
        // code here
        Stack<Integer> st=new Stack<Integer>();
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        char arr[]=S.toCharArray();
        for(int i=0;i<arr.length;i++){
            char ch=arr[i];
            if(ch=='('){
                st.push(i);
            }else{
                if(!st.isEmpty()){
                    int pop=st.pop();
                    map.put(pop,i);
                }
            }
        }
        int brr[]=new int[arr.length];
        for (Map.Entry<Integer,Integer> mapElement : map.entrySet()) {
            int key = mapElement.getKey();
            int value = mapElement.getValue();
            brr[key]=1;
            brr[value]=1;
        }
        int max=-1;
        int count=0;
        for(int m:brr){
            if(m==1){
               count++;
            }else{
                if(count>max){
                    max=count;
                }
                count=0;
            }
        }
        return (count>max)?count:max;
    }
}
