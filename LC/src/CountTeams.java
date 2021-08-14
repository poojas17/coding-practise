import java.util.*;

public class CountTeams {
	public static class Solution {
		 public int numTeams(int[] A) {
			int n = A.length;
			int[] leftInc = new int[n];
			int[] rightInc = new int[n];
			int[] leftDec = new int[n];
			int[] rightDec = new int[n];
			
			int i=0,j,k,sum=0;
			for(j=1;j<n;j++){
				for(i=0;i<j;i++){
					if(A[i]< A[j]){
						leftDec[j]++;
					}
					if(A[j]<A[i]) {
						leftInc[j]++;
					}
				}
				for(k=j+1;k<n;k++){
					if(A[k]< A[j]){
						rightDec[j]++;
					}
					if(A[j]<A[k]) {
						rightInc[j]++;
					}
				}
				sum+= (leftInc[j] * rightDec[j]) + ( rightInc[j] * leftDec[j]);
			}
			return sum;
		}
	}
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int[] A = new int[n];
		System.out.print("Enter array- ");
		for(int i =0;i<n;i++){
			A[i]=sc.nextInt();
			
		}
		
		Solution s = new Solution();
		int ans = s.numTeams(A);
		System.out.println(ans);
	}
}

