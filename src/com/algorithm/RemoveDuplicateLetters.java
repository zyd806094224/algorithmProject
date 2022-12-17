package com.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 去除重复字母后结果字典序最小的
 */
public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("cbacdcbc"));
    }

    public static String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        for(int i = 0;i < s.length();i++){
            lastIndex[s.charAt(i) - 'a'] = i; //字母最后出现的位置
        }
        boolean[] exist = new boolean[26];
        Deque<Character> stack = new ArrayDeque<>();
        stack.addLast('a');//预站位方便处理 后面入栈的不可能存在小于a的
        for(int i = 0;i < s.length();i++){
            char ch = s.charAt(i);
            if(exist[ch - 'a']){//此字符存在过了
                continue;
            }
            while(stack.peekLast() > ch && lastIndex[stack.peekLast() - 'a'] > i){
                char c = stack.removeLast();
                exist[c - 'a'] = false;
            }
            stack.addLast(ch);
            exist[ch - 'a'] = true;
        }
        stack.removeFirst();
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.removeFirst());
        }
        return sb.toString();
    }
}
