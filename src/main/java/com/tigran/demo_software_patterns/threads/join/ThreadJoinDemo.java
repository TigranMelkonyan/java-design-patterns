package com.tigran.demo_software_patterns.threads.join;

import lombok.extern.log4j.Log4j2;

/**
 * Created by Tigran Melkonyan
 * Date: 5/12/25
 * Time: 4:46 PM
 */
@Log4j2
//Thread 1 locks bot main thread continue executing and thread 2 is created
public class ThreadJoinDemo {
    public static void main(String[] args) throws InterruptedException {
        
        Thread t1 = new Thread(() -> {
            log.info("Thread 1");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("Thread 2");
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

}
