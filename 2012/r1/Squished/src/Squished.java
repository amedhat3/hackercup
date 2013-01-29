import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * @author: Ahmad Medhat Othman
 * @codeJame: AMedOs
 * @topCoder: AMedOs
 * @facebook: ahmadmedhat.othman
 * @email :a.medhat.cs@gmail.com
 * */
public class Squished {

	static int N;
	public static void main(String[] args) throws Exception  {
		// Input file
		String in = "squished.in";
		FileInputStream fin = new FileInputStream(in);
		Scanner scn = new Scanner(fin);
		
		// Output file
		String out = "squished.out";
		FileOutputStream fout = new FileOutputStream (out);
		PrintStream ps = new PrintStream(fout);
		N = scn.nextInt();
		int t;
		int M=0,count=0;
		//System.out.println(permute("ABCDE"));
		permuteList("ABCD", new ArrayList<String>());
		for (t=0 ; t< 0 ; t++) {
			M = scn.nextInt();
			String str = scn.next();
			int res = solve(str, M)-1;
			System.out.println("Res: " + res);
			ps.println("Case #" + (t+1) + ": " + res);
		}
		
		fout.close();
		fin.close();
		System.out.println("Done:.......");
		System.exit(0);
	}
	
	static boolean isValid(int M, String str){
		if (Integer.parseInt(str) > M){
			return false;
		} else {
			return true;
		}
	}
	
//	static int permute(String str) {
//		if (str.length()<=1) return 1;
//		
//		System.out.println(str + "  ");
//		int res=0;
//		for (int i=1; i <= str.length()-1 ; i++){
//			res+=permute(str.substring(i));
//		}
//		System.out.println("\n");
//		return res+1;
//	}
	
	static void permuteList(String str,List<String> oldList) {
		List<String> res = new ArrayList<String>();
		res.addAll(oldList);
		res.add(str);
		printList(res);
		if (str.length()<=1){
			oldList.clear();
			return;
		}
		for (int i=1; i < str.length() ; i++){
			oldList.add(str.substring(0,i));
			permuteList(str.substring(i), oldList);
		}
		return;
	}
	
	static void printList(List<String> strList){
		System.out.println(strList.size());
		for(int i=0; i<strList.size();i++){
			System.out.print(strList.get(i) + " - ");
		}
		System.out.println();
	}
	
	static int solve(String str, int M) {
		int count=0;
		String mStr = Integer.toString(M);
		if (isValid(M, str)) {
			count++;
		}
		System.out.println("mStr : " + mStr);
		System.out.println("str : " + str);
		for (int i=1;i <= Math.min(mStr.length(), str.length()-1) ;i++) {
			System.out.println(i);
			if (isValid(M, str.substring(0, i))){
				count = solve(str.substring(i), M) + 1;
			}
		}
		return count;
	}
}

