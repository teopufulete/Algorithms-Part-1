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
}
