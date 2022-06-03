package Study;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Lambda
 *      1. Basic
 *          (parameters) -> expression
 *          (parameters) -> {statements;}
 *              Ex) (Apple al,  Apple aZ)  ->  al.getWeight().compareTo(a2.getWeight());
 *                  * (Apple al,  Apple aZ)
 *                      파라미터 리스트 // 메서드 파라미터
 *                  * ->
 *                      화살표 // 람다의 파라미터 리스트와 바디를 구분
 *                  * al.getWeight().compareTo(a2.getWeight());
 *                      람다 바디 // 람다의 반환값에 해딩하는 표현식
 *
 *      2. Java에서 제공하는 Functional Interface
 *          * Supplier<T> // () -> T
 *          * Consumer<T> // T -> void
 *          * Function<T, R> // T -> R
 *          * Predicate<T> // T -> boolean
 *          * Comparator<T> // (T, T) -> int
 *          * Runnable // () -> void
 *          * Callable<T> // () -> T
 *
 *      3. Method Reference
 *          * 함수형 인터페이스를 람다식이 아닌 일반 메소드를 참조시켜 선언하는 방법
 *          * 일반 메소드, Static 메소드, 생성자 참조 가능
 *          * 클래스이름::메소드이름 으로 참조
 *          * 조건)
 *              - 함수형 인터페이스의 매개변수 타입 = 메소드의 매개변수 타입
 *              - 함수형 인터페이스의 매개변수 개수 = 메소드의 매개변수 개수
 *              - 함수형 인터페이스의 반환형 = 메소드의 반환형
 * */

public class Lambda {
    @FunctionalInterface
    interface MyLambdaFunction {
        int max(int a, int b);
    }

    public static void main(String[] args) throws Exception {
    /**
     * Basic
     * */
            // 기존의 익명함수
            System.out.println("기존의 익명함수 : "+new MyLambdaFunction() {
                public int max(int a, int b) {
                    return a > b ? a : b;
                }
            }.max(3, 5));

            //람다식을 이용한 익명함수
            MyLambdaFunction lambdaFunction = (int a, int b) -> a > b ? a : b;
            System.out.println("람다식을 이용한 익명함수 : "+lambdaFunction.max(3, 5)+"\r\n");

    /**
     * Java에서 제공하는 Functional Interface
     * */
            //Supplier<T>
                //매개변수 없이 반환값 만을 갖는 함수형 인터페이스
                    //T get() 추상 메소드
            Supplier<String> supplier = () -> "Hello World!";
            System.out.println("Supplier<T> [get] : "+supplier.get()+"\r\n");

            //Consumer<T>
                //객체 T를 매개변수로 받아서 사용하며, 반환값은 없는 함수형 인터페이스
                    //accept(T t) 추상메소드
                    //andThen() - Consumer 객체 사용 후 매개변수 재사용
            Consumer<String> consumer1 = (str) -> System.out.println("Consumer<T> [accept] : "+str.split(" ")[0]);
            Consumer<String> consumer2 = (str) -> System.out.println("Consumer<T> [andThen] : "+str.split(" ")[0]+"\r\n");
            consumer1.andThen(consumer2).accept("Hello World");

            //Function<T, R>
                //객체 T를 매개변수로 받아서 처리한 후 R로 반환하는 함수형 인터페이스
                    //R apply(T t) 추상메소드
                    //andThen() - Function 객체 사용 후 반환객체 재사용
                    //compose() - Function 객체 사용 전 반환객체 재사용
            Function<String, Integer> function1 = (str) -> str.length();
            Function<Integer, Integer> function2 = (i) -> i*i;
            Function<String, String> function3 = (str) -> str+str;
            System.out.println("Function<T, R> [apply] : "+function1.apply("Hello World"));
            System.out.println("Function<T, R> [andThen] : "+function1.andThen(function2).apply("Hello World"));
            System.out.println("Function<T, R> [compose] : "+function1.compose(function3).apply("Hello World")+"\r\n");

            //Predicate<T>
                //객체 T를 매개 변수로 받아 처리한 후 Boolean을 반환하는 함수형 인터페이스
                    //Boolean test(T t) 추상 메소드
                    //and()
                    //negate()
                    //or()
                    //isEqual()
            Predicate<String> predicate1 = (str) -> str.equals("Hello World");
            Predicate<String> predicate2 = (str) -> str.contains("Hello");
            Predicate<String> predicate3 = (str) -> str.contains("Hi");
            Predicate<String> predicate4 = Predicate.isEqual(null);
            System.out.println("Predicate<T> [test] : "+predicate1.test("Hello World"));
            System.out.println("Predicate<T> [and] : "+predicate1.and(predicate2).test("Hello World"));
            System.out.println("Predicate<T> [negate] : "+predicate1.negate().test("Hello World"));
            System.out.println("Predicate<T> [or] : "+predicate1.or(predicate3).test("Hello World"));
            System.out.println("Predicate<T> [isEqual] : "+predicate4.test("Java")+"\r\n");

            //Comparator<T>
                //객체 T를 매개 변수로 받아 비교한 후 int를 반환하는 함수형 인터페이스
                    //int compare(T o1, T o2) 추상 메소드
                    //boolean equals(Object obj) 추상 메소드
                    //reversed()
                    //thenComparing()
                    //reverseOrder()
                    //naturalOrder()
                    //nullsFirst()
                    //nullsLast()
                    //comparing()
                //** Stream Api 정렬에서 정리

            //Runnable
                //쓰레드를 실행시키기 위한 함수형 인터페이스
                    //추상 메소드 미존재
                    //run()
            Runnable runnable = () -> System.out.println("Runnable [실행]\r\n");
            Thread thread = new Thread(runnable);
            System.out.println("Runnable [실행 전]");
            thread.start();

            //Callable<T>
                //매개변수 없이 반환값 만을 갖는 함수형 인터페이스
                //Supplier 와 Callable 은 완전히 동일
                //다만, Callable 은 Runnable 과 함께 병렬 처리를 위해 등장했던 개념으로서,
                //ExecutorService.submit 같은 함수는 인자로 Callable 을 받음
                    //call() 추상 메소드
            Callable<String> callable = () -> "Hello World!";
            System.out.println("Callable<T> [call] : "+callable.call()+"\r\n");

    /**
     * Java에서 제공하는 Functional Interface
     * */
            //일반메소드
                //EX
                    // 기존의 람다식
                    Function<String, Integer> function = (str) -> str.length();
                    function.apply("Hello World");
                    // 메소드 참조로 변경
                    function = String::length;
                    function.apply("Hello World");

                    // 메소드 참조를 통해 Consumer를 매개변수로 받는 forEach를 쉽게 사용할 수 있다.
                    List<String> list = Arrays.asList("red/", "orange/", "yellow/", "green/", "blue");
                    list.forEach(System.out::printf);
                    // 일반 메소드를 참조하여 Consumer를 선언한다.
                    Consumer<String> consumer = System.out::println;
                    consumer.accept("\r\n[일반 메소드] : Hello World!!\r\n");


            //Static 메소드
                //EX
                    //public static boolean isNull(Object obj){return obj == null;}
                    Predicate<Boolean> predicate = Objects::isNull;
                    System.out.println("[Static 메소드] : "+predicate.test(null));

            //생성자
                //EX
                    //new
                    Supplier<String> supplier1 = String::new;
    }
}

