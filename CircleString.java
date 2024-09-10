/*
Given an array arr of lowercase strings, determine if the strings can be chained together to form a circle.
A string X can be chained together with another string Y if the last character of X is the same as the first character of Y. If every string of the array can be chained with exactly two strings of the array(one with the first character and the second with the last character of the string), it will form a circle.

For example, for the array arr[] = {"for", "geek", "rig", "kaf"} the answer will be Yes as the given strings can be chained as "for", "rig", "geek" and "kaf"
*/


// User function Template for Java

class Solution {
    public int isCircle(String arr[]) {
        // code here
        int n=arr.length;
        if(n==0) return 0;
        Map<Character,List<Character>> graph=new HashMap<>();
        int[] inDegree=new int[26];
        int[] outDegree=new int[26];
        boolean[] visited=new boolean[26];
        for(char c='a';c<='z';c++) graph.put(c,new ArrayList<>());
        for(String word:arr){
            char first=word.charAt(0);
            char last=word.charAt(word.length()-1);
            graph.get(first).add(last);
            outDegree[first-'a']++;
            inDegree[last-'a']++;
            visited[first-'a']=true;
            visited[last-'a']=true;
        }
        for(int i=0;i<26;i++){
            if(inDegree[i]!=outDegree[i]) return 0;
        }
        return isConnected(graph,arr[0].charAt(0),visited)?1:0;
    }
    private boolean isConnected(Map<Character,List<Character>> graph,char start,boolean[] visited){
        boolean[] visitedNodes=new boolean[26];
        dfs(graph,start,visitedNodes);
        for(int i=0;i<26;i++){
            if(visited[i]&&!visitedNodes[i]) return false;
        }
        return true;
    }

    private void dfs(Map<Character,List<Character>> graph,char node,boolean[] visitedNodes){
        visitedNodes[node-'a']=true;
        for(char neighbor:graph.get(node)){
            if(!visitedNodes[neighbor-'a']) dfs(graph,neighbor,visitedNodes);
        }
    }
}
