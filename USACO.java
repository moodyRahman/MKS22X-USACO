import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class USACO{


public static int silver(String fname){
	return 42069;
}


public static int bronze(String fname){
	ArrayList<String> temp = new ArrayList<String>();
	String[] rawfile = null;
	try {
		rawfile = USACO.reader(fname, temp);	//read into one big ole
	} catch(FileNotFoundException e) {		//String[] called rawfile
		System.out.println("NOT A VALID FILE >:(");
		System.exit(0);
	}

	String[] rawInput = rawfile[0].split(" ");	// the first elements is
	int[] formatted_inputs = new int[4];		// always the input
	for (int x = 0; x < 4; x++) {
		formatted_inputs[x] = Integer.parseInt(rawInput[x]); // parsethem
	}

	int row = formatted_inputs[0];
	int col = formatted_inputs[1];
	String[] data = new String[row];
	int x = 1;
	while(x < row + 1){
		data[x - 1] = rawfile[x];
		x++;
	}

	int[][] formatted_data = new int[row][col];
	for (int r = 0; r < row; r++) {
		for (int c = 0; c < col; c++) {
			formatted_data[r][c] = Integer.parseInt(data[r].split(" ")[c]);
		}
	}


	String[] commands = new String[rawfile.length - 1 - row];
	while(x < rawfile.length){
		commands[x - row - 1] = rawfile[x];
		x++;
	}

	int[][] formatted_commands = new int[commands.length][3];
	for (int r = 0; r < commands.length; r++) {
		for (int c = 0; c < 3; c++) {
			formatted_commands[r][c] = Integer.parseInt(commands[r].split(" ")[c]);
		}
	}


	// stomper(formatted_data, 1, 4, 4);
	for (int[] command : formatted_commands) {
		stomper(formatted_data, command[0], command[1], command[2]);
	}

	for (int r = 0; r < formatted_data.length; r++) {
		for (int c = 0; c < formatted_data[r].length; c++) {
			formatted_data[r][c] = formatted_inputs[2] - formatted_data[r][c];
		}
	}

	int cumsum_depth = 0;
	for (int[] r : formatted_data) {
		for (int c : r) {
			if (c < 0) {
			}
			else {
				cumsum_depth += c;
			}
		}
	}

	return cumsum_depth * 72 * 72;
}

private static void stomper(int[][] data, int r, int c, int down){
	int largest = 0;
	for (int curr_r = -1; curr_r < 2; curr_r++) {
		for (int curr_c = -1; curr_c < 2; curr_c++) {
			if(data[r + curr_r] [c + curr_c] > largest){
				largest = data[r + curr_r] [c + curr_c];
			}
		}
	}

	int new_elevation = largest - down;

	for (int curr_r = -1; curr_r < 2; curr_r++) {
		for (int curr_c = -1; curr_c < 2; curr_c++) {
			if(data[r + curr_r] [c + curr_c] > new_elevation){
				data[r + curr_r] [c + curr_c] = new_elevation;
			}
		}
	}
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


// algorithmically determine the possible distances from a point
private static void silverHelp(int[][] rawmap,int[][] distmap,int start_row_1,int start_col_1,int start_row_2,int start_col_2,int steps_remaining){

while (steps_remaining > 0){
	for(int i = 0; i < rawmap.length; i++){
 		for(int j = 0; j < rawmap[0].length; j++){

   			if(rawmap[i][j] != -1){
     				if(i - 1 >= 0 && rawmap[i-1][j] != -1){
       					steps_remaining += rawmap[i-1][j];
     				}

   				if(i + 1 < rawmap.length && rawmap[i+1][j] != -1){
     					steps_remaining += rawmap[i+1][j];
   				}

   				if(j - 1 >= 0 && rawmap[i][j-1] != -1){
     					steps_remaining += rawmap[i][j-1];
   				}

   				if(j + 1 < rawmap[0].length && rawmap[i][j+1] != -1){
     					steps_remaining += rawmap[i][j+1];
   				}

   				distmap[i][j] = steps_remaining;
 			}
		}
	}
}

}


public static void main(String[] args) {
	int b = USACO.bronze("testcases/makelake.3.in");
	System.out.println(b);
}


}
