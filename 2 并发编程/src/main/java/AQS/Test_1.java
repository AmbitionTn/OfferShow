package AQS;

/**
 * 学习AQS基础
 *
 * @author tning
 * @create 2020/08/28
 */
public class Test_1 {
    public static int m = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                synchronized (Test_1.class){
                    for (int j = 0; j < 100; j++) m++;
                }
            });
        }

        for (Thread t : threads) t.start();
        for (Thread t : threads) t.join();

        System.out.println(m);
    }

}

