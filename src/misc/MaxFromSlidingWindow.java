package misc;

import java.util.Deque;
import java.util.LinkedList;

/**
 * http://www.geeksforgeeks.org/maximum-of-all-subarrays-of-size-k/
 * 
 * @author bthakkar
 *
 */
public class MaxFromSlidingWindow {

	public static void printMaxFromSlidingWindowOfKFromGivenArray(int[] array, int k) {
		Deque<Integer> dequeue = new LinkedList<>();

		for (int index = 0; index < k; index++) {
			while (!dequeue.isEmpty()) {
				if (array[dequeue.peekLast()] < array[index]) {
					dequeue.removeLast();
				}
			}
			dequeue.addLast(index);
		}

		for (int index = k; index < array.length; index++) {
			while (!dequeue.isEmpty() && dequeue.peek() < index - k) {
				dequeue.remove();
			}
			while (!dequeue.isEmpty() && array[dequeue.peekLast()] < array[index]) {
				dequeue.removeLast();
			}
			dequeue.addLast(index);
		}
	}

	public static void main(String[] args) {

		int[] array = { 10, 40, 50, 10, 40, 50, 20, 30, 60 };

		printMaxFromSlidingWindowOfKFromGivenArray(array, 3);
	}

}
