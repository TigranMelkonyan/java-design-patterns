package com.tigran.demo_software_patterns.threads;

import lombok.extern.log4j.Log4j2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Tigran Melkonyan
 * Date: 4/27/25
 * Time: 3:23 PM
 */
@Log4j2
public class ThreadPoolExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2); // Only 2 threads!

        for (int i = 1; i <= 5; i++) {
            int fileId = i;
            executor.submit(() -> {
                log.warn("Downloading file {} by {}", fileId, Thread.currentThread().getName());
                try {
                    Thread.sleep(2000); // Simulate download time
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.warn("Finished file {} by {}", fileId, Thread.currentThread().getName());
            });
        }

        executor.shutdown(); // No more new tasks
        executor.awaitTermination(1, TimeUnit.MINUTES); // Wait for all tasks to finish
        System.out.println("All downloads completed.");
    }
}

