// Strongly Connected Component(Directed Graph) 

/* Scc is a component in which we can reach every vertex of the component from every other vertex in that component 
 * 
 * 1). Kosaraju algorithm aims to find all strongly connected components(Scc) of a given input graph.
 * ...Note :-> *Use Reverse Dfs
 * 
 *  ->Step 1 : Get nodes in stack(topological sort).
 *  ->Step 2 : Tranpose the graph.
 *  ->Step 3 : Do DFS according to stack nodes on the transpose graph.
*/
import java.util.*;

// Time Complexity -> O(V+E)

/*public class scc {
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

        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));
    }

    public static void topSort(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> s){
        vis[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                topSort(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }
    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]){
        vis[curr] = true;
        System.out.print(curr + " ");

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph, e.dest, vis);
            }
        }
    }
    public static void kosarajuAlgo(ArrayList<Edge> graph[], int V){
        // Step 1 
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[V];

        for(int i=0;i<V;i++){
            if(!vis[i]){
                topSort(graph, i, vis, s);
            }
        }

        // Step 2
        ArrayList<Edge> transpose[] = new ArrayList[V];
        for(int i=0;i<graph.length;i++){
            vis[i] = false;
            transpose[i] = new ArrayList<Edge>();
        }

        for(int i=0;i<V;i++){
            for(int j=0;j<graph[i].size();j++){
                Edge e = graph[i].get(j); // e.src(i) -> e.dest(j)
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        // Step 3
        while(!s.isEmpty()){
            int curr = s.pop();
            if(!vis[curr]){
                dfs(transpose, curr, vis);
                System.out.println();
            }
        }
    }
    public static void main(String args[]){
        int V = 5;

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        kosarajuAlgo(graph, V);
    }
}*/



//-->Bridge in Graphs (Undirected Graph)--//
// => Use Tarjan's Algorithm
/* Bridge is an edge whose deletion increases the graph's number of connected components 
 * 
 * 1). int[] discovery time = new int[V]
 * 2). int[] lowest dt = new int[V] (lowest dt of all neighbours)
 * 3)*. dt[curr] < lowest dt[neighbour] (Bridge condition)
 * 
 * Use DFS method in Tarjan Algorithm
*/

// Time Complexity -> O(V+E)

/*public class scc{
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
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));


        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
    }
    public static void getBridge(ArrayList<Edge> graph[], int V){
        int[] dt = new int[V];
        int[] low = new int[V];
        boolean vis[] = new boolean[V];

        int time = 0;

        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(graph, i, vis, dt, low, time, -1);
            }
        }
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean[] vis, int[] dt, int[] low, int time, int parent){
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);

            if(e.dest==parent){
                continue;
            }
            else if(!vis[e.dest]){
                dfs(graph, e.dest, vis, dt, low, time, curr);
                low[curr] = Math.min(low[curr], low[e.dest]);

                // this if condition check the Bridge in the Graph
                if(dt[curr] < low[e.dest]){
                    System.out.println("Bridge is : "+ curr + "---" + e.dest);
                }
            }
            else{
                low[curr] = Math.min(low[curr], dt[e.dest]);
            }
        }
    }

    public static void main(String args[]){
        int V = 6;

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        getBridge(graph, V);
    }
}
*/

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//

//--> Articulation Point(Undirected Graph)
/*   A vertex in an undirected connected graph is an articulation point(or cut vertex) if removing it
 *   (and edges through it) disconnects the graph.
 * 
 *   => *Use Tarjan's Algorithm*
 * 
 *    . Ancestor : A node that was discovered before curr node in dfs, is the ancestor of curr.
 * 
 *    1. For curr node the unvisited neighbour is child
 *    2. For curr node neighbour is already visited and neighbour is parent of curr node, then do nothing (continue the algorithm)
 *    3. For curr node neighbour is already visited but neighbour is not the parent of curr node then this condition is called backedge 
 * 
 *     ** (Note) : Articulation Point Conditions(for node) : 
 *              1).(parent == -1 && children > 1) [but children are disconnected]
 *              2).(dt[curr] <= lowest dt[neighbour] && parent != -1)  [for unvisited node]
 */


// Time Complexity -> O(V+E)

public class scc{
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
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
    }

    public static void getAP(ArrayList<Edge> graph[], int V){
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        boolean vis[] = new boolean[V];
        boolean ap[] = new boolean[V];

        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(graph, 1, -1, dt, low, vis, time, ap);

            }
        }

        // Print the Articulation Point 
        for(int i=0;i<V;i++){
            if(ap[i]==true){
                System.out.println("AP : " + i);
            }
        }
    }
    public static void dfs(ArrayList<Edge> graph[], int curr, int parent, int dt[], int low[], boolean vis[], int time, boolean ap[]){
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;

        int children = 0;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            int neighbour = e.dest;

            if(parent == neighbour){
                continue;
            }
            else if(vis[neighbour]==true){ // if node visited
                low[curr] = Math.min(low[curr], dt[neighbour]);
            }
            else{ // if node is unvisited
                dfs(graph, neighbour, curr, dt, low, vis, time, ap);
                low[curr] = Math.min(low[curr], low[neighbour]);

                //Articulation Point Condition
                if(dt[curr] <= low[neighbour] && parent != -1){
                    ap[curr] = true;
                }
                children++;
            }
        }
        if(parent==-1 && children > 1){
            ap[curr] = true;
        }
    }

    public static void main(String args[]){
        int V = 5;

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        getAP(graph, V);
    }
}