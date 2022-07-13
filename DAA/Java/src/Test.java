import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int no [] = {12, 21, 32, 45, 52, 63};
        Arrays.stream(no)
                .filter(n -> n%3 == 0)
                .map(n -> ++n)
                .filter(n -> n%8 == 0)
                .forEach(System.out::println);
    }
}