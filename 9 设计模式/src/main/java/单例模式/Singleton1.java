package 单例模式;

/**
 * @author taoning
 * @create 2020/10/10
 * <p>
 * 单例模式 双重锁
 */
public class Singleton1 {

    /**
     * 1、分配内存空间
     * 2、初始化对象
     * 3、将内存空间的地址赋值给对应的引用
     * <p>
     * <p>
     * 使用volatile的作用是防止指令重排
     */
    private volatile static Singleton1 singleton1;

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        if (singleton1 == null) {
            synchronized (Singleton1.class) {

                // 这里判断两次的目的是防止多个线程竞争锁获得null
                if (singleton1 == null) {
                    singleton1 = new Singleton1();
                }
            }
        }
        return singleton1;
    }
}
