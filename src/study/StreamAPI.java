package study;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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

                //생성
                //가공
                //출력



    }
}
