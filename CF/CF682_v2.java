/*4 9 1
2 3 1 - ans = 4

1 3 3 3 6 
1 2 3 
mex=4

2 3 4
1 


Alyona and Mex
//https://codeforces.com/problemset/problem/682/B
https://codeforces.com/blog/entry/7018
*/


import java.util.*;
import java.io.*;

public class CF682_v2{
	
	public static void main(String[] args) {
		
		MyScanner sc = new MyScanner();
		//Scanner sc= new Scanner(System.in);
		 
		//out = new PrintWriter(new BufferedOutputStream(System.out));
		//System.out.print("Enter n- ");
		int n = sc.nextInt();
		
		//System.out.print("Enter values- ");
		
		int[] A = new int[n];
		for(int j =0; j<n; j++){
			A[j]=sc.nextInt();
		}
		/*
		String str= sc.nextLine();
		//System.out.println("str: " + str);
		String[] strArr = str.split("\\s+");	// (" ") ni krskte
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
          String num = strArr[i];
          A[i] = Integer.parseInt(num);
		}
		*/
		Arrays.sort(A);
		int mex=1;
			
			for(int i =0;i<n;){
				if(mex==A[i]) {
					i++;
					mex++;
				}  else if (A[i]> mex) {
					A[i]=mex;
					mex=mex+1;
					i++;
				} else {
					i++;
				}
			}
		
		System.out.println(mex);
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

/*
[[4,3,2,-1],
[3,2,1,-1],
[1,1,-1,-2],
[-1,-1,-2,-3]]

m=4, n= 4
i=0, j = 3 , -tive toh count=m-i = 4-0=4


*/
