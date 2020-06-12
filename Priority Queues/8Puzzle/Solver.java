import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;


public class Solver {
	private JNode bNode, TwinNode;
	

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
	int moves = 0;
        bNode = new JNode(initial, moves);
        TwinNode = new JNode(initial.twin(), moves);
        MinPQ<JNode> Queue = new MinPQ<>();
        
        //insert both
        Queue.insert(bNode);
        Queue.insert(TwinNode);
        //choose nice one to solve
        bNode = Queue.delMin();
        
        // till the very end...
        while (!bNode.isGoal()) {
            // make node neighbors stack
            Stack<Board> neighbors = new Stack<Board>();
            //and add all the neighbors for this node there
            for (Board b : bNode.neighbors()) {
                neighbors.push(b);
            }

            moves = bNode.moves + 1;

            // now check each neighbor
            for (Board b : neighbors) {
                Board bPrevious = null;

                // temp previous state
                if (bNode.prev != null) {
                    bPrevious = bNode.prev.getjBoard();
                }
                
                // when find really NEW one, 
                // add new node to Queue
                if (!b.equals(bPrevious)) {
                    JNode node = new JNode(b, moves);
                    node.prev = bNode;
                    Queue.insert(node);
                }
            }
            // next node to proceed
            bNode = Queue.delMin();
        }
    }

    
    
    // returns true if the initial board solvable
    public boolean isSolvable() {
	// get solved
        JNode firstNode = bNode;
        
        // and move backwards to the start
        while (firstNode.prev != null) {
            firstNode = firstNode.prev;
        }
        
        // compare init state
        // if solved one not twin, so exactly initial was solvable haha xD
        // or vise versa
        return firstNode.getjBoard().equals(TwinNode.getjBoard()) ? false : true;
    }

    
    
    // min number of moves to solve initial board
    public int moves() {
	 return isSolvable() ? bNode.moves : -1;
    }

    
    
    // sequence of boards in a shortest solution
    public Iterable<Board> solution() {
	        	 JNode sequenceNode = bNode;

         if (isSolvable()) {
             Stack<Board> solutionQueue = new Stack<Board>();

             solutionQueue.push(sequenceNode.getjBoard());
             while (sequenceNode.prev != null) {
                 sequenceNode = sequenceNode.prev;
                 solutionQueue.push(sequenceNode.getjBoard());
             }
             return solutionQueue;
         } 
         else return null;
    }
    
    
     private class JNode implements Comparable<JNode> {
    }
}
