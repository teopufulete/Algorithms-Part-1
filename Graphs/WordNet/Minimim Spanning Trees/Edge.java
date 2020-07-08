public class Edge implements Comparable<Edge> { 

    private final int v;
    private final int w;
    private final double weight;

    // Initializes an edge between vertices v and w of of given weight
    public Edge(int v, int w, double weight) {
        if (v < 0) throw new IllegalArgumentException("vertex index must be a nonnegative integer");
        if (w < 0) throw new IllegalArgumentException("vertex index must be a nonnegative integer");
        if (Double.isNaN(weight)) throw new IllegalArgumentException("Weight is NaN");
        this.v = v;
        this.w = w;
        this.weight = weight;
    }
    
     // Return weight of this edge.
    public double weight() {
        return weight;
    }

    // return either endpoint of this edge.
    public int either() {
        return v;
    }

    // return endpoint of edge that is different from given vertex.
    public int other(int vertex) {
        if(vertex == v) return w;
        else if (vertex == w) return v;
        else throw new IllegalArgumentException("Illegal endpoint");
    }

    // Compares two edges by weight.
    public int compareTo(Edge that) {
        return Double.compare(this.weight, that.weight);
    }
    
    // string representation of edge.
    public String toString() {
        return String.format("%d-%d %.5f", v, w, weight);
    }

    // Unit tests 
    public static void main(String[] args) {
        Edge e = new Edge(12, 34, 5.67);
        StdOut.println(e);
    }

}
