package com.algorithm;

import com.algorithm.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的序列化与反序列化
 */
public class TreeNodeSerializeAndDeserialize {
    public static void main(String[] args) {
        String serialize = serialize(TreeNode.getATreeNode());
        System.out.println(serialize);
        TreeNode deserialize = deserialize(serialize);
        System.out.println(deserialize);
    }

    static String serialize(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.value + ",");
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                sb.append("#,");
            }
        }
        return sb.toString();
    }

    static TreeNode deserialize(String str) {
        if (str == null) return null;
        String[] strArr = str.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(strArr[0]));
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!"#".equals(strArr[index])) {
                node.left = new TreeNode(Integer.parseInt(strArr[index]));
                queue.offer(node.left);
            }
            index++;
            if (!"#".equals(strArr[index])) {
                node.right = new TreeNode(Integer.parseInt(strArr[index]));
                queue.offer(node.right);
            }
            index++;
        }
        return root;
    }
}
