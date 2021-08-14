import java.util.*;

public class LastStoneWeight2 {
	public static class Solution {
		  public int lastStoneWeight2(int[] stones) {
			if(stones.length==1){
				return stones[0];
			}
			
			int n = stones.length,sum=0;
			for(int i=0;i<n;i++){
				sum+=stones[i];
			}
			boolean dp[][] = new boolean[n+1][(sum/2)+1];
			dp[0][0]= true;
			// i=1..n, sum=0 bnana hai toh it would be true for all coz we wont pick any element
			// i=0, j=0...sum bnana hai toh false coz element he ni hai
			
			for(int i =1;i<=n;i++){
				for(int j = sum/2;j>=0;j--){
					boolean withCurrElement = false;    // current element include kia
					if(j>=stones[i-1]) {    //sum bda hai element se tbhi element ko include krskte
						// for ex: j = 40 i.e. sum and stones[i-1]=31 toh 40 sum bnana hai toh 31 include kroge bt agar element he 50 hota toh ni krskte na include 
						withCurrElement = dp[i-1][j- stones[i-1]];
					}
					boolean withoutCurrElement = dp[i-1][j]; // curr element include ni kra
					dp[i][j]=withCurrElement || withoutCurrElement;
				}
			}
			
			for(int j =sum/2; j>0;j--){ //ulta chalaya coz hume sum se sbse closest dkhna tha 
				if(dp[n][j]== true) {   // jo b true hoga usse closest
					return sum -(2*j); // 151 - (2*73) =5
				}
			}
		 return 0;  
		}
	}
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] stones = new int[n];
		System.out.print("Enter stones array- ");
		for(int i =0;i<n;i++){
				stones[i]=sc.nextInt();
			
		}
		
		Solution s = new Solution();
		int ans = s.lastStoneWeight2(stones);
		System.out.println(ans);
	}
}

/*
[31,26,33,21,40]


*/
