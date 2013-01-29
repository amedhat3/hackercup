import java.io.*;
import java.util.Scanner;


public class ProblemGen {
	public static void main (String[] args) throws Exception{
		String NL = System.getProperty("line.separator");
		StringBuilder text = new StringBuilder();

		String fFileName = "input.in";
		Scanner scanner = new Scanner(new FileInputStream(fFileName));
		try {
			while (scanner.hasNextLine()){
				text.append(scanner.nextLine() + NL);
			}	
		}
		finally{
			scanner.close();
		}
//		log("Text read in: " + text);

		for(int i = 0 ; i < 10000 ; i ++) {
			String searchFor = ""+i;
			String base = text.toString();
			int len = searchFor.length();
			int result = 0;
			if (len > 0) {  
				int start = base.indexOf(searchFor);
				while (start != -1) {
					result++;
					start = base.indexOf(searchFor, start+len);
				}
			}
			System.out.println(i + "-- > " +result);
		}
		System.exit(0);
	}
	
	private static void log(String aMessage){
		System.out.println(aMessage);
	}

}
