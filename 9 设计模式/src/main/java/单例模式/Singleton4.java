package 单例模式;

/**
 * @author taoning
 * @create 2020/10/10
 * <p>
 * 静态内部类
 */
public class Singleton4 {
    private Singleton4() {
    }

    private static class SingletonHolder {
        public static Singleton4 singleton4 = new Singleton4();
    }

    public static Singleton4 newInstance() {
        return Singleton4.newInstance();
    }
}
