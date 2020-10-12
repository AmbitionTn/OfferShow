package 单例模式;

/**
 * @author taoning
 * @create 2020/10/10
 * <p>
 * 单例模式 懒汉式
 */
public class Singleton2 {

    private static Singleton2 singleton2;

    private Singleton2() {
    }

    /**
     * 懒汉式 无法保证线程安全
     *
     * @return
     */
    public static Singleton2 getInstance() {
        if (null == singleton2) {
            singleton2 = new Singleton2();
        }
        return singleton2;
    }

}
