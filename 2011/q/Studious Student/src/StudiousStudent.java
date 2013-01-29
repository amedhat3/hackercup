import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author : Ahmad Medhat Othman
 * @facebook username : a.medhat.cs
 * @codeJame userName : AMedOs
 * @topCoder Handel : AMedOs
 * @email :a.medhat.cs@gmail.com
 * */

public class StudiousStudent {

	public static void main(String[] args) throws Exception {
		String in = "input.in";
		FileInputStream fin = new FileInputStream(in);
		Scanner scn = new Scanner(fin);
		
		String out = "output.out";
		FileOutputStream fout = new FileOutputStream (out);
		PrintStream ps = new PrintStream(fout);
				
		int N = scn.nextInt();
		for (int i = 0 ; i < N ; i++) {
			int c = scn.nextInt();
			//String hold[] = new String[c];
			List<String> holdd = new ArrayList <String>();
			for (int j =0 ; j < c ; j ++) {
				holdd.add(scn.next());
			}
			Collections.sort(holdd, new Facebook());
			StringBuilder res = new StringBuilder("");
			for (String str : holdd){
				res.append(str);
			}
			ps.println (res);
		}
		
		fout.close();
		fin.close();
		System.out.println("Done:.......");
		System.exit(0);
	}
}

class Facebook implements Comparator<String>{

	/**
	 * Compares its two arguments for order. 
	 * Returns a negative integer, zero, or a positive integer as the 
first argument is less than,    equal to, or greater than the second.
	 *             
	 */
	@Override
	public int compare(String str1, String str2) {
		for (int i =0,j=0 ; i < str1.length() && j < str2.length(); i++,j++ ) {
			if (str1.charAt(i) > str2.charAt(j)) return 1;
			if (str1.charAt(i) < str2.charAt(j)) return -1;
			if (str1.charAt(i) == str2.charAt(j)) continue; 
		}
		if (str1.length() < str2.length()){
			return cmp(str1 + str2, str2);
		} else if (str1.length() > str2.length()){
			return cmp(str1, str2 + str1);
		} else {
			return 0;
		}
	}
	
	int cmp(String str1, String str2) {
		for (int i =0,j=0 ; i < str1.length() && j < str2.length(); i++,j++ ) {
			if (str1.charAt(i) > str2.charAt(j)) return 1;
			if (str1.charAt(i) < str2.charAt(j)) return -1;
			if (str1.charAt(i) == str2.charAt(j)) continue; 
		}
		return 0;
	}
}
