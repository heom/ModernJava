package study;

import study.dto.Employee;
import study.dto.Product;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * StreamAPI
 *      1. 특징
 *          * 원본의 데이터를 변경하지 않는다.
 *          * 일회용이다.
 *          * 내부 반복으로 작업을 처리한다.
 *
 *      2. 연산종류
 *          * 생성
 *          * 가공
 *          * 출력
 *
 *      3. Stream 생성
 *          * Collection의 Stream 생성
 *          * 배열의 Stream 생성
 *          * 원시 Stream 생성
 *
 *      4. Stream 가공(중간연산)
 *          * 필터링 - Filter
 *          * 데이터 변환 - Map
 *          * 정렬 - Sorted
 *          * 중복 제거 - Distinct
 *          * 특정 연산 수행 - Peek
 *          * 원시 Stream <-> Stream
 *
 *      5. Stream 출력(최종 연산)
 *          * 최댓값/최솟값/총합/평균/갯수- Max/Min/Sum/Average/Count
 *          * 데이터 수집 - collect
 *              * Collectors.toList()
 *              * Collectors.joining()
 *              * Collectors.averagingInt(), Collectors.summingInt(), Collectors.summarizingInt()
 *              * Collectors.groupingBy()
 *              * Collectors.partitioningBy()
 *          * 조건 검사 - Match
 *              * anyMatch()
 *              * allMatch()
 *              * nonMatch()
 *          * 특정 연산 수행 - forEach
 *
 * */
