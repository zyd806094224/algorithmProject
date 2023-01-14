package com.algorithm;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ABCThreadPrint {

    public static void main(String[] args) {
        Data data = new Data();
        int count = 5;
        new Thread(() -> {
            for (int i = 0; i < count; i++) {
                data.printA();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < count; i++) {
                data.printB();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < count; i++) {
                data.printC();
            }
        }, "C").start();
    }
}

class Data {
    Lock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();
    private int num = 1;

    public void printA() {
        lock.lock();
        try {
            while (num != 1) {
                conditionA.await();
            }
            num = 2;
            System.out.println("当前线程----->" + Thread.currentThread().getName());
            conditionB.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB() {
        lock.lock();
        try {
            while (num != 2) {
                conditionB.await();
            }
            num = 3;
            System.out.println("当前线程----->" + Thread.currentThread().getName());
            conditionC.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC() {
        lock.lock();
        try {
            while (num != 3) {
                conditionC.await();
            }
            num = 1;
            System.out.println("当前线程----->" + Thread.currentThread().getName());
            conditionA.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
