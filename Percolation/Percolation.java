import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	private boolean[][] grid; // grid[i][j] = site at row i, column j
	private final int len; // length of the grid
	private final int top = 0; // virtual top
	private final int bottom; // virtual bottom
	private final WeightedQuickUnionUF quickUnion; // a WeightedQuickUnionUF instance
	private int openSiteNumber;
	
	
	// creates n-by-n grid, with all sites initially blocked	
	public Percolation(int N) {
		if (N <= 0) throw new IllegalArgumentException();
		len = N;
        grid = new boolean[N][N];
        bottom = N * N + 1;
        quickUnion = new WeightedQuickUnionUF(N * N + 2);
    }

	
	// opens the site (row, col) if it is not open already
	public void open(int row, int col) {
		 if (row < 1 || row > len || col < 1 || col > len) throw new IndexOutOfBoundsException();
		 if (isOpen(row, col)) return;
		 grid[row - 1][col - 1] = true;
		 openSiteNumber++;

	        if (row == 1) { // union virtual top
	        	quickUnion.union(getIndex(row, col), top);
	        }
	        if (row == len) { // union virtual bottom
	        	quickUnion.union(getIndex(row, col), bottom);
	        }

	        // union possible neighbor(s)
	        if (row > 1 && isOpen(row - 1, col)) {
	        	quickUnion.union(getIndex(row, col), getIndex(row - 1, col));
	        }
	        if (row < len && isOpen(row + 1, col)) {
	        	quickUnion.union(getIndex(row, col), getIndex(row + 1, col));
	        }
	        if (col > 1 && isOpen(row, col - 1)) {
	        	quickUnion.union(getIndex(row, col), getIndex(row, col - 1));
	        }
	        if (col < len && isOpen(row, col + 1)) {
	        	quickUnion.union(getIndex(row, col), getIndex(row, col + 1));
	        }
	    }
	
	
	// is the site (row, col) open?
	public boolean isOpen(int row, int col) {
		return grid[row - 1][col - 1];
	}

	
    // is the site (row, col) full?
	public boolean isFull(int row, int col) {
		if (row <= 0 || row > len || col <= 0 || col > len) throw new IndexOutOfBoundsException();
		 return quickUnion.find(getIndex(row, col)) == quickUnion.find(0);
	}
	
	
    // returns the number of open sites
    public int numberOfOpenSites() {
    	return openSiteNumber;    	
    }
	
	
	 // does the system percolate?
	public boolean percolates() {
        return connected(top, bottom);
    }
    
    
	private int getIndex(int row, int col) {
		return len * (row - 1) + col;
	}
	
	
    private boolean connected(int p, int q) {
        return quickUnion.find(p) == quickUnion.find(q);
    }

        
    public static void main(String[] args) {
    	int len = StdIn.readInt(); 
    	int row, col;
    	Percolation perc = new Percolation(len);
    	 while (!StdIn.isEmpty()) {
             row = StdIn.readInt();
             col = StdIn.readInt();
             perc.open(row, col);
         }

         StdOut.print(perc.percolates());
    }
		
}
