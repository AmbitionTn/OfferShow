package 创建线程的方式;

import java.util.concurrent.*;

/**
 * Future学习使用
 *
 * @author tning
 * @create 2020/08/28
 */
public class FutureStudy {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Task task = new Task();
        Future<Integer> future = executor.submit(task);
        executor.shutdown();
        System.out.println("主线程正在执行任务");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("task运行结果：" + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("所有任务执行完毕");
    }
}

class Task implements Callable {

    @Override
    public Integer call() throws Exception {
        System.out.println("子线程在计算");
        Thread.sleep(2000);
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        return sum;
    }
}
