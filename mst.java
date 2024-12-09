import java.util.*;
//-> Minimum Spanning Tree(MST)

/* A minimum spanning tree(mst) or minimum weight spanning tree is a subset of the edges of a connected, edge-weighted undirected graph that connects all the vertices
 * together, without any cycles and with the minimum possible total edge weight.
 * 
 * Important point -> 1).undirected  2). vertices connected  3).No Cycle Exist  4).Edge Weight (Minimum) 
 */

// -> 1).Prim's Algorithm
/* Prim's algorithm is a greedy algorithm that finds a minimum spanning tree for a weighted undirected graph. This means it finds as subset of the edges that forms a tree that includes every vertex, where the 
 * total weight of all the edges in the tree is minimized.
*/

/* For Minimum cost -> Use Dijkstra algorithm 
 *   Use Priority Queue for Non Mst(set)
 *   Use boolean vis[] for Mst(set)
 */

// Time Complexity -> O(E log V)

public class mst { 
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }
    public static class Pair implements Comparable<Pair>{
        int node;
        int cost;

        public Pair(int s, int c){
            this.node = s;
            this.cost = c;
        }
        @Override
        public int compareTo(Pair p2){
            return this.cost - p2.cost; //ascending
        }
    }
    public static void primsAlgo(ArrayList<Edge> graph[], int V){
        PriorityQueue<Pair> pq = new PriorityQueue<>(); //(node - int, cost - int)
        boolean[] vis = new boolean[V];

        pq.add(new Pair(0, 0));
        int mstCost = 0;

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            
            if(!vis[curr.node]){
                vis[curr.node] = true;
                mstCost = mstCost + curr.cost;

                for(int i=0;i<graph[curr.node].size();i++){
                    Edge e = graph[curr.node].get(i);

                    if(!vis[e.dest]){
                        pq.add(new Pair(e.dest, e.wt));
                    }
                }
            }
        }
        System.out.println("Min cost of mst : " + mstCost);
    }
    public static void main(String args[]){
        int V = 4;

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        primsAlgo(graph, V);
    }
}