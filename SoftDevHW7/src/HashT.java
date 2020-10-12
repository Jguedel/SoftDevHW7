/*
 * @author jguedel
 * @version 1.0
 * 
 */
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Hashtable;

// TODO: Auto-generated Javadoc
/**
 * The Class HashT.
 */
public class HashT {
	
	/** The Keywords. */
	private static String[] Keywords;
	
	/** The File. */
	private static String[] File;
	
	/** The h. */
	private static Hashtable<String, Integer> h = new Hashtable<String, Integer>();
	
	/** The time. */
	private static long time;
	
	/** The loc. */
	private static int LOC = 0;
	
	/** The input. */
	private static String input;

	/**
	 * Hash.
	 *
	 * @param inp the input file
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void Hash(File inp) throws IOException {
		// START TIMER
		Timer.StartTimer();
		// PUT KEYWORDS INTO HASTABLE
		String Key = new String(Files.readAllBytes(Paths.get("C:\\Users\\jgued\\Desktop\\Keywords.txt")));
		Keywords = Key.split("\\s+");
		for (int i = 0; i <= Keywords.length - 1; i++) {
			h.put(Keywords[i], 0);
		}
		input = new String(Files.readAllBytes(Paths.get(inp.toString())));
		// ELIMINATE BLANK SPACE
		input = input.replaceAll("\\s+", " ");
		File = input.split(" ");
		LOC = Function.countingFile(File, LOC);
		// CHECK FILE FOR KEYWORDS
		h = Function.check(File, h);
		// END TIMER
		time = Timer.EndTimer();
	}

	/**
	 * Gets the description.
	 *
	 * @return the description of the program
	 */
	public static String getDescription() {
		String description = "This program takes a code file and finds how many times keywords appear in the file."
				+ " Then outputs the number of lines, the time it took in milliseconds, and then the number of times each keyword appears";
		return description;
	}

	/**
	 * Gets the h.
	 *
	 * @return the hashtable
	 */
	public static Hashtable<String, Integer> getH() {
		return h;
	}

	/**
	 * Gets the time.
	 *
	 * @return the elapsed time
	 */
	public static long getTime() {
		return time;
	}

	/**
	 * Gets the loc.
	 *
	 * @return the total lines of code
	 */
	public static int getLOC() {
		return LOC;
	}
}
