public class LazyPrimMST {
    private static final double FLOATING_POINT_EPSILON = 1E-12;

    private double weight;       // total weight of MST
    private Queue<Edge> mst;     // edges in the MST
    private boolean[] marked;    // marked[v] = true iff v on tree
    private MinPQ<Edge> priorityQueue;      // edges with one endpoint in tree
    
    
    // Compute a minimum spanning tree (or forest) of an edge-weighted graph.
    public LazyPrimMST(EdgeWeightedGraph G) {
        
    }


}

