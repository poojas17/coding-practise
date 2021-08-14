

import java.util.*;

public class UncrossedLines {

	public static class Solution {
		public static int maxUncrossedLines(int[] nums1, int[] nums2) {
			int i=0,j=0;
			int n = nums1.length;
			int m = nums2.length;
			int dp[][]= new int[n+1][m+1];
			for(i=0;i<=n;i++){
				dp[i][0]=0;
				
			}
			for(j=0;j<=m;j++){
				dp[0][j]=0;
			}
			
			for(i=1;i<=n;i++){
				for(j=1;j<=m;j++){
					int x=dp[i][j-1];
					int y = dp[i-1][j];
					int maxXY=Math.max(x,y);
					int z=0;
					if(nums1[i-1]==nums2[j-1]) {
						z=dp[i-1][j-1]+1;
					}
					dp[i][j]=Math.max(maxXY,z);
				}
			}
			
			return dp[n][m];
		}
	}
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] nums1 = new int[n];
		int[] nums2= new int[m];
		System.out.print("Enter  array 1- ");
		for(int i =0;i<n;i++){
				nums1[i]=sc.nextInt();
			
		}
		
		System.out.print("Enter  array 2- ");
		for(int i =0;i<m;i++){
				nums2[i]=sc.nextInt();
			
		}
		
		Solution s = new Solution();
		int ans = s.maxUncrossedLines(nums1,nums2);
		System.out.println(ans);
	}
}

/*

T(n,m) = Max {
                T(n,m-1),
                T(m-1,n),
                T(n-1,m-1) if A[i]==A[j]
             }
*/