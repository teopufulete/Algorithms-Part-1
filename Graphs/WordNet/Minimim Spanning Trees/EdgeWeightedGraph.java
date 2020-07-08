

public class EdgeWeightedGraph {
    private static final String NEWLINE = System.getProperty("line.separator");

    private final int V;
    private int E;
    private Bag<Edge>[] adj;
    
    // Initializ an empty edge-weighted graph with v vertices and 0 edges.
    public EdgeWeightedGraph(int V) {
    }

    // Initialize a random edge-weighted graph with v vertices and E edges.
    public EdgeWeightedGraph(int V, int E) {
    }

    // Initialize edge-weighted graph from an input stream.
    public EdgeWeightedGraph(In in) {
        
    }

    // Initialize a new edge-weighted graph that is a deep copy of G
    public EdgeWeightedGraph(EdgeWeightedGraph G) {

    }


    // Return the number of vertices in graph
    public int V() {
        return V;
    }

    // Return the number of edges in graph
    public int E() {
        return E;
    }

    private void validateVertex(int v) {
        
    }

    // Adds the undirected edge e to graph.
    public void addEdge(Edge e) {
    }

    // Returns the edges connected to vertex v
    public Iterable<Edge> adj(int v) {
    }

    // Returns the degree of vertex v
    public int degree(int v) {
       
    }

    // Return all edges 
    public Iterable<Edge> edges() {
       
    }

    // String representation of the edge-weighted graph.
    public String toString() {
        
    }

    // Unit tests 
    public static void main(String[] args) {

    }

}
