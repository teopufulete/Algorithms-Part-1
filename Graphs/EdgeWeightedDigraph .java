import java.util.NoSuchElementException;

public class EdgeWeightedDigraph {
    private static final String NEWLINE = System.getProperty("line.separator");

    private final int V;                // number of vertices in this digraph
    private int E;                      // number of edges in this digraph
    private Bag<DirectedEdge>[] adj;    // adj[v] = adjacency list for vertex v
    private int[] indegree;             // indegree[v] = indegree of vertex v
    

    public EdgeWeightedDigraph(int V) {
        
    }

    
    public EdgeWeightedDigraph(int V, int E) {

    }

   
    public EdgeWeightedDigraph(In in) {
        
    }

    
    public EdgeWeightedDigraph(EdgeWeightedDigraph G) {
       
    }


    // return number of vertices 
    public int V() {

    }


    // return number of edges 
    public int E() {
     
    }

 
    private void validateVertex(int v) {
       
    }


    public void addEdge(DirectedEdge e) {

    }



    public Iterable<DirectedEdge> adj(int v) {
        
    }


    public int outdegree(int v) {
       
    }


    public int indegree(int v) {

    }


    public Iterable<DirectedEdge> edges() {

    } 

    // string representation of the edge-weighted digraph.
    public String toString() {
        
    }

    // unit tests
    public static void main(String[] args) {
     
    }
}
