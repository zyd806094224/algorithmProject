package com.algorithm;

/**
 * 死锁条件触发
 */
public class DeadLock {

    static Object object1 = new Object();
    static Object object2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (object1){
                System.out.println("A--obj1");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("A--start");
                synchronized (object2){
                    System.out.println("A--obj2");
                }
            }
        },"A").start();
        new Thread(() -> {
            synchronized (object2){
                System.out.println("B--obj2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("B--start");
                synchronized (object1){
                    System.out.println("B--obj1");
                }
            }
        },"B").start();
    }


}
