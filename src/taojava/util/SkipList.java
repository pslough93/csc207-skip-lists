package taojava.util;

import java.util.Iterator;
import java.util.Random;

/**
 * A randomized implementation of sorted lists.
 * 
 * @author Samuel A. Rebelsky
 * @author Your Name Here
 */
public class SkipList<T extends Comparable<T>> implements SortedList<T> {
	// +--------+----------------------------------------------------------
	// | Fields |
	// +--------+

	int maxLevel = 20;
	int size;
	Random rand;
	Node header;
	double p = .5;

	// +------------------+------------------------------------------------
	// | Internal Classes |
	// +------------------+

	/**
	 * Nodes for skip lists.
	 */
	public class Node {
		// +--------+--------------------------------------------------------
		// | Fields |
		// +--------+

		/**
		 * The value stored in the node.
		 */
		T val;
		int level;
		Node[] next;

		@SuppressWarnings("unchecked")
		public Node(T value, int level) 
		{
			this.val = value;
			this.level = level;
			this.next = new SkipList.Node[level];
		}// Node (T, int)
	} // class Node

	// +--------------+----------------------------------------------------
	// | Constructors |
	// +--------------+

	public SkipList() 
	{
		this.rand = new Random();

		this.header = new Node(null, maxLevel);
		//set all header next nodes to null
		for (int i = 0; i < this.maxLevel; i++) {
			this.header.next[i] = null;
		}//for
	}//SkipList()

	// +-------------------------+-----------------------------------------
	// | Internal Helper Methods |
	// +-------------------------+
	public int getRandomLevel() {
		int level = 1;
		//p^n probability of having level n node
		while (this.rand.nextDouble() < this.p)
			level++;
		//make sure it doesn't exceed max level
		return Math.min(level, this.maxLevel);
	}//getRandomLevel()

	// +-----------------------+-------------------------------------------
	// | Methods from Iterable |
	// +-----------------------+

	/**
	 * Return a read-only iterator (one that does not implement the remove
	 * method) that iterates the values of the list from smallest to largest.
	 */
	public Iterator<T> iterator() {
		// STUB
		return new Iterator<T>() {

			Node cursor = SkipList.this.header;

			public T next() {
				cursor = cursor.next[0];
				return cursor.val;
			}//next()

			public boolean hasNext() {
				return cursor.next[0] != null;
			}//hasNext()

			public void remove() {
				//call remove on the cursor val
				SkipList.this.remove(cursor.val);
			}//remove()
		};
	} // iterator()

	// +------------------------+------------------------------------------
	// | Methods from SimpleSet |
	// +------------------------+

	/**
	 * Add a value to the set.
	 *
	 * @post contains(val)
	 * @post For all lav != val, if contains(lav) held before the call to add,
	 *       contains(lav) continues to hold.
	 */
	public void add(T val) {
		//check if it already contains the val
		if (!this.contains(val)) {
			
			//make node array to store previous nodes on each level
			@SuppressWarnings("unchecked")
			Node[] path = new SkipList.Node[this.maxLevel];

			Node current = this.header;

			for (int level = maxLevel - 1; level >= 0; level--) {
				while (current.next[level] != null
						&& val.compareTo(current.next[level].val) > 0) {
					//advance while possible on each level
					current = current.next[level];
				}//while
				//store each node at level in path
				path[level] = current;
			}//for
			
			int newLevel = getRandomLevel();
			this.size++;
			Node newNode = new Node(val, newLevel);
			for (int i = 0; i < newLevel; i++) {
				//at each level, next from new is next from path
				newNode.next[i] = path[i].next[i];
				//next from path is the newNode
				path[i].next[i] = newNode;
			}//for
		}//if
	} // add(T val)

	/**
	 * Determine if the set contains a particular value.
	 */
	public boolean contains(T val) {
		
		Node current = this.header;

		for (int level = maxLevel - 1; level >= 0; level--) {
			while (current.next[level] != null
					&& val.compareTo(current.next[level].val) >= 0) {
				//move as far as possible at current node level
				current = current.next[level];
			}//while
			if (val.equals(current.val)) {
				return true;
			}//if
		}//for
		return false;
	} // contains(T)

	/**
	 * Remove an element from the set.
	 *
	 * @post !contains(val)
	 * @post For all lav != val, if contains(lav) held before the call to
	 *       remove, contains(lav) continues to hold.
	 */
	public void remove(T val) {
		
		//Make a node array to store path
		@SuppressWarnings("unchecked")
		Node[] path = new SkipList.Node[this.maxLevel];

		Node current = this.header;

		for (int level = maxLevel - 1; level >= 0; level--) {
			while (current.next[level] != null
					&& val.compareTo(current.next[level].val) > 0) {
				//iterate as far as possible at level
				current = current.next[level];
			}//while
			//store node at path. 
			path[level] = current;
		}//for
		current = current.next[0];
		this.size--;

		
		if (current != null && current.val.equals(val)) {
			for (int i = 0; i < current.level; i++) {
				//replace nexts on path with nexts of current
				path[i].next[i] = current.next[i];
				// current.next[i] = null;
			}//for
		}//if
	} // remove(T)

	// +--------------------------+----------------------------------------
	// | Methods from SemiIndexed |
	// +--------------------------+

	/**
	 * Get the element at index i.
	 * This method was only implemented so SkipListExpt could run. This is
	 * not an attempt at part 2.
	 *
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (index < 0 || index >= length)
	 */
	public T get(int i) {
		Node current = this.header.next[0];
		int index = 0;
		while (index < i) {
			current = current.next[0];
			index++;
		}//while
		return current.val;
	} // get(int)

	/**
	 * Determine the number of elements in the collection.
	 */
	public int length() {
		return this.size;
	} // length()

} // class SkipList<T>
