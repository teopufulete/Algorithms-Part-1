import edu.princeton.cs.algs4.Queue;

public class Board {
    private static final int DIRKA = 0;		// imaginary tile
	private char Board[];
	private final int n;
	
	
    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles) {
    	n = tiles.length;
    	Board = new char[n * n];
    	int elem = 0;
        for (int[] cs : tiles) {
            for (int c : cs) {
                Board[elem++] = (char) c;
            }
        }
    }
	
	
	// board dimension n
    public int dimension() {
    	return n;
    }

    
    
    // number of tiles out of place
    public int hamming() {
        int out = 0;
        int i = 1;
        // from 1 to end
        for (char c : Board) {
            if ((int) c != 0 && (int) c != i) {
                // check last properly
                if ((int) c == Board.length - 1) {
                    continue;
                }
                out++;
            }
            i++;
        }
        return out;
    }
	
	
// sum of Manhattan distances between tiles and goal
    public int manhattan() {
    	int out = 0;
        int i = 1;
	    
        // from 1 to end
        for (char c : Board) {
            if ((int) c != 0 && (int) c != i) {
                // check last properly
                if ((int) c == Board.length - 1) {
                    continue;
                }
                // row steps
                final int dR = toXY((int) c)[0] - toXY(i)[0];
                // colomn
                final int dC = toXY((int) c)[1] - toXY(i)[1];
                // count all
                out += java.lang.Math.abs(dR) + java.lang.Math.abs(dC);
            }
            i++;
        }
        return out;
    }
 
    
    // is this board the goal board?
    public boolean isGoal() {
    	return hamming() == 0;
    }
	
	
    // return the clone of current board on "false" input,
    // and twin-copy if input param is "true"
    private Board copyButTwin(boolean twn) {
        boolean twined = false;
        
        // clone 1D array into 2D
        int[][] twinBoard = new int[n][n];
        int Index = 0;
        int One = 0, Two = 0;
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                twinBoard[i][k] = this.Board[Index++];
                // find first two tiles (not DIRKA) and remember to swap
                if (!twined && Index > 0 && (int) this.Board[Index - 1] != DIRKA
                        && (int) this.Board[Index] != DIRKA) {
                    One = Index;
                    Two = Index - 1;
                    twined = true;
                }
            }
        }
        
        Board twin = new Board(twinBoard);
        if (twn) {
            twin.swapTiles(One, Two);
        }
        return twin;
    }

	// does this board equal y?
    public boolean equals(Object y) {
    	 if (y == null)
             return false;
         if (y == this)
             return true;
         if (y.getClass() != this.getClass())
             return false;
         Board that = (Board) y;
         if (that.dimension() != this.dimension())
             return false;
         for (int i = 0; i < that.dimension() * that.dimension(); i++) {
             if (this.Board[i] != that.Board[i])
                 return false;
         }
         return true;
    }
	
	
// all neighboring boards
    public Iterable<Board> neighbors() {
    	Queue<Board> Neighbors = new Queue<Board>();
        int currentDIRKAIndex = -1;
        
        // try to find dirka
        for (int i = 0; i < Board.length; i++) {
            if (Board[i] == DIRKA) {
                currentDIRKAIndex = i;
                break;
            }
        }
        
        int i = currentDIRKAIndex / n;
        int j = currentDIRKAIndex % n;
}
