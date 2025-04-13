/*
Given a connected undirected graph represented by adjacency list, adjList[][] with n nodes, having a distinct label from 0 to n-1, where each adj[i] represents the list of vertices connected to vertex i.

Create a clone of the graph, where each node in the graph contains an integer val and an array (neighbors) of nodes, containing nodes that are adjacent to the current node.
*/

class Solution {
    
    Node cloneGraph(Node node) {
        // code here
        Map<Integer,Node> map=new HashMap<>();
        return dfs(node,map);
    }
    public Node dfs(Node node,Map<Integer,Node> map){
        if(!map.containsKey(node.val)){
            ArrayList<Node> neighbors=new ArrayList<>();
            Node temp=new Node(node.val,neighbors);
            map.put(node.val,temp);
            for(Node v:node.neighbors){
                neighbors.add(dfs(v,map));
            }
            return temp;
        }
        return map.get(node.val);
    }
}
