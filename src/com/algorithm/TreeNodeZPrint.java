package com.algorithm;

import com.algorithm.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树之字形打印
 */
public class TreeNodeZPrint {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> print = print(TreeNode.getATreeNode());
        for (ArrayList<Integer> integers : print) {
            for (Integer integer : integers) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        if (pRoot == null) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(pRoot);
        boolean flag = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            while (size > 0) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
                if (!flag) {
                    list.add(treeNode.value);
                } else {
                    list.add(0, treeNode.value);
                }
                size--;
            }
            ans.add(list);
            flag = !flag;
        }
        return ans;
    }
}
