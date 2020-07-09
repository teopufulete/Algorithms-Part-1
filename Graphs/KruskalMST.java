public class KruskalMST {
    private static final double FLOATING_POINT_EPSILON = 1E-12;
    private double weight;                        // weight of MST
    private Queue<Edge> mst = new Queue<Edge>();  // edges in MST


    // minimum spanning tree (or forest) of an edge-weighted graph
    public KruskalMST(EdgeWeightedGraph G) {
        // more efficient to build heap by passing array of edges instead of prioriy queue
        MinPQ<Edge> pq = new MinPQ<Edge>();
        for (Edge e : G.edges()) {
            pq.insert(e);
        }
        
        // run greedy algorithm
        UF uf = new UF(G.V());
        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            if (uf.find(v) != uf.find(w)) { // v-w does not create a cycle
                uf.union(v, w);  // merge v and w components
                mst.enqueue(e);  // add edge e to mst
                weight += e.weight();
            }
        }
        
        // check optimality conditions
        assert check(G);
    }


    // Returns the edges in a minimum spanning tree (or forest).
    public Iterable<Edge> edges() {
        return mst;
    }


    // Returns the sum of the edge weights in a minimum spanning tree (or forest).
    public double weight() {
        return weight;
    }

    
    // check optimality conditions
    private boolean check(EdgeWeightedGraph G) {
        // check total weight
        double total = 0.0;
        for (Edge e : edges()) {
            total += e.weight();
        }
        
        if (Math.abs(total - weight()) > FLOATING_POINT_EPSILON) {
            System.err.printf("Weight of edges does not equal weight(): %f vs. %f\n", total, weight());
            return false;
        }
    }

    // Unit tests 
    public static void main(String[] args) {
    }
}
