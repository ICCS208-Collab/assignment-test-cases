/** Performs some basic linked list tests. */
public class ArrayDequeTest {

	/* Utility method for printing out empty checks. */
	public static boolean checkEmpty(boolean expected, boolean actual) {
		if (expected != actual) {
			System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Utility method for printing out empty checks. */
	public static boolean checkSize(int expected, int actual) {
		if (expected != actual) {
			System.out.println("size() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Prints a nice message based on whether a test passed.
	 * The \n means newline. */
	public static void printTestStatus(boolean passed) {
		if (passed) {
			System.out.println("Test passed!\n");
		} else {
			System.out.println("Test failed!\n");
		}
	}

	/** Adds a few things to the list, checking isEmpty() and size() are correct,
	 * finally printing the results.
	 *
	 * && is the "and" operation. */
	public static void addIsEmptySizeTest() {
		System.out.println("Running add/isEmpty/Size test.");
//		System.out.println("Make sure to uncomment the lines below (and delete this print statement).");
		ArrayDeque<String> lld1 = new ArrayDeque<>();
		boolean passed = checkEmpty(true, lld1.isEmpty());
		lld1.addFirst("front");

		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
		passed = checkSize(1, lld1.size()) && passed;
		passed = checkEmpty(false, lld1.isEmpty()) && passed;
		lld1.addLast("middle");
		passed = checkSize(2, lld1.size()) && passed;
		lld1.addLast("back");
		passed = checkSize(3, lld1.size()) && passed;
		System.out.println("Printing out deque: ");
		lld1.printDeque();
		printTestStatus(passed);
	}

	/** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
	public static void addRemoveTest() {

		System.out.println("Running add/remove first test");

//		System.out.println("Make sure to uncomment the lines below (and delete this print statement).");
		ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
		// should be empty
		boolean passed = checkEmpty(true, lld1.isEmpty());
		lld1.addFirst(10);
		lld1.addFirst(10);
		// should not be empty
		passed = checkEmpty(false, lld1.isEmpty()) && passed;
		lld1.removeFirst();
		lld1.removeFirst();
		// should be empty
		passed = checkEmpty(true, lld1.isEmpty()) && passed;
		printTestStatus(passed);

		System.out.println("Running add/remove last test");
		// should be empty
		lld1.addLast(10);
		lld1.addLast(10);
		// should not be empty
		passed = checkEmpty(false, lld1.isEmpty()) && passed;
		lld1.removeLast();
		lld1.removeLast();
		// should be empty
		passed = checkEmpty(true, lld1.isEmpty()) && passed;
		printTestStatus(passed);

		System.out.println("Running add/remove first/last test");
		// should be empty
		lld1.addFirst(10);
//		lld1.addLast(10);
		// should not be empty
		passed = checkEmpty(false, lld1.isEmpty()) && passed;
		lld1.removeLast();
		lld1.removeFirst();
		// should be empty
		passed = checkEmpty(true, lld1.isEmpty()) && passed;
//		printTestStatus(passed);

		// should be empty
		lld1.addLast(10);
		lld1.addFirst(10);
		// should not be empty
		passed = checkEmpty(false, lld1.isEmpty()) && passed;
		lld1.removeFirst();
		lld1.removeLast();
		// should be empty
		passed = checkEmpty(true, lld1.isEmpty()) && passed;


		printTestStatus(passed);
	}

	public static void addRemoveLargeIsEmpty(int numberOfItems) {
		System.out.println("Running add/isEmpty/Size test of large array test.");
//		System.out.println("Make sure to uncomment the lines below (and delete this print statement).");
		ArrayDeque<Integer> lld1 = new ArrayDeque<>();
		boolean passed = checkEmpty(true, lld1.isEmpty());

		/* Test addFirst and addLast alternating then removeLast */
		boolean flip = true;
		for(int i = 0; i < numberOfItems; i++) {
			if(flip)
				lld1.addFirst(i);
			else
				lld1.addLast(i);
			flip = !flip;
			System.out.println("Capacity: " + lld1.cap());

			lld1.printDeque();
		}

		flip = !flip;
		lld1.printDeque();
		int x;
		for(int i = 0; i < numberOfItems; i++) {
			x = lld1.removeLast();
			System.out.println(x);
			lld1.printDeque();
			System.out.println("Capacity: " + lld1.cap());
		}
		lld1.printDeque();
		passed = lld1.isEmpty() && passed;

		/* Test addFirst and addLast alternating then removeFirst */
		flip = true;
		for(int i = 0; i < numberOfItems; i++) {
			if(flip)
				lld1.addFirst(i);
			else
				lld1.addLast(i);
			flip = !flip;
			System.out.println("Capacity: " + lld1.cap());

			lld1.printDeque();

		}
		flip = !flip;
		lld1.printDeque();
		for(int i = 0; i < numberOfItems; i++) {
			x = lld1.removeFirst();
			System.out.println(x);
			lld1.printDeque();
			System.out.println("Capacity: " + lld1.cap());
		}
		lld1.printDeque();
		passed = lld1.isEmpty() && passed;


		/* Test addFirst and addLast alternating then alternating remove */
		flip = true;
		for(int i = 0; i < numberOfItems; i++) {
			if(flip)
				lld1.addFirst(i);
			else
				lld1.addLast(i);
			flip = !flip;
			System.out.println("Capacity: " + lld1.cap());

			lld1.printDeque();

		}
		flip = !flip;
		lld1.printDeque();
		for(int i = 0; i < numberOfItems; i++) {

			if(flip) {
				x = lld1.removeFirst();
				System.out.println(x);
			} else {
				x = lld1.removeLast();
				System.out.println(x);
			}
			flip = !flip;
			lld1.printDeque();
			System.out.println("Capacity: " + lld1.cap());
		}
		lld1.printDeque();
		passed = lld1.isEmpty() && passed;

        lld1.printDeque();
		printTestStatus(passed);
}

	public static void addGetRemoveTest() {
		System.out.println("Running add/get/remove test.");
		ArrayDeque<Integer> lld1 = new ArrayDeque<>();
		boolean passed = checkEmpty(true, lld1.isEmpty());
		lld1.addFirst(32);
		lld1.addFirst(1);
		lld1.addLast(45);
		lld1.addLast(12);



		passed = lld1.get(0) == 1 && passed;
		passed = lld1.get(1) == 32 && passed;
		passed = lld1.get(2) == 45 && passed;
		passed = lld1.get(3) == 12 && passed;
		System.out.println("Printing out deque: ");
		lld1.printDeque();
		printTestStatus(passed);
	}

	public static void deepCopyTest() {
		System.out.println("Running deep copy test.");
		ArrayDeque<Integer> lld1 = new ArrayDeque<>();
		boolean passed = checkEmpty(true, lld1.isEmpty());
		lld1.addFirst(32);
		lld1.addFirst(1);
		lld1.addLast(45);
		lld1.addLast(12);

		ArrayDeque<Integer> lld2 = new ArrayDeque<>(lld1);
		System.out.println(lld2.get(0));
		System.out.println(lld2.get(1));
		System.out.println(lld2.get(2));
		System.out.println(lld2.get(3));


		passed = lld1.get(0) == lld2.get(0) && passed;
		passed = lld1.get(1) == lld2.get(1) && passed;
		passed = lld1.get(2) == lld2.get(2) && passed;
		passed = lld1.get(3) == lld2.get(3) && passed;
		System.out.println("Printing out deque: ");
		lld1.printDeque();
		System.out.println("Printing out deep copy deque: ");
		lld2.printDeque();
		lld2.printDeque();
		printTestStatus(passed);
	}

	public static void main(String[] args) {
		System.out.println("Running tests.\n");
		addIsEmptySizeTest();
		addRemoveTest();
		addRemoveLargeIsEmpty(100);
		addGetRemoveTest();
		deepCopyTest();
	}
} 
