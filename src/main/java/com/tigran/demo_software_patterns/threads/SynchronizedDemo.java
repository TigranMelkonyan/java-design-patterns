package com.tigran.demo_software_patterns.threads;

/**
 * Created by Tigran Melkonyan
 * Date: 4/26/25
 * Time: 6:44 PM
 */
public class SynchronizedDemo {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount(1000);

        // Create multiple threads that access the same account
        Thread t1 = new Thread(() -> {
            account.deposit(300);
            account.withdraw(50);
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            account.deposit(203.45);
            account.withdraw(100);
        }, "Thread-2");

        Thread t3 = new Thread(() -> {
            account.withdraw(1500); // Should fail due to insufficient funds
        }, "Thread-3");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final balance: " + account.getBalance());
    }
}

class BankAccount {
    private double balance;
    private final Object lock = new Object(); // Explicit lock object

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Synchronized method approach
    public synchronized void deposit(double amount) {
        System.out.println(Thread.currentThread().getName() + " depositing " + amount);
        balance += amount;
        System.out.println("New balance after deposit: " + balance);
    }

    // Synchronized block approach (using explicit lock)
    public void withdraw(double amount) {
        synchronized (lock) {
            if (balance >= amount) {
                System.out.println(Thread.currentThread().getName() + " withdrawing " + amount);
                balance -= amount;
                System.out.println("New balance after withdrawal: " + balance);
            } else {
                System.out.println(Thread.currentThread().getName() + " - Insufficient funds for withdrawal of " + amount);
            }
        }
    }

    public double getBalance() {
        return balance;
    }
}
