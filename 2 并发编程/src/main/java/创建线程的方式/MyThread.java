package 创建线程的方式;

/**
 * 实现Runnable接口创建线程
 */
public class MyThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
                System.out.println("Thread name is " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread(),"Thread_t1");
        Thread t2 = new Thread(new MyThread(),"Thread_t2");
        Thread t3 = new Thread(new MyThread(),"Thread_t3");
        t1.start();
        t2.start();
        t3.start();
    }
}
