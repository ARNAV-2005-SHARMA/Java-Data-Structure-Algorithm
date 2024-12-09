//(1) Cycle Detection in Directed Graph
// Use Dfs
// Time Complexity -> O(V+E)
import java.util.*;

// public class cycleDetection {
//     static class Edge{
//         int src;
//         int dest;

//         public Edge(int s, int d){
//             this.src = s;
//             this.dest = d;
//         }
//     }

//     public static void createGraph(ArrayList<Edge> graph[]){
//         for(int i=0;i<graph.length;i++){
//             graph[i] = new ArrayList<Edge>();
//         }
//         graph[0].add(new Edge(0, 2));

//         graph[1].add(new Edge(1, 0));

//         graph[2].add(new Edge(2, 3));

//         graph[3].add(new Edge(3, 0));
//     }
//     public static boolean isCycleDirected(ArrayList<Edge> graph[], boolean vis[], int curr, boolean rec[]){
//         vis[curr] = true;
//         rec[curr] = true;

//         for(int i=0;i<graph[curr].size();i++){
//             Edge e = graph[curr].get(i);

//             if(rec[e.dest]){
//                 return true; // cycle exist
//             }
//             else if (!vis[e.dest]){
//                 if(isCycleDirected(graph, vis, e.dest, rec)){
//                     return true;
//                 }
//             }
//         }
//         rec[curr] = false;
//         return false;
//     }
//     public static void main(String args[]){
//         int V = 4;

//         ArrayList<Edge> graph[] = new ArrayList[V];
//         createGraph(graph);

//         System.out.println(isCycleDirected(graph, new boolean[V], 0, new boolean[V]));
//     }
// }



//(2)
// Cycle Detection in Directed Graph(if graph is disconnected or multiple components)
// If graph have more than one starting point
// Time Complexity -> O(V+E)


// public class cycleDetection {
//     static class Edge{
//         int src;
//         int dest;

//         public Edge(int s, int d){
//             this.src = s;
//             this.dest = d;
//         }
//     }

//     public static void createGraph(ArrayList<Edge> graph[]){
//         for(int i=0;i<graph.length;i++){
//             graph[i] = new ArrayList<Edge>();
//         }
//         graph[0].add(new Edge(0, 2));

//         graph[1].add(new Edge(1, 0));

//         graph[2].add(new Edge(2, 3));

//         graph[3].add(new Edge(3, 0));
//     }
//     public static boolean isCycleDirected(ArrayList<Edge> graph[], boolean vis[], int curr, boolean rec[]){
//         vis[curr] = true;
//         rec[curr] = true;

//         for(int i=0;i<graph[curr].size();i++){
//             Edge e = graph[curr].get(i);

//             if(rec[e.dest]){
//                 return true; // cycle exist
//             }
//             else if (!vis[e.dest]){
//                 if(isCycleDirected(graph, vis, e.dest, rec)){
//                     return true;
//                 }
//             }
//         }
//         rec[curr] = false;
//         return false;
//     }
//     public static void main(String args[]){
//         int V = 4;

//         ArrayList<Edge> graph[] = new ArrayList[V];
//         createGraph(graph);

//         boolean vis[] = new boolean[V];
//         boolean rec[] = new boolean[V];

//         for(int i=0;i<V;i++){
//             if(!vis[i]){
//                 boolean isCycle = isCycleDirected(graph, vis, 0, rec);
//                 if(isCycle){
//                     //cycle exist
//                     System.out.println(isCycle);
//                     break;
//                 }
//             }
//         }

//         // System.out.println(isCycleDirected(graph, new boolean[V], 0, new boolean[V]));
//     }
// }


//(3)----Topological Sorting-----------//

// Directed Acyclic graph(DAG) is a directed graph with no cycles. Topological sorting is used only for DAG(not for non-DAGs)
//-Definition -> It is a linear order of vertices such that every directed edge u->v, the vertex u comes before v in the order

// Approach -> Modified DFS
// Time Complexity -> O(V+E)

// public class cycleDetection{
//     static class Edge{
//         int src;
//         int dest;

//         public Edge(int s, int d){
//             this.src = s;
//             this.dest = d;
//         }
//     }
//     public static void createGraph(ArrayList<Edge> graph[]){
//         for(int i=0;i<graph.length;i++){
//             graph[i] = new ArrayList<Edge>();
//         }
//         graph[2].add(new Edge(2, 3));

//         graph[3].add(new Edge(3, 1));

//         graph[4].add(new Edge(4, 0));
//         graph[4].add(new Edge(4, 1));

//         graph[5].add(new Edge(5, 0));
//         graph[5].add(new Edge(5, 2));
//     }

//     public static void topSortHelper(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> stack){
//         vis[curr] = true;

//         for(int i=0;i<graph[curr].size();i++){
//             Edge e = graph[curr].get(i);

//             if(!vis[e.dest]){
//                 topSortHelper(graph, e.dest, vis, stack);
//             }
//         }
//         stack.push(curr);
//     }
//     public static void topSort(ArrayList<Edge> graph[], int V){
//         boolean vis[] = new boolean[V];
//         Stack<Integer> stack = new Stack<>();

//         for(int i=0;i<V;i++){
//             if(!vis[i]){
//                 topSortHelper(graph, i, vis, stack);
//             }
//         }

//         while(!stack.isEmpty()){
//             System.out.print(stack.pop() + " ");
//         }
//     }

//     public static void main(String args[]){
//         int V = 6;

//         ArrayList<Edge> graph[] = new ArrayList[V];
//         createGraph(graph);

//         topSort(graph, V);
//     }
// }


//(4). Cycle Detection in Undirected Graph
// Approach -> Use DFS

// Note : Three Types of Neighbour of curr Node :
//          1). vis[neighbour] = true, neighbour is not the parent of curr node(**Cycle Condition**)
//          2). vis[neighbour] = true, neighbour is parent of curr node (do nothing, use continue statement)
//          3). vis[neighbour] = false (visit the neighbour by calling dfs method)

// Time Complexity -> O(V+E), V is the number of vertices and E is the number of Edges

public class cycleDetection{
    static class Edge{
        int src;
        int dest;

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 4));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 4));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 2));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 4));
    }
    public static boolean isCycleUnDirected(ArrayList<Edge> graph[], boolean vis[], int curr, int parent){
        vis[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);

            if(vis[e.dest]==true && e.dest!=parent){
                return true;
            }
            else if(vis[e.dest]==false){
                if(isCycleUnDirected(graph, vis, e.dest, curr)==true){
                    return true;
                }
                // if condition is false then check for other vertices(neighbours)
            }
        }
        return false;
    }
    public static void main(String args[]){
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        System.out.println(isCycleUnDirected(graph, new boolean[V], 0, -1));
    }
}