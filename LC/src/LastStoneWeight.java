import java.util.*;

public class LastStoneWeight {
	public static class Solution {
		public int lastStoneWeight1(int[] stones) {
			//Arrays.sort(stones);
			int n = stones.length;
			
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			for(int i =0;i<n;i++){
				pq.add(stones[i]);
			}
			while(pq.size()>1){
				int x = pq.poll();
				int y = pq.poll();
				
				pq.add(x-y);
				
			}
			return pq.isEmpty() ? 0: pq.peek();
			
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
		int ans = s.lastStoneWeight1(stones);
		System.out.println(ans);
	}
}

/*
5 3 3 2 2 	1
3 2 2 2 1 
1 2 2 1= 2 2 1 1 
0 0 =0 


*/