public class StreamAPI {
    public static void main(String[] args) {
        /**
         * Basic
         * */
                List<String> nameList = Arrays.asList(new String[]{"Hong/", "Choi/", "Kim/"});

                //StreamAPI 미사용
                Collections.sort(nameList);
                for (String name : nameList)
                    System.out.printf(name);
                System.out.println();

                //StreamAPI 사용
                Stream<String> nameStream = nameList.stream();
                nameStream.sorted().forEach(System.out::printf);
                System.out.println();

        /**
         * 특징
         * */
                //원본의 데이터를 변경하지 않는다.
                nameStream = nameList.stream();
                List<String> sortedList = nameStream.sorted().collect(toList());

                //Stream은 일회용이다.
                try{
                    nameStream.sorted().forEach(System.out::print);
                }catch (IllegalStateException e){
                    System.out.println(e.getMessage());
                }

                //내부 반복으로 작업을 처리한다.
                nameStream = nameList.stream();
                nameStream.forEach(System.out::println);

        /**
         * 연산종류
         * */
                //Ex)
                List<String> myList = Arrays.asList("aa", "ab", "ba", "cb", "ca");
                myList
                    .stream()							// 생성
                    .filter(s -> s.startsWith("c"))		// 가공
                    .map(String::toUpperCase)			// 가공
                    .sorted()							// 가공
                    .count();							// 결과

        List<String> list = Arrays.asList("a", "b", "c");

        /**
         * Stream 생성
         * */
                //Collection의 Stream 생성
                Stream<String> listStream = list.stream();

                //배열의 Stream 생성
                Stream<String> arrayStream = Stream.of("a", "b", "c"); //가변인자
                arrayStream = Stream.of(new String[] {"a", "b", "c"});
                arrayStream = Arrays.stream(new String[] {"a", "b", "c"});
                arrayStream = Arrays.stream(new String[] {"a", "b", "c"}, 0, 3); //end범위 포함 x

                //원시 Stream 생성
                IntStream intStream = IntStream.range(4, 10);

        /**
         * Stream 가공(중간연산)
         * */
                //필터링 - Filter
                Stream<String> filterStream = list.stream()
                                            .filter(name -> name.contains("a"));

                //데이터 변환 - Map
                Stream<String> mapStream = list.stream()
                                            .map(s -> s.toUpperCase());
                Stream<File> fileStream = Stream.of(new File("Test1.java")
                                                    , new File("Test2.java")
                                                    , new File("Test3.java"));
                Stream<String> fileNameStream = fileStream.map(File::getName);//Stream<File> --> Stream<String> 변환

                //정렬 - Sorted
                List<String> devList = Arrays.asList("Java", "Scala", "Groovy", "Python", "Go", "Swift");
                Stream<String> sortStream = list.stream().sorted();// [Go, Groovy, Java, Python, Scala, Swift]
                sortStream = list.stream().sorted(Comparator.reverseOrder());// [Swift, Scala, Python, Java, Groovy, Go]

                //중복 제거 - Distinct
                devList = Arrays.asList("Java", "Scala", "Groovy", "Python", "Go", "Swift", "Java");
                Stream<String> distinctStream = list.stream().distinct();// [Java, Scala, Groovy, Python, Go, Swift]
                    //Employee.java 참조 - equals() / hashCode() Override
                Employee e1 = new Employee("MangKyu");
                Employee e2 = new Employee("MangKyu");
                List<Employee> employees = new ArrayList<>();
                employees.add(e1);
                employees.add(e2);
                int size = employees.stream().distinct().collect(Collectors.toList()).size();
                System.out.println(size);

                //특정 연산 수행 - Peek
                int peek = IntStream.of(1, 3, 5, 7, 9)
                                    .peek(System.out::println)
                                    .sum();

                //원시 Stream <-> Stream
                IntStream.range(1, 4)//IntStream -> Stream<Integer>
                                .mapToObj(i -> "a" + i);
                Stream.of(1.0, 2.0, 3.0)//Stream<Double> -> IntStream -> Stream<String>
                                .mapToInt(Double::intValue)
                                .mapToObj(i -> "a" + i);

        /**
         * Stream 출력(최종 연산)
         * */
                //최댓값/최솟값/총합/평균/갯수- Max/Min/Sum/Average/Count
                OptionalInt min = IntStream.of(1, 3, 5, 7, 9).min();
                int max = IntStream.of().max().orElse(0);
                IntStream.of(1, 3, 5, 7, 9).average().ifPresent(System.out::println);
                long count = IntStream.of(1, 3, 5, 7, 9).count();
                long sum = LongStream.of(1, 3, 5, 7, 9).sum();

                //데이터 수집 - collect
                    //collect() : 스트림의 최종연산, 매개변수로 Collector를 필요로 한다.
                    //Collector : 인터페이스, collect의 파라미터는 이 인터페이스를 구현해야한다.
                    //Collectors : 클래스, static메소드로 미리 작성된 컬렉터를 제공한다.
                    //Product.java 참조
                List<Product> productList = Arrays.asList(
                        new Product(23, "potatoes"),
                        new Product(14, "orange"),
                        new Product(13, "lemon"),
                        new Product(23, "bread"),
                        new Product(13, "sugar"));
                    //Collectors.toList()
                    List<String> toListList = productList.stream()
                                            .map(Product::getName)
                                            .collect(Collectors.toList());
                    //Collectors.joining()
                    String joiningList = productList.stream()
                            .map(Product::getName)
                            .collect(Collectors.joining());// potatoesorangelemonbreadsugar
                    joiningList = productList.stream()
                            .map(Product::getName)
                            .collect(Collectors.joining(" "));// potatoes orange lemon bread sugar
                    joiningList = productList.stream()
                            .map(Product::getName)
                            .collect(Collectors.joining(", ", "<", ">"));// <potatoes, orange, lemon, bread, sugar>

                    //Collectors.averagingInt(), Collectors.summingInt(), Collectors.summarizingInt()
                    Double averageAmount = productList.stream()
                            .collect(Collectors.averagingInt(Product::getAmount));//17.2
                    Integer summingAmount = productList.stream()
                            .collect(Collectors.summingInt(Product::getAmount));//86
                    summingAmount = productList.stream()
                            .mapToInt(Product::getAmount)
                            .sum();//86
                    IntSummaryStatistics statistics = productList.stream()
                            .collect(Collectors.summarizingInt(Product::getAmount));//IntSummaryStatistics{count=5, sum=86, min=13, average=17.200000, max=23}

                    //Collectors.groupingBy()
                    Map<Integer, List<Product>> collectorMapOfLists = productList.stream()
                            .collect(Collectors.groupingBy(Product::getAmount));
                    /*
                        {23=[Product{amount=23, name='potatoes'}, Product{amount=23, name='bread'}],
                         13=[Product{amount=13, name='lemon'}, Product{amount=13, name='sugar'}],
                         14=[Product{amount=14, name='orange'}]}
                     */

                    //Collectors.partitioningBy()
                    Map<Boolean, List<Product>> mapPartitioned = productList.stream()
                            .collect(Collectors.partitioningBy(p -> p.getAmount() > 15));
                    /*
                    {false=[Product{amount=14, name='orange'}, Product{amount=13, name='lemon'}, Product{amount=13, name='sugar'}],
                     true=[Product{amount=23, name='potatoes'}, Product{amount=23, name='bread'}]}
                     */

                //조건 검사 - Match
                List<String> names = Arrays.asList("Eric", "Elena", "Java");
                boolean anyMatch = names.stream()
                        .anyMatch(name -> name.contains("a"));//true
                boolean allMatch = names.stream()
                        .allMatch(name -> name.length() > 3);//true
                boolean noneMatch = names.stream()
                        .noneMatch(name -> name.endsWith("s"));//true

                //특정 연산 수행 - forEach
                names.stream()
                        .forEach(System.out::println);
    }
}
