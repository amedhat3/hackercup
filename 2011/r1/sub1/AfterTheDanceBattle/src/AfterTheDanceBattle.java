import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;


/**
 * @author : Ahmad Medhat Othman
 * @facebook username : a.medhat.cs
 * @codeJame userName : AMedOs
 * @topCoder Handel : AMedOs
 * @email :a.medhat.cs@gmail.com
 * */

public class AfterTheDanceBattle {

	private static String str[];
	private static int best[][];
	

	private static int N,R,C;
	
	public static void main(String[] args) throws Exception  {
		// Input file
		String in = "input.in";
		FileInputStream fin = new FileInputStream(in);
		Scanner scn = new Scanner(fin);
		
		// Output file
		String out = "output.out";
		FileOutputStream fout = new FileOutputStream (out);
		PrintStream ps = new PrintStream(fout);
		
		 
		N = scn.nextInt();
		//N=1;
		for ( int i =0 ;i < N ; i ++) {
			R = scn.nextInt();
			C = scn.nextInt();
			str = new String[R];
			for ( int j = 0 ; j < R ; j ++) {
				str[j] = scn.next(); 
				ps.println(str[j]);
			}
			best = new int[R][C];
			for ( int j = 0 ; j < R ; j ++) {
				Arrays.fill(best[j], -1);
			}
			int start = str[0].indexOf('S');
			//int end = str[R-1].indexOf('E');
			
			ps.println(solve(0, start, -1, -1));
			
			/*for (int j = 0; j < best.length; j++) {
				for (int j2 = 0; j2 < best[j].length; j2++) {
					ps.print(best[j][j2] + " ");
				}
				ps.println();
			}*/
		}
		
		fout.close();
		fin.close();
		System.out.println("Done:.......");
		System.exit(0);
	}
	
	private static  int solve(int x, int y, int oldx, int oldy) {
		
		if (x >= R || y >= C || x < 0 || y < 0) {
			return Integer.MAX_VALUE;
		}
		
		if (best[x][y] != -1) {
			return best[x][y];
		}
		
		System.out.println(x +" ** "+y);
		if (str[x].charAt(y) == 'W') {
			best[x][y] = Integer.MAX_VALUE; 
		} else if (str[x].charAt(y) == 'E') {
			best[x][y] = 1;
		} else {
			if (oldx == -1 || oldy == -1) {
				best[x][y] = 1 + Math.min(solve(x, y-1,x,y), Math.min(solve(x, y+1, x, y), solve(x+1, y, x, y)));
			} else {
				int min = Integer.MAX_VALUE;
				if (y-1 != oldy) {
					min = solve(x, y-1,x,y);
				}
				if (y+1 != oldy) {
					min = Math.min(min, solve(x, y+1, x, y));
				}
				if (x+1 != oldx) {
					min = Math.min(min, solve(x+1, y, x, y));
				}
				best[x][y] = 1 + min;
			}
		}
		return best[x][y];
	}
}
