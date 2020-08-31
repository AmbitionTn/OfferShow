package 创建线程的方式;

/**
 * 继承Thread类创建线程
 */
public class ThreadTest extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        ThreadTest t1 = new ThreadTest();
        ThreadTest t2 = new ThreadTest();
        t1.setName("thread_t1");
        t2.setName("thread_t2");
        t1.start();
        t2.start();
    }
}
