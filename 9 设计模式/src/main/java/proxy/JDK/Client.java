package proxy.JDK;

import proxy.UserService;
import proxy.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author taoning
 * @create 2020/10/14
 */
public class Client {

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        UserServiceImpl userService = new UserServiceImpl();
        ClassLoader classLoader = userService.getClass().getClassLoader();
        Class[] interfaces = userService.getClass().getInterfaces();
        InvocationHandler handler = new LogHandler(userService);

        UserService proxy = (UserService) Proxy.newProxyInstance(classLoader, interfaces, handler);
        proxy.select();
        proxy.update();
    }
}
