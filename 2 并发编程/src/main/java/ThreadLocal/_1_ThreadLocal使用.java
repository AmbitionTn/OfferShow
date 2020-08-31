package ThreadLocal;

/**
 * @author tning
 * @create 2020/08/19
 */
public class _1_ThreadLocal使用 {
    /**
     * 打印函数
     */
    static void print(String str) {
        System.out.println(str + "：");
        localvariable.remove();
    }

    // 创建ThreadLocal线程私有变量
    static ThreadLocal<String> localvariable = new ThreadLocal<String>();

    public static void main(String[] args) {
         Thread main = Thread.currentThread();

        // 创建线程1
        Thread threadOne = new Thread(new Runnable() {
            public void run() {
                System.out.println("Thread one is running");
                localvariable.set("Thread Local variable");
                print("ThreadOne");
                System.out.println("ThreadOne remove after " + localvariable.get());
            }
        });

        // 创建线程2
        Thread threadTwo = new Thread(new Runnable() {
            public void run() {
                System.out.println("Thread two is running");
                localvariable.set("Thread Local variable");
                print("ThreadTwo");
                System.out.println("ThreadTwo remove after " + localvariable.get());
            }
        });

        threadOne.start();
        threadTwo.start();
    }
}
