import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class ProcessTests {

	@Test
	public void methodReturnsExpectedValue() throws Exception {
		
		int expectedValue = 11;
		int[] a = {-1, 0, 0, 1, -1, 0, 1, 1, -1, 1, -1, -1, 0};
		
		Process process = new Process();
		int largestSegmentSize = process.solve(a);
		
		assertEquals(true, largestSegmentSize == expectedValue);
	}
	
	@Test
	public void methodReturnsCorrectValue() throws Exception {
		
		int[] a = {-1, 0, 0, 1, -1, 0, 1, 1, -1, 1, -1, -1, 0};
		
		Process process = new Process();
		AlternativeProcess alternativeProcess = new AlternativeProcess();
		
		int largestSegmentSize = process.solve(a);
		int largestSegmentSizeFromAlternateProcess = alternativeProcess.solve(a);
		
		assertEquals(true, largestSegmentSize == largestSegmentSizeFromAlternateProcess);
	}
	
	@Test
	public void methodReturnsCorrectValueWithMultipleRandomInputArrays() throws Exception {
		
		int attempts = 100;
		int arraySize = 100;
		boolean allTestsPassed = true;
		
		Process process = new Process();
		AlternativeProcess alternativeProcess = new AlternativeProcess();
		
		for(int i = 0; i < attempts; i++) {
			int[] a = RandomArrayGenerator.generateRandomArray(arraySize);
			int largestSegmentSize = process.solve(a);
			int largestSegmentSizeFromAlternateProcess = alternativeProcess.solve(a);
			allTestsPassed = allTestsPassed && (largestSegmentSize == largestSegmentSizeFromAlternateProcess);
		}
		
		assertEquals(true, allTestsPassed);
	}
	
	@Test
	public void methodThrowsExceptionWithNullArray() {
		
		int[] a = null;
		
		try {
			Process process = new Process();
			process.solve(a);
			
			//test should not reach this point
			Assert.fail("Process ran even though array was null");
		} catch (Exception e) {
			//do nothing here as this is the expected outcome
		}
	}
	
	@Test
	public void methodThrowsExceptionWithEmptyArray() {
		
		int[] a = {};
		
		try {
			Process process = new Process();
			process.solve(a);
			
			//test should not reach this point
			Assert.fail("Process ran even though array was empty");
		} catch (Exception e) {
			//do nothing here as this is the expected outcome
		}
	}
	
	@Test
	public void methodReturnsZeroWhenSegmentDoesNotSatisfyNonnegativeCondition() throws Exception {
		
		int[] a = {-1, -1, -1, -1, -1, -1, -1, -1};
		
		Process process = new Process();
		int largestSegmentSize = process.solve(a);
		
		assertEquals(true, largestSegmentSize == 0);
	}
	
	@Test
	public void methodThrowsExceptionWhenElementInArrayIsAboveRange() throws Exception {
		
		int[] a = {-1, 0, 0, 2, -1, 0, 1, 1, -1, 1, -1, -1, 0};
		
		try {
			Process process = new Process();
			process.solve(a);
			
			//test should not reach this point
			Assert.fail("Process ran even though array contained a value above expected range");
		} catch (Exception e) {
			//do nothing here as this is the expected outcome
		}
	}
	
	@Test
	public void methodThrowsExceptionWhenElementInArrayIsBelowRange() throws Exception {
		
		int[] a = {-1, 0, 0, 1, -2, 0, 1, 1, -1, 1, -1, -1, 0};
		
		try {
			Process process = new Process();
			process.solve(a);
			
			//test should not reach this point
			Assert.fail("Process ran even though array contained a value above expected range");
		} catch (Exception e) {
			//do nothing here as this is the expected outcome
		}
	}
}
