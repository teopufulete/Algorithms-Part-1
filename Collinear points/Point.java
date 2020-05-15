import java.util.Comparator;
import edu.princeton.cs.algs4.StdDraw;

public class Point implements Comparable<Point>{
	
	private final int x;     // x-coordinate of this point
	private final int y;     // y-coordinate of this point
	
	
	//initialize new point
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
	//Draws this point to standard draw
	public void draw() {
		StdDraw.point(x,  y);
	}
	
	
	//Draws the line segment between this point and the specified point
	public void drawTo(Point that) {
		StdDraw.line(this.x, this.y, that.x, that.y);
	}
	
	
	// string representation
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
	
	// compare two points by y-coordinates, breaking ties by x-coordinates
	public int compareTo(Point that) {
        if (y == that.y && x == that.x) {
            return 0;
        }
        
        if (y < that.y || (y == that.y && x < that.x)) {
            return -1;
        }
        
        return 1;
	}
	
	
	// the slope between this point and that point
	public double slopeTo(Point that) {
		if (that == null) {
            throw new NullPointerException();
        }
		
        if (that.x == x) {
            if (that.y == y) {
                return Double.NEGATIVE_INFINITY;
            }
            return Double.POSITIVE_INFINITY;
        }
        
        if (that.y == y) {
            return 0.0;
        }
        
        return (double) (that.y - this.y) / (that.x - this.x);
    }
	
	
	// compare two points by slopes they make with this point
	public Comparator<Point> slopeOrder(){
		return new slopeComp();
	}
	
	
	private class slopeComp implements Comparator<Point>{
		public int compare(Point p1, Point p2) {
			double slope1 = slopeTo(p1);
			double slope2 =  slopeTo(p2);
			
			return Double.compare(slope1, slope2);
		}
	}
	
	
	public static void main(String[] args) {
    }

}
