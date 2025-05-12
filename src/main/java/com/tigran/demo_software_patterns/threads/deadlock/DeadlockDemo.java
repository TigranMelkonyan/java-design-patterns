package com.tigran.demo_software_patterns.threads.deadlock;

/**
 * Created by Tigran Melkonyan
 * Date: 4/25/25
 * Time: 7:46 PM
 */
public class DeadlockDemo {

    private static final Object LOCK_A = new Object();
    private static final Object LOCK_B = new Object();

    // quick fix for avoiding deadlock, keep consequence of locked objects LOCK_A LOCK_B LOCK_A LOCK_B 
    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            synchronized (LOCK_A) {
                System.out.println("Thread 1: locked A");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException ignored) {
                }

                synchronized (LOCK_B) {
                    System.out.println("Thread 1: locked B");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (LOCK_B) {
                System.out.println("Thread 2: locked B");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException ignored) {
                }

                synchronized (LOCK_A) {
                    System.out.println("Thread 2: locked A");
                }
            }
        });

        threadA.start();
        thread2.start();
    }
}

