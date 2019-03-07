import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class USACO{

public static int bronze(String fname){
	ArrayList<String> temp = new ArrayList<String>();
	try {
		USACO.reader(fname, temp);
	} catch(FileNotFoundException e) {
		System.out.println("NOT A VALID FILE >:(");
		System.exit(0);
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


}
