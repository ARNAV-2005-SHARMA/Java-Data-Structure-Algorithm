import java.util.*;

//---Ques1).Print all the possible paths from source to destination
//--Time Complexity -> O(V^V) <-- worst time complexity 
public class AllPaths {
    static class Edge{
        int src;
        int dest;

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }
    public static void creategraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){ //convert null array list to empty array list
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
    public static void allPaths(ArrayList<Edge> graph[], boolean vis[], int curr, String path, int target){
        if(curr==target){ //Base case 
            System.out.println(path + " ");
            return;
        }
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i); //find neighbour of curr node
            if(vis[e.dest]==false){
                vis[curr] = true;
                allPaths(graph, vis, e.dest, path+e.dest, target); //print the path
                vis[curr] = false; //backtrack step
            }
        }
    }
    @SuppressWarnings("unchecked")
    public static void main(String args[]){
        int v = 7;
        ArrayList<Edge> graph[] = new ArrayList[v];
        creategraph(graph);

        int s = 0; //source 
        int tar = 5; //destination
        allPaths(graph, new boolean[v], s, "0", tar);
    } 
}
