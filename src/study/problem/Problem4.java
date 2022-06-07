package study.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Trader / Transaction / init / transactions 참조
 *
 *      1. 2020년에 일어난 모든 거래 내역을 찾아 거래값을 기준으로 오름차순 정렬
 *      2. 거래 내역이 있는 거래자가 근무하는 모든 도시를 중복 없이 나열
 *      3. 서울에서 근무하는 모든 거래자를 찾아서 이름순서대로 정렬
 *      4. 모든 거래자의 이름을 순서대로 정렬
 *      5. 부산에 거래자가 있는지를 확인
 *      6. 서울에 거주하는 거래자의 모든 거래 내역
 *      7. 모든 거래 내역중에서 최댓값과 최솟값을 구하라. 단, 최댓값은 reduce를 이용하고 최솟값은 stream의 min()을 이용
 * */
public class Problem4 {

    private static List<Transaction> transactions = new ArrayList<>();

    private static class Trader {
        private String name;
        private String city;
        public Trader(String name, String city) {
            this.name = name;
            this.city = city;
        }
        public String getName() {
            return name;
        }
        public String getCity() {
            return city;
        }
    }
    private static class Transaction {
        private Trader trader;
        private int year;
        private int value;
        public Transaction(Trader trader, int year, int value) {
            this.trader = trader;
            this.year = year;
            this.value = value;
        }
        public Trader getTrader() {
            return trader;
        }
        public int getYear() {
            return year;
        }
        public int getValue() {
            return value;
        }
    }
    private static void init() {
        Trader kyu = new Trader("Kyu", "Seoul");
        Trader ming = new Trader("Ming", "Gyeonggi");
        Trader hyuk = new Trader("Hyuk", "Incheon");
        Trader hwan = new Trader("Hwan", "Seoul");
        transactions = Arrays.asList(
                new Transaction(kyu, 2019, 30000),
                new Transaction(kyu, 2020, 12000),
                new Transaction(ming, 2020, 40000),
                new Transaction(ming, 2020, 7100),
                new Transaction(hyuk, 2019, 5900),
                new Transaction(hwan, 2020, 4900)
        );
    }

    private static int answer1(){
        return 0;
    }

    private static int answer2(){
        return 0;
    }

    private static int answer3(){
        return 0;
    }

    private static int answer4(){
        return 0;
    }

    private static int answer5(){
        return 0;
    }

    private static int answer6(){
        return 0;
    }

    private static int answer7(){
        return 0;
    }

    public static void main(String[] args) {

    }
}
