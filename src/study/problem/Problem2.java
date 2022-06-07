package study.problem;

import java.util.Arrays;
import java.util.List;

/**
 * WORDS 참조
 *
 *      1. List에 저장된 단어들의 접두사가 각각 몇개씩 있는지 Map<String, Integer>으로 변환
 *          ex) ("T", 1), ("a", 2) ...
 *      2. List에 저장된 단어들 중에서 단어의 길이가 2 이상인 경우에만, 모든 단어를 대문자로 변환하여 스페이스로 구분한 하나의 문자열로 합한 결과를 반환
 *          ex) ["Hello", "a", "Island", "b"] -> “HI”
 * */
public class Problem2 {

    private final static List<String> WORDS = Arrays.asList("TONY", "a", "hULK", "B", "america", "X", "nebula", "Korea");

    private static int answer1(){
        return 0;
    }

    private static int answer2(){
        return 0;
    }

    public static void main(String[] args) {

    }
}
