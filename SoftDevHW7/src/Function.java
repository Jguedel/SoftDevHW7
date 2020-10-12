/*
 * @author jguedel
 * @version 1.0
 * 
 */
import java.util.Hashtable;

// TODO: Auto-generated Javadoc
/**
 * The Class Function.
 */
public class Function {
	
	/**
	 * Check.
	 *
	 * @param File the input file
	 * @param h    the hashtable
	 * @return the hashtable
	 */
	public static Hashtable<String, Integer> check(String[] File, Hashtable<String, Integer> h) {
		// SPLIT FILE TO GET INDIVIDUAL WORDS
		// String[] words = input.split(" ");
		for (int z = 0; z < File.length; z++) {
			String word = File[z];
			// CHECK IF WORD FROM INPUT FILE MATCHES A KEY WORD
			if (h.get(word) != null) {
				// INCREASE INDEX
				int index = h.get(word) + 1;
				h.put(File[z], index);

			}
		}

		// RETURN HASHTABLE
		return h;
	}

	/**
	 * Counting file.
	 *
	 * @param File the input file
	 * @param LOC  the total lines of code
	 * @return the LOC
	 */
	// COUNTING FROM FILE
	public static int countingFile(String[] File, int LOC) {
		for (int i = 0; i <= File.length - 1; i++) {
			LOC++;
			if (File[i].startsWith("//") || File[i].startsWith("/*")) {
				LOC--;
				if (File[i].contains("/*")) {
					while (!File[i].contains("*/")) {
						i++;
					}
				}
			}
		}
		return LOC;
	}

}
