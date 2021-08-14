/*
https://leetcode.com/problems/insufficient-nodes-in-root-to-leaf-paths/submissions/
*/


import java.util.*;
import java.io.*;

public class InsufficientNodes {
	public static class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode() {}
		 TreeNode(int val) { this.val = val; }
		 TreeNode(int val, TreeNode left, TreeNode right) {
			 this.val = val;
			 this.left = left;
			 this.right = right;
		 }
	 }
	public static class Solution {
		public TreeNode sufficientSubset(TreeNode root, int limit) {
			if(root == null) {
				return null;
			}
			int sum = root.val;
			boolean r= removeInsufficientNodes(root, limit, sum);
			if(r == false){
				return null;
			} else {
				return root;
			}
		}
		
		boolean removeInsufficientNodes(TreeNode root, int limit, int sum) {
		   
			if(root.left == null && root.right==null) {
				if(sum < limit) {
					return false;
				} else {
					return true;
				}
			}
			boolean left = false;
			if(root.left !=null) {
			 left= removeInsufficientNodes(root.left, limit, sum+root.left.val);
			}
			if(left==false){
				root.left = null;
			}
			boolean right = false;
			if(root.right !=null) {
				right = removeInsufficientNodes(root.right, limit, sum+root.right.val);
			}
			if(right==false){
				root.right = null;
			}
			
			return (left || right);
			
		}
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(-3);
		Solution s = new Solution();
		TreeNode r = s.sufficientSubset(root,0);
		System.out.println("root:" +r.val);
		
		
		
	}

}

