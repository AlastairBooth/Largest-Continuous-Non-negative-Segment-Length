
public class AlternativeProcess {

	/**
	 * Alternative, less complex, method to find the size of the largest continuous segment in an integer array
	 * where the sum of the values in the segment is greater or equal to 0.
	 * 
	 * Performance of this method is of O(N^3) 
	 * hence takes a lot longer for larger arrays.
	 * 
	 * @param A
	 * @return
	 */
	public int solve(int[] A) {
		int largestSegmentSize = 0;
		
		for(int i = 0; i < A.length; i ++) {
			for(int j = i; j < A.length; j++) {
				
				int currentSegmentCount = 0;
				
				for(int k = i; k <= j; k++) {
					currentSegmentCount += A[k];
				}
				
				int currentSegmentSize = j - i;
				
				if(currentSegmentCount >= 0 
						&& currentSegmentSize > largestSegmentSize) {
					largestSegmentSize = currentSegmentSize;
				}
			}
		}
		return largestSegmentSize;
	}
	
}
