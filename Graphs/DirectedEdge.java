public class DirectedEdge { 
    private final int v;
    private final int w;
    private final double weight;


    public DirectedEdge(int v, int w, double weight) {
        if (v < 0) throw new IllegalArgumentException("Vertex names must be nonnegative integers");
        if (w < 0) throw new IllegalArgumentException("Vertex names must be nonnegative integers");
        if (Double.isNaN(weight)) throw new IllegalArgumentException("Weight is NaN");
        this.v = v;
        this.w = w;
        this.weight = weight;
    }
    
    
    public int from() {

    }


    public int to() {
        
    }

   
    public double weight() {
        
    }

    
    public String toString() {
        
    }

    //unit testing
    public static void main(String[] args) {

    }
}
