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
public class Billboards {

	static int N;
	public static void main(String[] args) throws Exception  {
		// Input file
		String in = "billboards.in";
		FileInputStream fin = new FileInputStream(in);
		Scanner scn = new Scanner(fin);
		
		// Output file
		String out = "billboards.out";
		FileOutputStream fout = new FileOutputStream (out);
		PrintStream ps = new PrintStream(fout);
		
		String des = "HACKERCUP";
		N = scn.nextInt();scn.nextLine();
		int t,i,j;
		int count =0;
		for (t=0 ; t< N ; t++) {
			
			ps.println("Case #" + (t+1) + ": " + count);
		}
		
		fout.close();
		fin.close();
		System.out.println("Done:.......");
		System.exit(0);
	}
}
