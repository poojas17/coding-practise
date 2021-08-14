

import java.util.*;

public class CountNegatives {
	public static class Solution {
		public int countNegatives(int[][] grid) {
			int m = grid.length;
			int n = grid[0].length;
			System.out.println("m: " + m  + " n :" + n);
			int count=0,i=0;
				for(int j =n-1;j>=0 && i!=m;){
					
					System.out.println("i : " + i + " j :" + j + " grid: "+ grid[i][j]);
					
					if(grid[i][j] < 0) {
						count+= (m-i);
						j--;
						System.out.println("count: " + count);
					} else {
						i++;
					}
				}
			return count;
   		}
	}
	public static void main(String[] args) {
		//int[][] grid = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
		
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter rows- ");
		int m = sc.nextInt();
		System.out.print("Enter cols- ");
		
		int n = sc.nextInt();
		int[][] grid = new int[m][n];
		System.out.print("Enter grid- ");
		for(int i =0;i<m;i++){
			for(int j =0;j<n;j++){
				grid[i][j]=sc.nextInt();
			}
		}
		
		Solution s = new Solution();
		s.countNegatives(grid);
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
