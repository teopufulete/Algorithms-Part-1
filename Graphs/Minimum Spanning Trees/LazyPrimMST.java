public class LazyPrimMST {
    private static final double FLOATING_POINT_EPSILON = 1E-12;

    private double weight;       // total weight of MST
    private Queue<Edge> mst;     // edges in the MST
    private boolean[] marked;    // marked[v] = true iff v on tree
    private MinPQ<Edge> priorityQueue;      // edges with one endpoint in tree
    
    
    // Compute a minimum spanning tree (or forest) of an edge-weighted graph.
    public LazyPrimMST(EdgeWeightedGraph G) {
        mst = new Queue<Edge>();
        priorityQueue = new MinPQ<Edge>();
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)     // run Prim from all vertices to
            if (!marked[v]) prim(G, v);     // get a minimum spanning forest

        // check optimality conditions
        assert check(G);
    }

    // run Prim
    private void prim(EdgeWeightedGraph G, int s) {
        scan(G, s);
        while (!pq.isEmpty()) {                        // better to stop when mst has V-1 edges
            Edge e = pq.delMin();                      // smallest edge on pq
            int v = e.either(), w = e.other(v);        // two endpoints
            assert marked[v] || marked[w];
            if (marked[v] && marked[w]) continue;      // lazy, both v and w already scanned
            mst.enqueue(e);                            // add e to MST
            weight += e.weight();
            if (!marked[v]) scan(G, v);               // v becomes part of tree
            if (!marked[w]) scan(G, w);               // w becomes part of tree
        }
    }
    
    
    // add all edges e incident to v onto priority queue if the other endpoint has not yet been scanned
    private void scan(EdgeWeightedGraph G, int v) {
        assert !marked[v];
        marked[v] = true;
        for (Edge e : G.adjacent(v))
            if (!marked[e.other(v)]) priorityQueue.insert(e);
    }
    
    
    // Returns the edges in mst (or forest).
    public Iterable<Edge> edges() {
        return mst;
    }
    
    
    // returns sum of edges in mst
    public double weight() {
        return weight;
    }    
}

