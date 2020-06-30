public class DepthFirstSearch {
    private boolean[] marked;    // marked[v] = is there an s-v path?
    private int count;           // number of vertices connected to s

    
    // Computes the vertices in graph G that are connected to the source vertex s.
    public DepthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        validateVertex(s);
        dfs(G, s);
    }


    private void dfs(Graph G, int v) {

    }


    public boolean marked(int v) {

    }


    public int count() {
        return count;
    }



    public static void main(String[] args) {
                    StdOut.println("connected");
    }
}
