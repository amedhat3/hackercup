import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;


/**
 * @author: Ahmad Medhat Othman
 * @codeJame: AMedOs
 * @topCoder: AMedOs
 * @facebook: ahmadmedhat.othman
 * @email :a.medhat.cs@gmail.com
 * */
public class Soup {

	static int N;
	public static void main(String[] args) throws Exception  {
		// Input file
		String in = "soup.in";
		FileInputStream fin = new FileInputStream(in);
		Scanner scn = new Scanner(fin);
		
		// Output file
		String out = "soup.out";
		FileOutputStream fout = new FileOutputStream (out);
		PrintStream ps = new PrintStream(fout);
		
		String des = "HACKERCUP";
		N = scn.nextInt();scn.nextLine();
		int t,i,j;
		
		for (t=0 ; t< N ; t++) {
			String str = scn.nextLine();
			StringBuilder strB = new StringBuilder(str);
			int count =0;
			while(true){
				for (i =0 ; i< des.length(); i++){
					for (j=0; j < str.length(); j++){
						if (strB.charAt(j) == des.charAt(i)){
							strB.setCharAt(j, ' ');
							break;
						}
					}
					if (j >= str.length()) {
						//the string not found. 
						break;
					}
				}
				if (i >= des.length()) {
					count++;
				} else {
					break;
				}
			}
			ps.println("Case #" + (t+1) + ": " + count);
		}
		
		fout.close();
		fin.close();
		System.out.println("Done:.......");
		System.exit(0);
	}
}
