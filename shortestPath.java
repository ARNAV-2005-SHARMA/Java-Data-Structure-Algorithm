import java.util.*;

//-> 1). Shortest Path Algorithm -> **Dijkstra Algorithm**
// .Shortest Distance from the source to all vertices
// .Use Source Node and Weight as distance 
// .Use Relaxation Concept and Priority Queue
// .Dijkstra Algorithm fails in graphs with negative edge weights

// Time Complexity -> O(V + Elog V), V is vertices of graph and ElogV for sorting
// T.C : O((V+E)log V)

// public class shortestPath {
//     static class Edge{
//         int src;
//         int dest;
//         int wt;
    
//         public Edge(int s, int d, int w){
//             this.src = s;
//             this.dest = d;
//             this.wt = w;
//         }
//     }

//     public static void createGraph(ArrayList<Edge> graph[]){
//         for(int i=0;i<graph.length;i++){
//             graph[i] = new ArrayList<Edge>();
//         }
//         graph[0].add(new Edge(0, 1, 2));
//         graph[0].add(new Edge(0, 2, 4));

//         graph[1].add(new Edge(1, 3, 7));
//         graph[1].add(new Edge(1, 2, 1));

//         graph[2].add(new Edge(2, 4, 3));

//         graph[3].add(new Edge(3, 5, 1));

//         graph[4].add(new Edge(4, 3, 2));
//         graph[4].add(new Edge(4, 5, 5 ));
//     }
//     public static class Pair implements Comparable<Pair>{
//         int node;
//         int dist;

//         public Pair(int n, int d){
//             this.node = n;
//             this.dist = d;
//         }

//         @Override
//         public int compareTo(Pair p2){
//             return this.dist - p2.dist; // sort the distance in ascending order 
//             // return p2.dist - this.dist --> sort in descending oder 
//         }
//     }

//     public static void dijkstra(ArrayList<Edge> graph[], int src, int V){
//         PriorityQueue<Pair> pq = new PriorityQueue<>();
//         int[] dist = new int[V];

//         for(int i=0;i<V;i++){
//             if(i!=src){ // add infinity value in distance array(in starting ), except 0 (0 is source Point)
//                 dist[i] = Integer.MAX_VALUE; // Infinity Value 
//             }
//         }
//         boolean vis[] = new boolean[V];
//         pq.add(new Pair(0, 0));

//         while(!pq.isEmpty()){
//             Pair curr = pq.remove(); // Pair = node & distance 
    //             if(!vis[curr.node]){
    //                 vis[curr.node] = true;

//                 for(int i=0;i<graph[curr.node].size();i++){
//                     Edge e = graph[curr.node].get(i); // for neighbour Edge
//                     int u = e.src; // curr node 
//                     int v = e.dest; // neighbour node

//                     if(dist[u] + e.wt < dist[v]){ // Relaxation Concept
//                         dist[v] = dist[u] + e.wt;
//                         pq.add(new Pair(v, dist[v])); // add new neighbour Pair in queue
//                     }
//                 }
//             }
//         }
//         // Finally print the distance Array as output
//         for(int i=0;i<V;i++){
//             System.out.print(dist[i] + " ");
//         }
//         System.out.println();
//     }

//     public static void main(String args[]){
//         int V = 6;
//         ArrayList<Edge> graph[] = new ArrayList[V];
//         createGraph(graph);
//         dijkstra(graph, 0, V);
//     }
// }


//---Note -> Time Complexity : Dijkstra's algorithm < BellmanFord Algoritm
//                                O(E + E log V)    < O(v + E)       


//-> 2).BellmanFord Algorithm -> Shortest distance from the source to all vertices(shortest path algorithm)
//.-> Perform this operation V-1 times (v = vertices)
//.-> BellmanFord Algorithm work for positive weights as well as for negative weight in graph
//.-> BellmanFord Algorithm doesn't work Negative Weight Cycles

// Time Complexity -> O(V+E)
public class shortestPath{
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

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));
    }
    public static void bellmanFord(ArrayList<Edge> graph[], int src, int V){
        int[] dist = new int[V];
        for(int i=0;i<V;i++){
            if(i!=src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        for(int k=0;k<V-1;k++){ // O(V)
            //O(E) -> For next Two Loops
            for(int i=0;i<V;i++){
                for(int j=0;j<graph[i].size();j++){
                    Edge e = graph[i].get(j);

                    int u = e.src;
                    int v =  e.dest;

                    // Relaxation Concept
                    if(dist[u]!=Integer.MAX_VALUE && dist[u]+e.wt < dist[v]){
                        dist[v] = dist[u] + e.wt;
                    }
                }
            }
        }
        // Detect Negative Weight Cycle
        for(int i=0;i<V;i++){
            for(int j=0;j<graph[i].size();j++){
                Edge e = graph[i].get(j);
                int u = e.src;
                int v = e.dest;

                if(dist[u]!=Integer.MAX_VALUE && dist[u] + e.wt <dist[v]){
                    System.out.println("Graph conatains a negative-weight cycle");
                    // return ; if we return word then only print above string but not negative cycle
                }
            }
        }
        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i] + " ");
        }
    }
    public static void main(String args[]){
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        bellmanFord(graph, 0, V);
    }
}