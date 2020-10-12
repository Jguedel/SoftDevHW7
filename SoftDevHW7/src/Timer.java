public class Timer {
	public static long timeStart;
	public static long timeEnd;
	
	public static void StartTimer() {
		  timeStart = System.nanoTime();
	}
	public static long EndTimer() {
		timeEnd = System.nanoTime();
        // calculate the total time and print the result
        long totalTime = timeEnd - timeStart;
        return totalTime;
		
	}

}
