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

	// dirka moves UP
        if (i - 1 >= 0) {
            Board u = this.copyButTwin(false);
            u.swapTiles(currentDIRKAIndex, xyTo1D(i - 1, j));
            Neighbors.enqueue(u);
        }
        
        // dirka moves down
        if (i + 1 < n) {
            Board d = this.copyButTwin(false);
            d.swapTiles(currentDIRKAIndex, xyTo1D(i + 1, j));
            Neighbors.enqueue(d);
        }
        
        // dirka moves left
        if (j - 1 >= 0) {
            Board l = this.copyButTwin(false);
            l.swapTiles(currentDIRKAIndex, xyTo1D(i, j - 1));
            Neighbors.enqueue(l);
        }
        
        // dirka moves right
        if (j + 1 < n) {
            Board r = this.copyButTwin(false);
            r.swapTiles(currentDIRKAIndex, xyTo1D(i, j + 1));
            Neighbors.enqueue(r);
        }
        return Neighbors;
     }
	
	
    // returns [position] in 1D array from [X][Y] position of 2D array
    private int xyTo1D(final int x, final int y) {
        return (n * (x) + y);
    }
    
	
    // returns {X,Y} coords from [1D] coordinate.
    // init array count begins from 1 !!!
    private int[] toXY(final int d) {
        int x = (d - 1) / n;
        int y = (d - 1) % n;
        return new int[] { x, y };
    }
	
	
    // swap tiles i and k of this.jBoard
    private void swapTiles(int i, int k) {
        char aux = this.Board[i];
        this.Board[i] = this.Board[k];
        this.Board[k] = aux;
    }
	
	
    // a board that is obtained by exchanging any pair of tiles
    // first pair of non-dirka blocks
    public Board twin() {
    	return this.copyButTwin(true);
    }
    
    
    // returns Board as matrix toString
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(n + "\n");
        int lol = 0;
        for (int i = 0; i < Board.length; i++) {
            sb.append(String.format("%2d ", (int) Board[i]));
            // always make new line followed by matrix dimension
            if (lol++ % n == n - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
	
	
    // unit testing (not graded)
    public static void main(String[] args) {
    	int n = 3;
        int blocks[][] = new int[n][];
        System.out.println("Board fields:");
        for(int i = 0; i < n; ++i) {
            blocks[i] = new int[n];
            for(int j = 0; j < n; ++j) {
                blocks[i][j] = i * n + j;
                System.out.print(blocks[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Creating Board");
        Board board = new Board(blocks);
        System.out.println(board);

        System.out.println("Twin:");
        Board twin = board.twin();
        System.out.println(twin);
        assert(!twin.equals(board));

        System.out.println("Neighbours:");
        for(Board b : board.neighbors()) {
            System.out.println("Hamming = " + b.hamming() + " Manhattan = " + b.manhattan());
            System.out.println(b);
        }

        System.out.println("Board fields:");
        blocks[0] = new int[] {1, 0, 2};
        blocks[1] = new int[] {3, 4, 5};
        blocks[2] = new int[] {6, 7, 8};
        
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                System.out.print(blocks[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Creating Board");
        board = new Board(blocks);
        System.out.println(board);

        System.out.println("Twin:");
        twin = board.twin();
        System.out.println(twin);
        assert(!twin.equals(board));

        System.out.println("Neighbours:");
        for(Board b : board.neighbors()) {
            System.out.println("Hamming = " + b.hamming() + " Manhattan = " + b.manhattan());
            System.out.println(b);
        }
    }
}
