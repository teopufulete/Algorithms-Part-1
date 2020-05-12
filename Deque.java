import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int size;

    
    private class Node {
        private Node next;
        private Node prev;
        private Item item;
    }
	
    
    // construct an empty deque
    public Deque() {
    	first = null;
        last = null;
        size = 0;
    }
    
  
    // is the deque empty?
    public boolean isEmpty() {
    	return size == 0;
    }

    
    // return the number of items on the deque
    public int size() {
    	return size;
    }

    
    // add the item to the front
    public void addFirst(Item item) {
    	if (null == item) {
    		throw new NullPointerException();
    	}
    	
    	Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.prev = null;
        first.next = oldFirst;

        if (isEmpty()) {
            last = first;
        }
        
        else {
            oldFirst.prev = first;
        }
        
        size++;
    }
    	

    
    // add the item to the back
    public void addLast(Item item) {
    	if (item == null) {
    		throw new NullPointerException();
    	}
    	
    	Node newLast = new Node();
        newLast.item = item;
        newLast.next = null;
        newLast.prev = last;

        if (isEmpty()) {
        	first = newLast;
        }
        
        else {
            last.next = newLast;
        }
        
        last = newLast;
        size++;
    }

    
    // remove and return the item from the front
    public Item removeFirst() {
    	if (isEmpty()) {
    		throw new NoSuchElementException();
    	}
    	
    	Node oldFirst = first;
        Item item = oldFirst.item;

        first = oldFirst.next;
        size--;

        if (isEmpty()) {
            first = null;
            last = first;
        } 
        
        else {
            first.prev = null;
        }
        
        return item;
    }

    
    // remove and return the item from the back
    public Item removeLast() {
    	if (isEmpty()) {
    		throw new NoSuchElementException("The deque is empty!");
    	}
    	Node oldLast = last;
        Item item = oldLast.item;

        last = oldLast.prev;
        size--;

        if (isEmpty()) {
            first = null;
            last = null;
        } 
        
        else {
            last.next = null;
        }

        return item;
    	
    }

    
    // return an iterator over items in order from front to back
    public Iterator<Item> iterator(){
    	return new Iterator<Item>() {
            private Node current = first;

            public boolean hasNext() {
                return current != null;
            }

            public Item next() {
                if (!hasNext()) throw new NoSuchElementException();
                Item item = current.item;
                current = current.next;
                return item;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    
    
    // unit testing (required)
    public static void main(String[] args) {
    	
    }
}
