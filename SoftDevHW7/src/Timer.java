// TODO: Auto-generated Javadoc
/**
 * The Class Timer.
 */
public class Timer {

	/** The time start. */
	public static long timeStart;

	/** The time end. */
	public static long timeEnd;

	/**
	 * Start timer.
	 */
	public static void StartTimer() {
		timeStart = System.currentTimeMillis();
	}

	/**
	 * End timer.
	 *
	 * @return the total elapsed time
	 */
	public static long EndTimer() {
		timeEnd = System.currentTimeMillis();
		// calculate the total time and print the result
		long totalTime = timeEnd - timeStart;
		return totalTime;

	}

}
