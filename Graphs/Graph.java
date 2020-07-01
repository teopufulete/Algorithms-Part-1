import java.util.LinkedList;

// adjacency list graph representation
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
  
    // prints BFS traversal from a given source s 
    void BFS(int s) { 
        // Mark all the vertices as not visited(By default set as false) 
        boolean visited[] = new boolean[vertex]; 
  
        // Create a queue for BFS 
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
  
        // Mark the current node as visited and enqueue it 
        visited[s] = true; 
        queue.add(s); 
  
        while (queue.size() != 0) { 
            // Dequeue a vertex from queue and print it 
            s = queue.poll(); 
            System.out.print(s + " "); 
  
            // Get all adjacent vertices of the dequeued vertex s 
            // If a adjacent has not been visited, then mark it visited and enqueue it 
            Iterator<Integer> i = adj[s].listIterator(); 
            while (i.hasNext()) { 
                int n = i.next(); 
                if (!visited[n]) { 
                    visited[n] = true; 
                    queue.add(n); 
                } 
            } 
        } 
    } 
    
    public static void main(String args[]) { 
        
    } 
} 
