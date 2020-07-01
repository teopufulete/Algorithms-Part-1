//adjacency list graph representation
import java.util.LinkedList;

class Graph { 
    private int vertex;   // No. of vertices 
    private LinkedList<Integer> list[]; // Adjacency Lists 

  
    // Constructor 
    public Graph(int vertex) { 
        this.vertex = vertex;
        list = new LinkedList[vertex];
        
        for (int i = 0; i < vertex ; i++) {
            list[i] = new LinkedList<>();
        }
    } 
  
    // Function to add an edge into the graph 
    void addEdge(int source, int destination) { 
       
    } 
  

    public void printGraph(){    
    } 
  

    public static void main(String args[]) { 
        
    } 
} 
