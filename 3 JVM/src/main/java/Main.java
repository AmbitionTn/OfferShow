import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author taoning
 * @create 2020/10/16
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        ConvertClassLoader classLoader = new ConvertClassLoader("/Users/tning/Documents/Hello/");
        classLoader.setFileName("Hello.xlass");
        Object object = classLoader.findClass("Hello").newInstance();
        Method method = object.getClass().getMethod("hello");
        method.invoke(object);
    }
}
