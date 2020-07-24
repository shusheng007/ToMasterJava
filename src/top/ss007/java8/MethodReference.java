package top.ss007.java8;

import java.util.Arrays;
import java.util.function.*;
import java.util.stream.Stream;

public class MethodReference {


    /**
     * 静态方法如何使用方法引用
     * <p>
     * (args) -> Class.staticMethod(args)
     * <p>
     * Class::staticMethod
     */
    public void testStaticMethodRef() {
        //匿名内部类形式
        Predicate<Integer> p1 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return TestUtil.isBiggerThan3(integer);
            }
        };
        //lambda表达式形式
        Predicate<Integer> p2 = integer -> TestUtil.isBiggerThan3(integer);
        //MethodReference形式
        Predicate<Integer> p3 = TestUtil::isBiggerThan3;

        Stream.of(1, 2, 3, 4, 5).filter(p3).forEach(System.out::println);

        Consumer<String> consumer1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        Consumer<String> consumer2 = System.out::println;

        Arrays.asList("shu", "sheng", "007").forEach(System.out::println);
    }

    /**
     * Instance method reference of an object of a particular type
     * <p>
     * (obj, args) -> obj.instanceMethod(args)
     * <p>
     * ObjectType::instanceMethod
     * <p>
     * 必须有一个实例对象当做参数传递到了lambda表达式中，调用了此对象的方法
     */
    public void testInstanceMethodRef1() {
        BiFunction<Student, String, String> f1 = new BiFunction<Student, String, String>() {
            @Override
            public String apply(Student student, String s) {
                return student.getStatus(s);
            }
        };
        BiFunction<Student, String, String> f2 = (student, s) -> student.getStatus(s);

        BiFunction<Student, String, String> f3 = Student::getStatus;

        System.out.println(getStudentStatus(new Student("erGouWang", 18), "study", f3));
    }

    private String getStudentStatus(Student student, String action, BiFunction<Student, String, String> biFunction) {
        return biFunction.apply(student, action);
    }

    /**
     * Instance method reference of an existing object
     * <p>
     * (args) -> obj.instanceMethod(args)
     * <p>
     * obj::instanceMethod
     */
    public void testInstanceMethodRef2() {
        TestUtil utilObj = new TestUtil();

        Consumer<Student> c1 = new Consumer<Student>() {
            @Override
            public void accept(Student student) {
                utilObj.printDetail(student);
            }
        };
        Consumer<Student> c2 = student -> utilObj.printDetail(student);

        Consumer<Student> c3 = utilObj::printDetail;

        consumeStudent(new Student("erGouWang", 18), c3);
    }

    private void consumeStudent(Student student, Consumer<Student> consumer) {
        consumer.accept(student);
    }

    /**
     * Constructor method reference
     * <p>
     * (args) -> new ClassName(args)
     * <p>
     * ClassName::new
     */
    public void testConstructorMethodRef() {
        BiFunction<String, Integer, Student> s1 = new BiFunction<String, Integer, Student>() {
            @Override
            public Student apply(String name, Integer age) {
                return new Student(name, age);
            }
        };

        BiFunction<String, Integer, Student> s2 = (name, age) -> new Student(name, age);

        BiFunction<String, Integer, Student> s3 = Student::new;

        System.out.println(getStudent("cuiHuaNiu", 20, s3).toString());

    }

    private Student getStudent(String name, int age, BiFunction<String, Integer, Student> biFunction) {
        return biFunction.apply(name, age);
    }


    public static class TestUtil {
        public static boolean isBiggerThan3(int input) {
            return input > 3;
        }

        public void printDetail(Student student) {
            System.out.println(student.toString());
        }
    }

    public static class Student {
        private String name;
        private int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getStatus(String thing) {
            return String.format("%d岁的%s正在%s", age, name, thing);
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
