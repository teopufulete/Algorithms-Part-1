import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
	private final int triesCount;
	private static Percolation perc;
	private final double[] fractions;	


	//performs T independent operations on an N by N grid
	public PercolationStats(int N, int T) {
		if (N <= 0 || T <= 0) {
			throw new IllegalArgumentException("Given N <= 0 || T<= 0");
		}
	
		triesCount = T;
		fractions = new double[triesCount];
		
		for (int triesNum = 0; triesNum < triesCount; triesNum++) {
			perc = new Percolation(N);
			int openedSites = 0;
			while (!perc.percolates()) {
				int row = StdRandom.uniform(1, N + 1);
				int col = StdRandom.uniform(1, N + 1);
				
				if (!perc.isOpen(row, col)) {
					perc.open(row, col);
					openedSites++;
				}
			}
			
			double fraction = (double) openedSites / (N * N);
			fractions[triesNum] = fraction;
		}
	}
	
	
	//sample mean of percolation threshold
	public double mean() {
		return StdStats.mean(fractions);
	}
	
	
	//sample standard deviation of percolation threshold
	public double stddev() {
		return StdStats.stddev(fractions);
	}
	
	
	//high bound of 95% confidence interval
	public double confidenceHi() {
		return mean() + (1.96 * stddev()) / Math.sqrt(triesCount);
	}
	
	
	//low bound of 95% confidence interval
	public double confidenceLo() {
		return mean() - (1.96 * stddev()) / Math.sqrt(triesCount);
	}
	
	
	public static void main(String[] args) {
		int N = StdIn.readInt();
		int T = StdIn.readInt();
		assert (T > 0);
		PercolationStats percSts = new PercolationStats(N,T);
		
		String confidence = percSts.confidenceLo() + ", " + percSts.confidenceHi();
        StdOut.println("stddev                  = " + percSts.stddev());
        StdOut.println("95% confidence interval = " + confidence);
	}
}
