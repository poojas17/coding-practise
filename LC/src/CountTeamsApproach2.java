import java.util.*;

public class CountTeamsApproach2 {
	public static class Solution {
		 public int numTeams(int[] A) {
			int n = A.length;
			int i=0,j,k,sum=0;
			for(j=1;j<n-1;j++){
			
				int iSmall=0,iBig=0, kSmall=0, kBig=0;
			
				for(i=0;i<j;i++){
					if(A[i]< A[j]){
						iSmall++;
					} else if (A[j]<A[i]) {
						iBig++;
					}
				}
				for(k=j+1;k<n;k++){
					if(A[k]< A[j]){
						kSmall++;
					} else if(A[j]<A[k]) {
						kBig++;
					}
				}
				sum+= (iBig * kSmall) + ( kBig * iSmall);
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

