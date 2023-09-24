package com.zly.tengxunyinyue_20230922;

import java.util.Arrays;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/9/22 19:07
 */
 class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;
     public TreeNode(int val) {
         this.val = val;
     }
 }
public class Main1 {
    public int cntOfMethods (TreeNode[] trees) {
        // write code here
        int n = trees.length;
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return 1;
        }
        int mod = (int)(1e9 + 7);
        int[] nums = new int[n];
        int i = 0;
        for(TreeNode node : trees){
            if(node.left != null && node.right != null){
                nums[i++] = 4;
            }else if(node.left == null && node.right == null){
                nums[i++] = 0;
            }else{
                nums[i++] = 2;
            }
        }
        if(n == 2){
            return nums[0] + nums[1];
        }

        int sum = Arrays.stream(nums).sum();
        int ans = 0;
        for(int j = 0; j < nums.length; j++){
            ans = (ans % mod + (nums[j] * (sum - nums[j])) % mod) % mod;
        }
        return ans;
    }
    public static void main(String[] args) {
        new TreeNode(1);
    }
}
