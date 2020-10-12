import java.util.Objects;
import java.util.Random;

/**
 * @author taoning
 * @create 2020/10/10
 */
public class HashSet {
    public static void main(String[] args) throws InterruptedException {
        final Student student = new HashSet().new Student(1, "test1", 1);
        System.out.println(student.hashCode() + " main Thread 1");
        student.setAge(2);
        System.out.println(student.hashCode() + " main Thread 2");

        new Thread(new Runnable() {
            @Override
            public void run() {
                student.setAge(10);
                System.out.println(student.hashCode() + " new thread");
            }
        }).start();

        Thread.sleep(1000);
    }

    class Student {

//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            Student student = (Student) o;
//            return id == student.id &&
//                    age == student.age &&
//                    Objects.equals(name, student.name);
//        }
//
//        @Override
//        public int hashCode() {
//            return new Random().nextInt();
//        }

        /**
         * 学生Id
         */
        private int id;

        /**
         * 学生姓名
         */
        private String name;

        /**
         * 学生年龄
         */
        private int age;

        Student(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
