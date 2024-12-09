import java.util.*;
//Basic Implementation of the Graph
public class graph{
    //Undirected unweighted Graph and Undirected Weighted Graph
    //Create a graph with the help of Adjacency List
    static class Edge{
        int src;
        int dest;
        int weight;

        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
    }
    public static void creategraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<Edge>(); //create a empty array list from null array list
        }
        graph[0].add(new Edge(0, 2, 1)); //vertex = 0

        graph[1].add(new Edge(1, 2, 2)); //vertex = 1
        graph[1].add(new Edge(1, 3, 8));

        graph[2].add(new Edge(2, 0, 1)); //vertex = 2
        graph[2].add(new Edge(2, 1, 2));
        graph[2].add(new Edge(2, 3, 6));

        graph[3].add(new Edge(3, 1, 8)); //vertex = 3
        graph[3].add(new Edge(3, 2, 6));

    }
    public static void main(String args[]){
        int size = 4; //count of vertex
        ArrayList<Edge> graph[] = new ArrayList[size]; //Array of arrayList
        creategraph(graph);

        //print 2's neighbours
        for(int i=0;i<graph[2].size();i++){ 
            Edge e = graph[2].get(i);
            System.out.println(e.dest+", "+e.weight);
             
        }
    }
}


//--BFS Traversal in Graph--//
//--Time Complexity -> O(V+E)
//*Using Queue and boolean visitied array*/
//--One Component
/*public class graph{
    static class Edge{
        int src;
        int dest;

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }
    public static void creategraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));
    }
    public static void bfs(ArrayList<Edge> graph[], int V){
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[V];

        q.add(0);
        while(!q.isEmpty()){
            int curr = q.remove();
            if(vis[curr]==false){
                System.out.print(curr+" "); //print the curr node
                vis[curr] = true; //true the visitied node 

                for(int i=0;i<graph[curr].size();i++){ //add vertex(curr node) neighbour in queue
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }
    public static void main(String args[]){
        int size = 7;// v = 0, 1, 2, 3, 4, 5, 6
        ArrayList<Edge> graph[] = new ArrayList[size];
        creategraph(graph);
        bfs(graph, size);
    }
}*/



//--Disconnected Component(two graph) or two starting Point
//--BFS Traversal--> using queue and boolean visited Array
//--Time Complexity -> O(V+E)--//
/*public class graph{
    static class Edge{
        int src;
        int dest;

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }
    public static void creategraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));
    }
    public static void bfs(ArrayList<Edge> graph[], int V, boolean vis[], int start){
        Queue<Integer> q = new LinkedList<>();
        

        q.add(start);
        while(!q.isEmpty()){
            int curr = q.remove();
            if(vis[curr]==false){
                vis[curr] = true; //true the visitied node 
                System.out.print(curr+" "); //print the curr node

                for(int i=0;i<graph[curr].size();i++){ //add vertex(curr node) neighbour in queue
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }
    public static void main(String args[]){
        int size = 7;// v = 0, 1, 2, 3, 4, 5, 6
        ArrayList<Edge> graph[] = new ArrayList[size];
        creategraph(graph);

        boolean vis[] = new boolean[size];
        for(int i=0;i<size;i++){
            if(vis[i]==false){
                bfs(graph, size, vis, i);
            }
        }
        
    }
}*/


//--DfS Traversal in Graph
//Time Complexity -> O(V+E)

/*public class graph{
    static class Edge{
        int src;
        int dest;

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }
    public static void creategraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));
    }
    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]){
        System.out.print(curr + " ");
        vis[curr]= true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i); //to find neighbour 
            if(vis[e.dest]==false){ // e.dest = neighbour
                dfs(graph, e.dest, vis); // tto call the neighbour
            }
        }
    }
    public static void main(String args[]){
        int length = 7;
        ArrayList<Edge> graph[] = new ArrayList[length];
        boolean vis[] = new boolean[length];
        creategraph(graph);

        //for disconnected graph(two starting point in the graph)
        // for(int i=0;i<length;i++){
        //     if(vis[i]==false){
        //         dfs(graph, i, vis);
        //     }
        // }

        
        dfs(graph, 0, vis); //output = 0 1 3 4 2 5 6
    }
}*/
