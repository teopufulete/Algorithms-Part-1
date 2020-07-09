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
    }


    // Returns the edges in a minimum spanning tree (or forest).
    public Iterable<Edge> edges() {
        return mst;
    }


    // Returns the sum of the edge weights in a minimum spanning tree (or forest).
    public double weight() {
        return weight;
    }


    // Unit tests 
    public static void main(String[] args) {
    }
}
