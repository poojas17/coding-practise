/*https://codeforces.com/problemset/problem/600/B

inputCopy
5 4
1 3 5 7 9
6 4 2 8
outputCopy
3 2 1 4
inputCopy
5 5
1 2 1 2 5
3 1 4 1 5
outputCopy
4 2 4 2 5

*/


import java.util.*;
import java.io.*;

public class CF_600B2 {
	public static class Solution {
	
		public int binaryFloorSearch(int[] A, int key) {
			int low = 0, high= A.length-1,i=0;
			if(key > A[high]) {
				//System.out.println("high chota " + high);
				return high+1;
			} else if (key < A[low]) {
				return 0;
			}
			int mid =0, prevValue=0;
			while(low <=high) {
				 mid = low + (high-low)/2;
			
				if(A[mid]==key) {
					if(mid < high && A[mid+1] == A[mid]) {
						prevValue=mid+1;
						low=mid+1;
					} else 
						return mid+1;
					
				}else if (A[mid] < key) {
					low=mid+1;
					prevValue = low;
				} else {
					high =mid-1;
				}
			}
			return prevValue;
		}
	}
	public static void main(String[] args) {
		
		MyScanner sc = new MyScanner();
		int n = sc.nextInt();
		int m = sc.nextInt();
	
		int[] A = new int[n];
			
		for(int j =0; j<n; j++){
			A[j]=sc.nextInt();
		}
		Arrays.sort(A);
		StringBuilder sb = new StringBuilder();

		Solution s = new Solution();
		for(int j =0; j<m; j++){
			int b=sc.nextInt();
			int k = s.binaryFloorSearch(A, b);
			sb.append(k + " ");
		}
		System.out.println(sb.toString());	
		
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


