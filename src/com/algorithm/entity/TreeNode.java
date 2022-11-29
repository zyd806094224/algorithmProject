package com.algorithm.entity;

public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int value) {
        this.value = value;
    }

    /**
     * 获取一棵如下二叉树
     *            1
     *          /   \
     *         2     3
     *       /  \   / \
     *      4    5 6   7
     * @return
     */
    public static TreeNode getATreeNode(){
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);
        root.left = left1;
        root.right = right1;
        TreeNode left21 = new TreeNode(4);
        TreeNode right21 = new TreeNode(5);
        left1.left = left21;
        left1.right = right21;
        TreeNode left22 = new TreeNode(6);
        TreeNode right22 = new TreeNode(7);
        right1.left = left22;
        right1.right = right22;
        return root;
    }
}
