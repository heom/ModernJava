package study.problem;

/**
 * Student / init / students 참조
 *      1. students에서 불합격(150점 미만)한 학생의 수를 남자와 여자로 구별(Boolean, List)
 *      2. 각 반별 총점을 학년 별로 나누어 구하여라 (Map<Integer, Map<Integer, Integer>>)
 * */
public class Problem6 {

    private static Student[] students = null;

    private static class Student {
        private String name;
        private boolean isMale; // 성별
        private int hak; // 학년
        private int ban; // 반
        private int score;

        public Student(String name, boolean isMale, int hak, int ban, int score) {
            this.name = name;
            this.isMale = isMale;
            this.hak = hak;
            this.ban = ban;
            this.score = score;
        }
        public String getName() {
            return name;
        }
        public boolean isMale() {
            return isMale;
        }
        public int getHak() {
            return hak;
        }
        public int getBan() {
            return ban;
        }
        public int getScore() {
            return score;
        }
        public String toString() {
            return String.format("[%s, %s, %d학년 %d반, %3d점 ]", name, isMale ? "남" : "여", hak, ban, score);
        }
    }
    private static void init() {
        students = new Student[]{
                new Student("나자바", true, 1, 1, 300),
                new Student("김지미", false, 1, 1, 250),
                new Student("김자바", true, 1, 1, 200),
                new Student("이지미", false, 1, 2, 150),
                new Student("남자바", true, 1, 2, 100),
                new Student("안지미", false, 1, 2, 50),
                new Student("황지미", false, 1, 3, 100),
                new Student("강지미", false, 1, 3, 150),
                new Student("이자바", true, 1, 3, 200),
                new Student("나자바", true, 2, 1, 300),
                new Student("김지미", false, 2, 1, 250),
                new Student("김자바", true, 2, 1, 200),
                new Student("이지미", false, 2, 2, 150),
                new Student("남자바", true, 2, 2, 100),
                new Student("안지미", false, 2, 2, 50),
                new Student("황지미", false, 2, 3, 100),
                new Student("강지미", false, 2, 3, 150),
                new Student("이자바", true, 2, 3, 200)
        };
    }

    private static int answer1(){
        return 0;
    }

    private static int answer2(){
        return 0;
    }

    public static void main(String[] args) {

    }

}
