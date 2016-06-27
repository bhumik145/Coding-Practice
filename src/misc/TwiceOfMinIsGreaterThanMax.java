package misc;

/**
 * http://www.geeksforgeeks.org/remove-minimum-elements-either-side-2min-max/
 * 
 * @author copied from http://ideone.com/MCGtuO
 *
 */
public class TwiceOfMinIsGreaterThanMax {

	public static void main(String[] args) throws java.lang.Exception {
		// int[] input = { 4, 5, 100, 9, 10, 11, 12, 15, 200 };
		// int[] input = {4, 7, 5, 6};
		// int[] input = {20, 7, 5, 6};
		// int[] input = {20, 4, 1, 3,6};
		int[] input = { 10, 5, 3, 4, 100, 101, 102, 103, 104 };
		TwiceOfMinIsGreaterThanMax s = new TwiceOfMinIsGreaterThanMax();
		s.findSubArray(input);
	}

	public void findSubArray(int[] input) {
		if (input == null || !(input.length > 0))
			return;
		/* intializing minTillNow, maxTillNow with values in 0th index */
		/*
		 * also we assume that the sub-array beginIndex and endIndex is zero
		 * initially as each element itself satisfy the given property
		 */
		int minTillNow = input[0], maxTillNow = input[0], beginIndexDummy = 0, endIndexDummy = 0;
		int beginIndex = 0, endIndex = 0, sequenceLength = Integer.MIN_VALUE;
		for (int i = 1; i < input.length; i++) {

			if (minTillNow > input[i]) {
				/*
				 * if current element is lesser than minTillNow then assign
				 * minTillNow to current element.
				 */

				minTillNow = input[i];

				/*
				 * let's check whether maxTillNow still satisfies the property
				 */

				if (maxTillNow < minTillNow * 2) {

					/*
					 * if property is satisfied then increase the dummy endIndex
					 * of sub-array
					 */

					endIndexDummy = i;
				} else {
					/*
					 * if property is not satisfied then sub-array sequence is
					 * broken there. So we'll check whether sequence found is of
					 * greater than already found sequence. If so then we'll
					 * update beingIndex and endIndex of sub-array accordingly.
					 */

					if (endIndexDummy - beginIndexDummy + 1 >= sequenceLength) {
						beginIndex = beginIndexDummy;
						endIndex = endIndexDummy;
						sequenceLength = endIndexDummy - beginIndexDummy + 1;
					}

					// start the same problem from current index.

					minTillNow = input[i];
					maxTillNow = input[i];
					beginIndexDummy = i;
					endIndexDummy = i;
				}
			}

			else if (input[i] < minTillNow * 2) {
				/*
				 * else if current element is lesser than miTillNow*2 then it is
				 * part of our sub-array sequence. So update dummy endIndex.
				 */

				endIndexDummy = i;

				// if current element is greater than maxTillNow then update it
				// accordingly.
				if (input[i] > maxTillNow) {
					maxTillNow = input[i];
				}
			}

			/*
			 * if current element doesn't satisfy any of above properties then
			 * automatically it is not part of our sub-array sequence. here
			 * again we'll check whether sequence found is of greater than
			 * already found sequence. If so then we'll update beingIndex and
			 * endIndex of sub-array accordingly.
			 */
			else {

				if (endIndexDummy - beginIndexDummy + 1 >= sequenceLength) {
					beginIndex = beginIndexDummy;
					endIndex = endIndexDummy;
					sequenceLength = endIndexDummy - beginIndexDummy + 1;
				}
				// start the same problem from current index
				minTillNow = input[i];
				maxTillNow = input[i];
				beginIndexDummy = i;
				endIndexDummy = i;
			}
		}

		/*
		 * below check will take care of corner scenarios. For example, if whole
		 * array satisfies the property then below code will take care of
		 * updating beginIndex and endIndex accordingly.
		 */

		if (endIndexDummy - beginIndexDummy + 1 >= sequenceLength) {
			beginIndex = beginIndexDummy;
			endIndex = endIndexDummy;
		}
		System.out.println("Being index:" + beginIndex);
		System.out.println("End index:" + endIndex);
		for (int j = beginIndex; j <= endIndex; j++) {
			System.out.print(input[j] + " ");
		}
		System.out.println();
	}
}
