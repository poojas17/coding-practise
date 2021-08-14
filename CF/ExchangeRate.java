import java.util.*;
import java.io.*;

public class ExchangeRate{

	public static void main(String[] args) {
		
		MyScanner sc = new MyScanner();
		String str = sc.nextLine();
		StringBuilder sb = new StringBuilder(str);
		int lastDigit = (int)str.charAt(str.length()-1);
		boolean flag = false;
		int bigNearToLastDigit=0;
		int smallFarFromLastDigit=0, small=0,big=0;
		for(int i=str.length()-2;i>=0;i--){
			
			int k  = (int) str.charAt(i);
			if(k%2==0) {
				if(k > lastDigit) {
					if(!flag) {
						bigNearToLastDigit= k;
						big=i;
						//sb.setCharAt(str.length()-1, str.charAt(i));
						//sb.setCharAt(i, str.charAt(str.length()-1));
						flag = true;
					}
				}  else {
					smallFarFromLastDigit=k;
					small=i;
					
				}
			}
			
		}
		
		if(smallFarFromLastDigit ==0 && flag) {
			int i =big;
			sb.setCharAt(str.length()-1, str.charAt(i));
			sb.setCharAt(i, str.charAt(str.length()-1));
			System.out.println(sb);
		} else if (smallFarFromLastDigit !=0 ) {
			int i =small;
			sb.setCharAt(str.length()-1, str.charAt(i));
			sb.setCharAt(i, str.charAt(str.length()-1));
			System.out.println(sb);
		} else {
			System.out.println("-1");
		}
		
	}
	
	 //-----------PrintWriter for faster output---------------------------------
   //public static PrintWriter out;
      
   //-----------MyScanner class for faster input----------
   public static class MyScanner {
      BufferedReader br;
      StringTokenizer st;
 
      public MyScanner() {
         br = new BufferedReader(new InputStreamReader(System.in));
      }
 
      String next() {
          while (st == null || !st.hasMoreElements()) {
              try {
                  st = new StringTokenizer(br.readLine());
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
          return st.nextToken();
      }
 
      int nextInt() {
          return Integer.parseInt(next());
      }
 
      long nextLong() {
          return Long.parseLong(next());
      }
 
      double nextDouble() {
          return Double.parseDouble(next());
      }
 
      String nextLine(){
          String str = "";
	  try {
	     str = br.readLine();
	  } catch (IOException e) {
	     e.printStackTrace();
	  }
	  return str;
      }

   }
}