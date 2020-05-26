import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {
	private ArrayList<LineSegment> Segments = new ArrayList<>();
	 
	//finds all line segments containing 4 points
	public BruteCollinearPoints(Point[] points) {
		if (points == null) 
			throw new NullPointerException();
		
		Point[] Copy = points.clone();
		Arrays.sort(Copy);
		
		if (hasDuplicate(Copy)) {
			throw new IllegalArgumentException();			
		}
		
		for (int first = 0; first < Copy.length - 3; first++) {
			for (int second = first + 1; second < Copy.length - 2; second++) {
				double slopeFS = Copy[first].slopeTo(Copy[second]);
				for (int third = second + 1; third < Copy.length - 1; third++) {
					if (slopeFS == slopeFT) {
						for (int fourth = third + 1; fourth < Copy.length; fourth++) {
							double slopeFF = Copy[first].slopeTo(Copy[fourth]);
							if (slopeFS == slopeFF) {
								Segments.add(new LineSegment(Copy[first], Copy[fourth]));
                            				}
                        			}
                    			}
               			}
            		}
        	}
	}
		
	private boolean hasDuplicate(Point[] points) {
		for (int i = 0; i < points.length - 1; i++) {
			if (points[i].compareTo(points[i + 1]) == 0) {
				return true;
            		}
        	}
        	return false;
    	}
	
	
	// the number of line segments
	public int numberOfSegments() {
		return Segments.size();
	}
	
	
	// the line segments
	public LineSegment[] segments() {
		return Segments.toArray(new LineSegment[Segments.size()]);
	}
	
}
