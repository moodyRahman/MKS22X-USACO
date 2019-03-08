import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class USACO{

public static int bronze(String fname){
	ArrayList<String> temp = new ArrayList<String>();
	String[] rawfile = null;
	try {
		rawfile = USACO.reader(fname, temp);
	} catch(FileNotFoundException e) {
		System.out.println("NOT A VALID FILE >:(");
		System.exit(0);
	}

	String[] rawinp = rawfile[0].split(" ");
	String[] rawdata = new String[rawfile.length - 1];
	for (int x = 0; x < rawdata.length; x++) {
		rawdata[x] = rawfile[x+1];
	}

	for (String s : rawfile) {
		System.out.println(s);
	}
	System.out.println();
	for (String s : rawdata) {
		System.out.println(s);
	}

	System.out.println();
	for (String s : rawinp) {
		System.out.println(s);
	}





	return 0;
}

private static String[] reader(String fname, ArrayList<String> boop) throws FileNotFoundException{
	File fl = new File(fname);
	Scanner scn = new Scanner(fl);
	while (scn.hasNextLine()) {
		String a = scn.nextLine();
		boop.add(a);
	}
	String[] b = new String[boop.size()];
	// String[][] br =
	boop.toArray(b);
	return b;
}


public static void main(String[] args) {
	USACO.bronze("testcases/makelake.1.in");
}


}
