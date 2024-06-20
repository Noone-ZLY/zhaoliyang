package com.zly.tree;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/9/25 20:32
 */
public class Tree {
    static class TreeNode{
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
    /**
     * @param [nums, index]
     * @return com.zly.tree.Tree.TreeNode
     * @description 构建二叉树
     * @author zhaoliyang
     * @create 2023/9/27 12:36
     */
    public static TreeNode buildTree(int[] nums, int index){
        if(index >= nums.length){
            return null;
        }
        TreeNode root = new TreeNode(nums[index]);
        root.left = buildTree(nums, 2 * index + 1);
        root.right = buildTree(nums, 2 * index + 2);
        return root;
    }

    public static void preOrderDFS(TreeNode root, List<Integer> preOrderList){
        if(root == null){
            return ;
        }
        preOrderList.add(root.val);
        preOrderDFS(root.left, preOrderList);
        preOrderDFS(root.right, preOrderList);
    }
    public static List<Integer> preOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        preOrderDFS(root, res);
        return res;
    }

    /**
     * @param [root]
     * @return java.util.List<java.util.List<java.lang.Integer>>
     * @description 二叉树层序遍历
     * @author zhaoliyang
     * @create 2023/9/27 12:32
     */
    public static List<List<Integer>> levelOrder(TreeNode root){
        if(root == null){
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while(!deque.isEmpty()){
            List<Integer> part = new ArrayList<>();
            int size = deque.size();
            for(int i = 0; i < size; i++){
                TreeNode node = deque.pollFirst();
                part.add(node.val);
                if(node.left != null){
                    deque.add(node.left);
                }
                if(node.right != null){
                    deque.add(node.right);
                }
            }
            res.add(part);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root = buildTree(nums, 0);
        List<List<Integer>> levelOrderRes = levelOrder(root);
        levelOrderRes.stream().forEach(System.out::println);
        List<Integer> preOrderRes = preOrder(root);
        preOrderRes.stream().forEach(System.out::println);
    }
}
