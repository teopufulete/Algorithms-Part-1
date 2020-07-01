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
        list[source].addFirst(destination); //add edge
        list[destination].addFirst(source); //add back edge (for undirected)
    } 
  

    public void printGraph() {   
         for (int i = 0; i < vertex ; i++) {
            if(list[i].size() > 0) {
                System.out.print("Vertex " + i + " is connected to: ");
                for (int j = 0; j < list[i].size(); j++) {
                    System.out.print(list[i].get(j) + " ");
                }
                System.out.println();
            }
        }
    } 
  

    public static void main(String args[]) { 
        
    } 
} 
