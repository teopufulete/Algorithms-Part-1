//adjacency list directed graph implementation

public class DirectedGraph {
    
    private static final String NEWLINE = System.getProperty("line.separator");
    private final int vertices;           // number of vertices in this digraph
    private int edges;                 // number of edges in this digraph
    private Bag<Integer>[] list;    // list[v] = adjacency list for vertex v
    private int[] indegree;        // indegree[v] = indegree of vertex v
    
    
    // Initializes an empty digraph with vertices.
    public DirectedGraph(int vertices) {
        if (vertices < 0) throw new IllegalArgumentException("Number of vertices in a graph must be nonnegative");
        this.vertices = vertices;
        this.E = 0;
        indegree = new int[vertices];
        list = (Bag<Integer>[]) new Bag[vertices];
        for (int vertex = 0; vertex < vertices; vertex++) {
            list[vertex] = new Bag<Integer>();
        }
    }
     
    
    // Initializes a digraph from the specified input stream. 
    public DirectedGraph(In input) {
        if (in == null) throw new IllegalArgumentException("argument is null");
        
        try {
            this.vertices = in.readInt();
            if (vertices < 0) throw new IllegalArgumentException("number of vertices in a Digraph must be nonnegative");
            indegree = new int[vertices];
            list = (Bag<Integer>[]) new Bag[vertices];
            for (int vertex = 0; vertex < vertices; vertex++) {
                list[vertex] = new Bag<Integer>();
            }
            
            int edges = in.readInt();
            if (edges < 0) throw new IllegalArgumentException("number of edges in a Digraph must be nonnegative");
            for (int i = 0; i < edges; i++) {
                int vertex = in.readInt();
                int destination = in.readInt();
                addEdge(vertex, destination); 
            }
        }
 
        catch (NoSuchElementException e) {
            throw new IllegalArgumentException("invalid input format in Digraph constructor", e);
        } 
    }


    // Initializes a new digraph that is a deep copy of the specified digraph.
    public DirectedGraph(DirectedGraph G) {
       
    }
      
      
    // Returns the number of vertices in this digraph.
    public int vertices() {
       
    }


    // Returns the number of edges in this digraph.
    public int edges() {
        
    }


    private void validateVertex(int vertex) {
        
    }


    // Adds the directed edge vertex→destination to this digraph.
    public void addEdge(int vertex, int destination) {

    }


    // Returns the vertices adjacent from vertex in this digraph.
    public Iterable<Integer> adj(int vertex) {
   
    }


    // Returns the number of directed edges incident from vertex 
    public int outdegree(int vertex) {

    }


    // Returns the number of directed edges incident to vertex 
    public int indegree(int vertex) {
        
    }


    // Returns the reverse of the digraph.
    public Digraph reverse() {
        
    }


    // Returns a string representation of the graph.
    public String toString() {

    }

    // Unit test client
    public static void main(String[] args) {
        
    }
}
