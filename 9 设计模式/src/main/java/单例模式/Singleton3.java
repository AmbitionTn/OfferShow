package 单例模式;

/**
 * @author taoning
 * @create 2020/10/10
 * <p>
 * 单例模式 饿汉式
 */
public class Singleton3 {

    private final static Singleton3 singleton3 = new Singleton3();

    private Singleton3() {
    }

    /**
     * 饿汉式 线程安全的
     *
     * @return
     */
    public static Singleton3 getInstance() {
        return singleton3;
    }
}
