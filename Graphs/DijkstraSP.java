public class DijkstraSP {
    private double[] distTo;          // distTo[v] = distance of shortest s->v path
    private DirectedEdge[] edgeTo;    // edgeTo[v] = last edge on shortest s->v path
    private IndexMinPQ<Double> pq;    // priority queue of vertices
    

    // computes a shortest-paths tree from source vertexs to every other vertex .
    public DijkstraSP(EdgeWeightedDigraph G, int s) {
        for (DirectedEdge e : G.edges()) {
            if (e.weight() < 0)
                throw new IllegalArgumentException("edge " + e + " has negative weight");
        }

        distTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];

        validateVertex(s);

        for (int v = 0; v < G.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;
        distTo[s] = 0.0;

        // relax vertices in order of distance from s
        pq = new IndexMinPQ<Double>(G.V());
        pq.insert(s, distTo[s]);
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            for (DirectedEdge e : G.adj(v))
                relax(e);
        }

        // check optimality conditions
        assert check(G, s);
    }

   
    private void relax(DirectedEdge e) {
        
    }

   
    public double distTo(int v) {
        
    }

    
    public boolean hasPathTo(int v) {
        
    }

    
    public Iterable<DirectedEdge> pathTo(int v) {

    }


    
    private boolean check(EdgeWeightedDigraph G, int s) {

    }

    
    private void validateVertex(int v) {
        
    }

    
    public static void main(String[] args) {
        
    }
}
