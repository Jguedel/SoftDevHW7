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
		LOC = Function.countingFile(File,LOC);
		// CHECK FILE FOR KEYWORDS
		h = Function.check(File,h);
		// END TIMER
		time = Timer.EndTimer();
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
