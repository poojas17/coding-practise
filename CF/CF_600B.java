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

public class CF_600B {
	public static class Solution {
		public void CF_600B(int[] A, int[] B) {
			
			int n = A.length;
			int m = B.length;
			//int[] ans = new int[m];
			StringBuilder sb = new StringBuilder();
			
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();	// value, index
			for(int i =0;i<n;i++){
				map.put(A[i], i);
				//System.out.println("A[i] : "+ A[i] + " and i: "+i);
			}
			
			for(int i=0;i<m;i++){
				if(map.containsKey(B[i])) {
					int k  = map.get(B[i])+1;
					sb.append(k + " ");
				} else {
					int k = binaryFloorSearch(A,B[i]);
					
					sb.append(k + " ");
				}
				
				
			}
			System.out.print(sb.toString());
			//return ans;
			
   		}
		
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
			
				if (A[mid] < key) {
					low=mid+1;
					prevValue = low;
				} else {
					high =mid-1;
				}
			}
			/*	
			for ( i = low; i <=high; i++)
				if (A[i] > key)
					return (i);*/
			return prevValue;
		}
	}
	public static void main(String[] args) {
		
		MyScanner sc = new MyScanner();
		//System.out.print("Enter n- ");
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		
		//System.out.print("Enter values- ");
		
		int[] A = new int[n];
			
		for(int j =0; j<n; j++){
			A[j]=sc.nextInt();
		}
		int[] B = new int[m];
		for(int j =0; j<m; j++){
			B[j]=sc.nextInt();
		}
		Solution s = new Solution();
		Arrays.sort(A);
		
		s.CF_600B( A,B);
		//System.out.println(ans);
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


