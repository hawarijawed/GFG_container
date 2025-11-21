/*
Given an undirected, connected graph with V vertices numbered from 0 to V-1 and E double-edges, represented as a 2D array edges[][]. Each double-edge is represented by a tuple (x, y, w1, w2), which indicates that there are two edges between vertices x and y: a straight edge with weight w1 and a curved edge with weight w2.

You are given two vertices a and b and you have to go from a to b through a series of edges such that in the entire path, you can use at most 1 curved edge. Your task is to find the shortest path from a to b satisfying the above condition.
If no such path exists that satisfies this restriction, return -1.

Note: It is guaranteed that the shortest path value will fit in a 32-bit integer.
*/
class Solution {
    class Pair{
        int node ;
        int straight ;
        int curve ;
        public Pair(int node , int straight , int curve ){
            this.node = node ;
            this.straight = straight ;
            this.curve = curve ; 
        }
    }
     public int shortestPath(int V, int a, int b, int[][] edges) {
        PriorityQueue<int[]> p = new PriorityQueue<>((x,y)->{
            return Integer.compare(x[0],y[0]);
        });
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i[] : edges){
            adj.get(i[0]).add(new Pair(i[1],i[2],i[3]));
            adj.get(i[1]).add(new Pair(i[0],i[2],i[3]));
        }
        p.add(new int[]{0,a,0});
        int vis[][] = new int[V][2];
        for(int i[] : vis)
        Arrays.fill(i,Integer.MAX_VALUE);
        vis[a][0] = 0;
        while(!p.isEmpty()){
            int temp[] = p.poll();
            int value = temp[0];
            int vertex = temp[1];
            int flag = temp[2];
            if(vertex==b){
                return value;
            }
            for(Pair pair : adj.get(vertex)){
                int node = pair.node ; 
                int str = pair.straight ;
                int cur = pair.curve ;
                
                if(vis[node][flag]>str+value){
                    p.add(new int[]{str+value,node,flag});
                    vis[node][flag] = str + value;
                }
                    
                if(flag==0 && vis[node][1]>cur+value){
                    p.add(new int[]{cur+value,node,1});
                    vis[node][1] = cur + value ;
                }   
            }
        }
        return -1;
    }
}
