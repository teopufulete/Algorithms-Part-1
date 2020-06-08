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
}
