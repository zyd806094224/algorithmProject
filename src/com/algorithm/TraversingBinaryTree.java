package com.algorithm;

import com.algorithm.entity.TreeNode;

public class TraversingBinaryTree {

    public static void main(String[] args) {
        TreeNode aTreeNode = TreeNode.getATreeNode();

        prevDfs(TreeNode.getATreeNode());
        System.out.println();
        midDfs(TreeNode.getATreeNode());
        System.out.println();
        backDfs(TreeNode.getATreeNode());
    }

    private static void prevDfs(TreeNode root){
        if(root == null) return;
        System.out.print(root.value + ",");
        prevDfs(root.left);
        prevDfs(root.right);
    }

    private static void backDfs(TreeNode root){
        if(root == null) return;
        prevDfs(root.left);
        prevDfs(root.right);
        System.out.print(root.value + ",");
    }

    private static void midDfs(TreeNode root){
        if(root == null) return;
        prevDfs(root.left);
        System.out.print(root.value + ",");
        prevDfs(root.right);
    }


}
