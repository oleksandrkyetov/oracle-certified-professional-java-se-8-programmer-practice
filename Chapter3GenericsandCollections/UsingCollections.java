import java.util.*;

public class UsingCollections {

	public static void main(final String... args) {
		final List<String> strings = Arrays.asList("1", "2", "3");

		// Printing with Iterator
		final Iterator<String> stringsIterator = strings.iterator();
		while(stringsIterator.hasNext()) {
			System.out.println(stringsIterator.next());
		}

		// NavigableSet example
		final NavigableSet<String> navigableSet = new TreeSet<>(Arrays.asList("5", "4", "3", "2", "1"));
		// lower() and higher() does not include itself
		System.out.println(navigableSet.lower("3"));
		System.out.println(navigableSet.higher("5"));
		// floor() and ceiling() include itself
		System.out.println(navigableSet.floor("3"));
		System.out.println(navigableSet.ceiling("5"));

		// FIFO queue with methods which throw exceptions
		final Queue<String> fifoThrowsExceptionQueue = new ArrayDeque<>(Arrays.asList("1", "2", "3", "4", "5"));
		// Add element to the back of the queue and return true or throw and exception if not successful
		System.out.println(fifoThrowsExceptionQueue.add("6"));
		System.out.println(fifoThrowsExceptionQueue);
		// Returns next element (not remove it) from the queue or throw an exception if queue is empty
		System.out.println(fifoThrowsExceptionQueue.element());
		System.out.println(fifoThrowsExceptionQueue);
		// Returns next element (and remove it) from the queue or throw an exception if queue is empty
		System.out.println(fifoThrowsExceptionQueue.remove());
		System.out.println(fifoThrowsExceptionQueue);

		// FIFO queue with methods which return null
		final Queue<String> fifoReturnNullQueue = new ArrayDeque<>(Arrays.asList("10"));
		// Add element to the back of the queue and return true or false depends of how successful operation was
		System.out.println(fifoReturnNullQueue.offer("60"));
		System.out.println(fifoReturnNullQueue);
		// Returns next element (not remove it) from the queue or null if queue is empty
		System.out.println(fifoReturnNullQueue.peek());
		System.out.println(fifoReturnNullQueue);
		// Returns next element (and remove it) from the queue or null if queue is empty
		System.out.println(fifoReturnNullQueue.poll());
		System.out.println(fifoReturnNullQueue);

		// LIFO queue with methods which return null
		final Deque<String> lifoReturnNullDeque = new ArrayDeque<>(Arrays.asList("10"));
		// Add element to the front of the queue and return true or false depends of how successful operation was
		lifoReturnNullDeque.push("60");
		System.out.println(lifoReturnNullDeque);
		// Returns next element (not remove it) from the queue or null if queue is empty
		System.out.println(lifoReturnNullDeque.peek());
		System.out.println(lifoReturnNullDeque);
		// Returns next element (and remove it) from the queue or null if queue is empty
		System.out.println(lifoReturnNullDeque.poll());
		System.out.println(lifoReturnNullDeque);

		// The only strange method which works only for LIFO queue, work the same way as remove for FIFO queue
		//#pop(); 
	}

}
