package com.algorithm;

import java.util.PriorityQueue;

/**
 * 数据流的中位数 大顶堆&小顶堆
 */
public class MedianOfDataFlow {
    public static void main(String[] args) {
        //[5,2,3,4,1,6,7,0,8]
        Insert(5);
        System.out.println(GetMedian());
        Insert(2);
        System.out.println(GetMedian());
        Insert(3);
        System.out.println(GetMedian());
        Insert(4);
        System.out.println(GetMedian());
        Insert(1);
        System.out.println(GetMedian());
        Insert(6);
        System.out.println(GetMedian());
        Insert(7);
        System.out.println(GetMedian());
        Insert(0);
        System.out.println(GetMedian());
        Insert(8);
        System.out.println(GetMedian());
    }

    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1,o2) -> {
        return o2 - o1;
    });

    public static void Insert(Integer num) {
        if(minHeap.size() == 0){
            minHeap.offer(num);
        }else if(minHeap.peek() < num){
            minHeap.offer(num);
        }else{
            maxHeap.offer(num);
        }
        while(minHeap.size() - maxHeap.size() > 1){
            maxHeap.offer(minHeap.poll());
        }
        while(maxHeap.size() - minHeap.size() > 1){
            minHeap.offer(maxHeap.poll());
        }
    }

    public static Double GetMedian() {
        if(minHeap.size() == maxHeap.size()){
            return (double)(minHeap.peek() + maxHeap.peek())/2;
        }else{
            if(minHeap.size() > maxHeap.size()){
                return (double)minHeap.peek();
            }else{
                return (double)maxHeap.peek();
            }
        }
    }
}
