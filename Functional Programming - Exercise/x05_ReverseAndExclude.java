package FunctionalProgramming_Exercise;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class x05_ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

                Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(numbers::push);

        int n = Integer.parseInt(scanner.nextLine());

        numbers.stream().filter(num -> num % n != 0).forEach(num -> System.out.print(num + " "));
    }
}
