package 创建线程的方式;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用FixThreadPool(int n)固定大小的线程池
 */
public class ThreadPool1 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        System.out.println(Thread.currentThread().getName() + " " + j);
                    }
                }
            });
        }
        executor.shutdown();
    }
}
