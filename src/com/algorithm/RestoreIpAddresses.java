package com.algorithm;

import java.util.ArrayList;

public class RestoreIpAddresses {

    public static void main(String[] args) {
        String str = "25525522135";
        ArrayList<String> strings = restoreIpAddresses(str);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    /**
     * @param s string字符串
     * @return string字符串ArrayList
     */
    public static ArrayList<String> restoreIpAddresses(String s) {
        // write code here
        ArrayList<String> ans = new ArrayList<String>();
        ArrayList<String> segment = new ArrayList<String>();
        process(s, 0, segment, ans);
        return ans;
    }

    private static void process(String s, int index, ArrayList<String> segment, ArrayList<String> ans) {
        if (segment.size() == 4 && index >= s.length()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < segment.size(); i++) {
                sb.append(segment.get(i));
                if (i != segment.size() - 1) {
                    sb.append(".");
                }
            }
            ans.add(sb.toString());
            return;
        } else {
            if (segment.size() > 4) return;
            for (int i = index; i < s.length() && i < index + 3; i++) {
                String str = s.substring(index, i + 1);
                if (str.charAt(0) == '0' && str.length() > 1) {
                    break;
                }
                int num = Integer.parseInt(str);
                if (num >= 0 && num <= 255) {
                    segment.add(str);
                    process(s, i + 1, segment, ans);
                    segment.remove(segment.size() - 1);
                } else {
                    break;
                }
            }
        }
    }
}
