public class DepthFirstSearch {
    private boolean[] marked;    // marked[v] = is there an s-v path?
    private int count;           // number of vertices connected to s

    
    // Computes the vertices in graph G that are connected to the source vertex s.
    public DepthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        validateVertex(s);
        dfs(G, s);
    }


    // dfs from v
    private void dfs(Graph G, int v) {
        count++;
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
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
