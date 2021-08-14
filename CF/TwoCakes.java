/*
Hashmap mei key hogi A[i] and value hogi Pair - dono 1s ka no. 
fir dono 2s ka index 

and so on 


3 tier
1 1 2 2 3 3


1 -> 0, 1
2 -> 2,3
3 -> 4,5


*/


import java.util.*;
import java.io.*;

public class TwoCakes{
	public static class Pair {
		public int first;
		public int second;
		/*
		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}*/
	}
	public static void main(String[] args) {
		
		MyScanner sc = new MyScanner();
		int n = sc.nextInt();
		
		
		HashMap<Integer, Pair> map = new HashMap<>();
		//int[] A = new int[2*n];
		for(int j =0; j<(2*n); j++){
			int k=sc.nextInt();
			Pair pair=null;
			if(map.get(k) !=null) {
				
				pair = map.get(k);
				pair.second =j;
			} else {
				pair = new Pair();
				pair.first = j;
			}
			map.put(k, pair);
			
		}
		long sum = 0;
		int x = 0, y= 0;

		for(int i = 0;i<n;i++){
			
			Pair p = map.get(i+1);
			//System.out.println("P first: "+ p.first + " and second: "+ p.second);
			sum += Math.abs(p.first - x) + Math.abs(p.second - y);
			x = p.first;
			y = p.second;
		}
		
		System.out.println(sum);
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