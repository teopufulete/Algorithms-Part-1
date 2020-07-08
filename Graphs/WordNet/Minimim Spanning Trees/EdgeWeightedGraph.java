import java.util.NoSuchElementException;


public class EdgeWeightedGraph {
    private static final String NEWLINE = System.getProperty("line.separator");

    private final int V;
    private int E;
    private Bag<Edge>[] adjacent;
    
    
    // Initializ an empty edge-weighted graph with v vertices and 0 edges.
    public EdgeWeightedGraph(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
        this.V = V;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adjacent[v] = new Bag<Edge>();
        }
    }

    
    // Initialize a random edge-weighted graph with V vertices and E edges.
    public EdgeWeightedGraph(int V, int E) {
        this(V);
        if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
        for (int i = 0; i < E; i++) {
            int v = StdRandom.uniform(V);
            int w = StdRandom.uniform(V);
            double weight = Math.round(100 * StdRandom.uniform()) / 100.0;
            Edge e = new Edge(v, w, weight);
            addEdge(e);
        }
    }
    

    // Initialize edge-weighted graph from an input stream.
    public EdgeWeightedGraph(In in) {
        if (in == null) throw new IllegalArgumentException("argument is null");

        try {
            V = in.readInt();
            adjacent = (Bag<Edge>[]) new Bag[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new Bag<Edge>();
            }

            int E = in.readInt();
            if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
            for (int i = 0; i < E; i++) {
                int v = in.readInt();
                int w = in.readInt();
                validateVertex(v);
                validateVertex(w);
                double weight = in.readDouble();
                Edge e = new Edge(v, w, weight);
                addEdge(e);
            }
        }   
        
        catch (NoSuchElementException e) {
            throw new IllegalArgumentException("invalid input format in EdgeWeightedGraph constructor", e);
        }
        
    }

    
    // Initialize a new edge-weighted graph that is a deep copy of G
    public EdgeWeightedGraph(EdgeWeightedGraph G) {
        this(G.V());
        this.E = G.E();
        for (int v = 0; v < G.V(); v++) {
            // reverse so that adjacency list is in same order as original
            Stack<Edge> reverse = new Stack<Edge>();
            for (Edge e : G.adj[v]) {
                reverse.push(e);
            }
            for (Edge e : reverse) {
                adjacent[v].add(e);
            }
        }
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
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
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
