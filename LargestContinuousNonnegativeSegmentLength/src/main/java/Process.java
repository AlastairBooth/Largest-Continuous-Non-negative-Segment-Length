
public class Process {
	
	/** 
	 * This method finds the size of the largest continuous segment in an integer array 
	 * where the sum of the values in the segment is greater or equal to 0.
	 *  
	 * Values in the array must be equal to -1, 0 or 1.
	 * 
	 * Performance of this method is of O(N)
	 * 
	 * @param A array of integers containing -1, 0 and 1.
	 * @return N - length of the largest segment. <br><b> or </b><br>
	 * 		   0 - if array does not contain any non-negative values (i.e. 1 or 0).
	 * @throws Exception If a value in the array is not equal to -1, 0 or 1.
	 * @throws NullPointerException If array is null.
	 * @throws IndexOutOfBoundsException If array is empty.
	 */
	public int solve(int[] A) throws Exception {
		
		//check that array does not contain value above 1 and less than -1
		for (int i : A) {
			if(i > 1 || i < -1) {
				throw new Exception(String.format(
						"Elements in the array must be equal to -1, 0 or 1. Position %s of array has a value of %s", i, A[i]));
			}
		}
		
		int leftIndex = 0, rightIndex = 0, maxLen = 0, current;
		
		int[] cumulativeSum = getCumilativeSumArray(A);
		int[] largestAchievedValue = getLargestAchievedValueArray(cumulativeSum);
		
		while (rightIndex < A.length) {
			current = leftIndex > 0 ? largestAchievedValue[rightIndex] - cumulativeSum[leftIndex - 1] : largestAchievedValue[rightIndex];
			if (current >= 0) {
				maxLen = Math.max((rightIndex - leftIndex), maxLen);
				rightIndex++;
			} else {
				leftIndex++;
			}
		}
		return maxLen;
	}
	
	/**
	 * Method to create an integer array which holds the cumulative sum of the input array
	 * 
	 * @param a - Input integer array
	 * @return Cumulative integer array
	 */
	private int[] getCumilativeSumArray(int[] a) {
		int[] cumulativeSum = new int[a.length];
		
		cumulativeSum[0] = a[0];
		for (int i = 1; i < a.length; i++) {
			cumulativeSum[i] = cumulativeSum[i - 1] + a[i];
		}
		
		return cumulativeSum;
	}
	
	/**
	 * Method to create an array that holds the largest value found at each position in an array starting from the back
	 * Each value is held in it's respective position
	 * 
	 * @param a - Input integer array
	 * @return Largest achieved value integer array
	 */
	private int[] getLargestAchievedValueArray(int[] a) {
		int[] largestAchievedValue = new int[a.length];

		largestAchievedValue[a.length - 1] = a[a.length - 1];
		for (int i = (a.length - 2); i >= 0; i--) {
			largestAchievedValue[i] = Math.max(largestAchievedValue[i + 1], a[i]);
		}
		
		return largestAchievedValue;
	}
}
