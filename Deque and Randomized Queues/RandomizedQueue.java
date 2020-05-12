import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
	private Item[] items; // items of items
    private int size; // number of elements in RandomizedQueue
		

	
    // construct an empty randomized queue
    public RandomizedQueue() {
        items = (Item[]) new Object[1];
        size = 0;
    }

    
    // is the randomized queue empty?
    public boolean isEmpty() {
    	return size == 0;
    }

    
    // return the number of items on the randomized queue
    public int size() {
    	return size;
    }

    
    private void resize(int capacity) {
        assert capacity >= size;
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++)
            temp[i] = items[i];
        items = temp;
    }
    
    
    // add the item
    public void enqueue(Item item) {
    	if (item == null) {
    		throw new NullPointerException();
    	}
    	
    	if (size == items.length)
            resize(2 * items.length); 
        items[size++] = item;
    }

    
	// remove and return a random item
    public Item dequeue(){
    	if (size == 0) {
    		throw new NoSuchElementException();
    	}
    	int post = StdRandom.uniform(size);
        Item item = items[post];
        items[post] = items[--size];
        items[size] = null;
        // shrink size of items if necessary
        if (size > 0 && size == items.length / 4)
            resize(items.length / 2);
        return item;
    }
    
    
    // return a random item (but do not remove it)
    public Item sample() {
    	 if (size == 0)
             throw new NoSuchElementException();
         int post = StdRandom.uniform(size);
         return items[post];
    }

    
    private class randomIterator implements Iterator <Item> {
    	private int i = size;
        private Item[] shuffledItems;

		public randomIterator() {
            shuffledItems = (Item[]) new Object[size];
            System.arraycopy(items, 0, shuffledItems, 0, size);
            StdRandom.shuffle(shuffledItems);
        }

        public boolean hasNext() {
            return i > 0;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return shuffledItems[--i];
        }
    }
    
    
    // return an independent iterator over items in random order
    public Iterator<Item> iterator(){
    	return new randomIterator();
    }
