package com.algorithm;

import com.algorithm.entity.TreeNode;

/**
 * 判断root2 是否是 root1的子树
 */
public class HasSubtree {
    public static void main(String[] args) {

    }

    public static boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null) return false;
        if(root1.value == root2.value && process(root1.left,root2.left) && process(root1.right,root2.right)){
            return true;
        }else{
            return hasSubtree(root1.left,root2) || hasSubtree(root1.right,root2);
        }
    }

    private static boolean process(TreeNode root1,TreeNode root2){
        if(root2 == null) return true;
        if(root1 == null) return false;
        return root1.value == root2.value && process(root1.left,root2.left) && process(root1.right,root2.right);
    }
}
