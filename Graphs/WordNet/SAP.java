public class SAP {
   private Digraph diG;
   private int lastV; // remember last connection length and ancestor.
   private int lastW;
   private Iterable<Integer> lastVI;
   private Iterable<Integer> lastWI;
   private int lastLength;
   private int lastAncestor;
	
	
   // constructor takes a digraph (not necessarily a DAG)
   public SAP(Digraph G) {
	this.digraph = G;
        this.lastV = -1;
        this.lastW = -1;
        this.lastVI = null;
        this.lastWI = null;
        this.lastLength = -1;
	this.lastAncestor = -1;
   }
   
   
   // length of shortest ancestral path between v and w; -1 if no such path
   public int length(int v, int w) {
	checkInput(v);
        checkInput(w);
        if ((lastV == v && lastW == w) || (lastV == w && lastW == v)) {
            return lastLength;
        }
        bfs(v, w);
        return lastLength;

   }

	
   // a common ancestor of v and w that participates in a shortest ancestral path; -1 if no such path
   public int ancestor(int v, int w) {
	checkInput(v);
        checkInput(w);

        if ((lastV == v && lastW == w) || (lastV == w && lastW == v)) {
            return lastAncestor;
        }
	   
        bfs(v, w);
        return lastAncestor;
   }

	
   // length of shortest ancestral path between any vertex in v and any vertex in w; -1 if no such path
   public int length(Iterable<Integer> v, Iterable<Integer> w) {
        checkInput(v);
        checkInput(w);

        if ((lastV == v && lastW == w) || (lastV == w && lastW == v)) {
            return lastAncestor;
        }
	   
        bfs(v, w);
        return lastAncestor;
    }

	
   // a common ancestor that participates in shortest ancestral path; -1 if no such path
   public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
        checkInput(v);
        checkInput(w);
           
        if (lastVI != null && lastWI != null) {
            if ((lastVI.equals(v) && lastWI.equals(w)) || (lastVI.equals(w) && lastWI.equals(v))) {
                return lastAncestor;
            }
        }
           
        bfs(v, w);
        return lastAncestor;
   }
   

   private void checkInput(int vertex) {
        if (vertex < 0 || vertex > digraph.V() - 1) throw new java.lang.IndexOutOfBoundsException();
   }
   
	
   private void checkInput(Iterable<Integer> vertex) {
        for (Integer v : vertex) {
		if (v < 0 || v > digraph.V() - 1) throw new java.lang.IndexOutOfBoundsException();
        }
   }
   
	
   private void cache(int v, int w, int length, int ancestor) {
        lastV = v;
        lastW = w;
        lastVI = null;
        lastWI = null;
        lastLength = length;
        lastAncestor = ancestor;
   }
   
	
   private void cache(Iterable<Integer> v, Iterable<Integer> w, int length, int ancestor) {
       
   }
   
	
   private void bfs(int v, int w) {
        
   }


   private void bfs(Iterable<Integer> v, Iterable<Integer> w) {

   }
   
	
   // for unit testing of this class 
   public static void main(String[] args) {
	   
   }
}
