import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Hashtable;
import java.util.Scanner;

public class HashT {
	private static String[] Keywords;
	private static String[] File;
	private static Hashtable<String, Integer> h = new Hashtable<String, Integer>();
	private static long time;
	private static int LOC = 0;
	private static String input;

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
		countingFile();
		// CHECK FILE FOR KEYWORDS
		check();
		// END TIMER
		time = Timer.EndTimer();
	}

	public static Hashtable<String, Integer> check() {
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

	// COUNTING FROM FILE
	public static void countingFile() {
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
	}

	public static Hashtable<String, Integer> getH() {
		return h;
	}

	public static long getTime() {
		return time;
	}

	public static int getLOC() {
		return LOC;
	}
}
