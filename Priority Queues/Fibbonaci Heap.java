import java.util.NoSuchElementException;

public class FibonacciHeap {
	 public static final class Entry<T> {
		 private int     mDegree = 0;       //Number of children
	     private boolean mIsMarked = false; //Whether this node is marked
	     private Entry<T> mNext;   //Next and previous elements in the list
	     private Entry<T> mPrev;
	     private Entry<T> mParent; //Parent in the tree, if any.
	     private Entry<T> mChild;  //Child node, if any.
	     private T      mElement;  //Element being stored here
	     private double mPriority; //Its priority
	     
	     public T getValue() { //Returns the element represented by this heap entry.
	    	 return mElement;
	     }
	     
	     public void setValue(T value) { //Sets the element associated with this heap entry.
	    	 mElement = value;
	     }
	     
	     public double getPriority() { //Returns the priority of element.
	    	 return mPriority;
	     }
	     
	     private Entry(T element, double priority) { //Constructs a new Entry that holds the given element with the indicated priority.
	    	 mNext = mPrev = this;
	         mElement = element;
	         mPriority = priority;
	     }
	 }
	 
	 
	 private Entry<T> nMin = null; //Pointer to the minimum element in the heap.
	 
	 
	 private int mSize = 0; //Cached size of the heap, to avoid recomputing.
	 
	 
	 //Inserts the specified element into the Fibonacci heap with the specified
     //priority.  Its priority must be a valid double, so you cannot set the priority to NaN.
	 public Entry<T> enqueue(T value, double priority) {
		 checkPriority(priority);
	     Entry<T> result = new Entry<T>(value, priority); //Create the entry object, which is a circularly-linked list of length 1
	     mMin = mergeLists(mMin, result); //Merge this singleton list with the tree list. 
	     ++mSize;
	     return result;
	 }
	 
	 
	 public Entry<T> min() { //Returns an Entry object corresponding to the minimum element of the Fibonacci heap
		 if (isEmpty())
			 throw new NoSuchElementException("Heap is empty.");
	     return mMin;
	 }
	 
	 
	 public boolean isEmpty() {
		 return mMin == null;
	 }
	 
	 
	 public int size() {
		 return mSize;
	 }
	 
	 
	 public static <T> FibonacciHeap<T> merge(FibonacciHeap<T> one, FibonacciHeap<T> two) {
		 FibonacciHeap<T> result = new FibonacciHeap<T>(); //Create a new FibonacciHeap to hold the result. */
	     result.mMin = mergeLists(one.mMin, two.mMin); //Merge the two Fibonacci heap root lists together. Also computes the min of the two lists, so we can store the result in the mMin field of the new heap.
	     result.mSize = one.mSize + two.mSize; //size of the new heap = sum of the sizes of the input heaps. */
	     //Clear the old heaps.
	     one.mSize = two.mSize = 0;
	     one.mMin  = null;
	     two.mMin  = null;
	     return result;
	    }
	        
}
