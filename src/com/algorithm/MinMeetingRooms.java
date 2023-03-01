package com.algorithm;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinMeetingRooms {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{0, 30}, {5, 10}, {15, 20}};
        System.out.println(minMeetingRooms(arr));
    }

    public static int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);//升序排列
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);
        queue.offer(intervals[0][1]);//将第一个会议的结束时间存入栈中
        for (int i = 1; i < intervals.length; i++) {//从第二个会议开始遍历
            //若之后的会议开始时间 大于 当前栈中栈顶存储的结束时间
            //（大于: 会议开始时间 在 栈顶时间之后）
            //弹栈：代表 这个会议室可以重复使用， 不需要重新开新的一间会议室 所以queue--
            if (intervals[i][0] >= queue.peek()) {
                queue.poll();
            }
            queue.offer(intervals[i][1]);
        }
        return queue.size();
    }
}
