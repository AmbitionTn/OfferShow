package 重入锁;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 学习ReatrantLock
 */
public class Test_1 {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
    }
}
