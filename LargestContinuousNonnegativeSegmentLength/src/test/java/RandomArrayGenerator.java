import java.util.concurrent.ThreadLocalRandom;

public class RandomArrayGenerator {

	private static int MIN = -1, MAX = 1;
	
	/**
	 * This method generates an array of integers with a fixed size
	 * The integers within the array are equal to -1, 0 or 1 and are generated randomly
	 * 
	 * @param size
	 * @return
	 */
	public static int[] generateRandomArray(int size) {
		int[] a = new int[size];
		
		for(int i = 0; i < size; i++) {
			a[i] = ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
		}
		
		return a;
	}
	
}
